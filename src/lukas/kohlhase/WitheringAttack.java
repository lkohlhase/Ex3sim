package lukas.kohlhase;
import java.lang.Math.*;
public class WitheringAttack implements Action{
    CombatActor attacker,defender;
    MeleeWeapon weapon;
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
    public void resolve2(){
        /*
        This will eventually replace resolve(), and is being reworked to work with the attackstate idea of things.
         */
        //TODO: Possibly break this sort of stuff into different functions

        AttackState state=new AttackState();
        state.weaponDamage=weapon.getDamage();
        state.initialAttackpool=baseAttackdice+baseAccuracy;
        attacker.declareWitheringAttack(state); // If the attacker wants to change the pool, he modifies the state accordingly.
        defender.declareWitheringDV(state); // Defender declares their dv against this specific attack. This sets both initialdv and changedDv
        DiceThrow attackRoll=new DiceThrow(state.changedAttackpool);
        state.initialAttackRoll=attackRoll;
        attacker.AttackerModifyAttackRoll(state); //This sets stuff like attackerModifiedAttackRoll and AttackerRollValuation
        defender.DefenderModifyAttackRoll(state); //This sets defender defenderModifiedAttackRoll
        state.attackRollSuccesses=state.defenderModifiedAttackRoll.evaluateResults(state.AttackerAttackRollValuation);
        state.threshholdSuccesses=state.attackRollSuccesses-state.changedDv;
        attacker.changeThreshholdAttacker(state); //This sets thresholdModifiedAttacker
        defender.changeThreshholdDefender(state); //This sets thresholdModifiedDefender
        if(state.thresholdModifiedDefender>=0) {
            attacker.modifyRawDamageAttacker(state); //Sets normal raw damage, based on strength and weapon damage, and then sets rawDamagemModifiedAttacker
            defender.modifyRawDamageDefender(state); //this sets rawDamageModifiedDefender, and sets up the various soak values, so natural soak and armor soak.
            state.totalSoak = Math.max(state.defenderArmorSoak - ignoredArmorSoak, 0) + state.defenderNaturalSoak; //TODO: Check whether this is the actual soak formula.
            attacker.modifyTotalSoakAttacker(state); //This sets totalSoakmodifiedAttacker. Don't think this actually has support in the solar charmset, but giving opportunities to work with.
            defender.modifyTotalSoakDefender(state); // This sets totalSoakmodifiedDefender.
            state.postSoakSuccesses=Math.max(state.rawDamageModifiedDefender-state.totalSoakModifiedDefender,weapon.getOverwhelming());
            attacker.declarePostSoakAttacker(state); //sets postSoakSuccessesModifiedAttacker
            defender.declarePostSoakDefender(state); //sets postSoakSuccessesModifiedDefender
            DiceThrow droll=new DiceThrow(state.postSoakSuccessesModifiedDefender);
            state.damageRoll=droll;
            attacker.modifyDamageRollAttacker(state); //sets damageRollmodifiedAttacker and damageRollvValuation
            defender.modifyDamageRollDefender(state); //sets damageRollmodifiedDefender
            state.initiativeDamageDone=state.damageRollModifiedDefender.evaluateResults(state.damageRollValuation);
            attacker.modifyInitiativeDamageAttacker(state);
            defender.modifyInitiativeDamageDefender(state); //Since this is the last change of initiative, we can check whether the defender was crashed here.
            attacker.updateInitiativeAttacker(state);
            defender.updateInitiativeDefender(state);//Here we should handle all the initiative changes respectively, with checking if people are crashed etc.
        }
        else{
            attacker.failedAttackAttacker(state);
            defender.failedAttackDefender(state);
        }

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
