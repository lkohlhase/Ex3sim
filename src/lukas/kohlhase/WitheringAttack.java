package lukas.kohlhase;
import java.lang.Math.*;
public class WitheringAttack implements Action{
    CombatActor attacker,defender;
    int baseAttackdice;
    int baseAccuracy;
    CharmCost cost;
    int ignoredArmorSoak=0;
    int attackdice,dv,defsoak, thresholdSuccesses,rawdamage,postsoakdice,overwhelming;
    public  WitheringAttack(CombatActor A, CombatActor B){
        attacker=A;
        defender=B;
        overwhelming=2;
    }
    public WitheringAttack(CombatActor A){
        //TODO: Implement this so that we ask for the target, and then just generate a withering attack that has target set. Essentially command line asking for input here.
    }
    public  WitheringAttack(CombatActor A, CombatActor B,int ov){
        attacker=A;
        defender=B;
        overwhelming=ov;
    }
    public void resolve(){
        /*
        First implementatinon of resolving a withering attack.
         */
        System.out.println(attacker.getName()+" withering attacked "+defender.getName());
        attackdice=attacker.declareWitheringAttack();
        dv=defender.declareWitheringDV(attackdice);
        DiceThrow attackRoll=new DiceThrow(attackdice);
        thresholdSuccesses=attackRoll.evaluateResults()-dv;
        System.out.println(attacker.getName()+" rolled "+(thresholdSuccesses+dv)+" successes on "+attackdice+" dice versus "+defender.getName()+"'s DV of "+dv);
        if (thresholdSuccesses<0){

            Action newaction=attacker.declareWitheringPostMiss();
            newaction.resolve();
        }
        else {
            attacker.gainInitiative(1);
            rawdamage=attacker.declareWitheringPostHit(thresholdSuccesses);
            defsoak=defender.declareSoak(rawdamage);
            postsoakdice=attacker.declarePostSoakAttacker(rawdamage-defsoak);
            System.out.println(defender.getName()+"'s Soak of "+defsoak+" reduced the rawdamage from "+rawdamage+" to "+postsoakdice);
            int postsoakdice2=java.lang.Math.max(defender.declarePostSoakDefender(postsoakdice),overwhelming);

            DiceThrow damageRoll=new DiceThrow(postsoakdice2);
            int initiativechange=damageRoll.evaluateResults();
            System.out.println(attacker.getName()+" rolled "+initiativechange+" successes on "+postsoakdice2+" damage dice.");
            if (initiativechange>defender.getInitiative() && defender.crashbreakable()){ // attacker crashed defender
                attacker.gainInitiative(5);
            }
            attacker.gainInitiative(initiativechange);
            defender.loseInitiative(initiativechange);
        }
    }
}
