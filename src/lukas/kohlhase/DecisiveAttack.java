package lukas.kohlhase;

public class DecisiveAttack implements Action {
    int attackInitiative,attackdice,dv,thresholdSuccesses,rawdamage,hardness;
    CombatActor attacker,defender;
    HealthLevel.damage damagetype;
    public DecisiveAttack(CombatActor A,CombatActor B){
        attacker=A;
        defender=B;
        attackInitiative=attacker.getInitiative();
        damagetype= HealthLevel.damage.LETHAL;
    }
    public DecisiveAttack(CombatActor A, CombatActor B, int ini, HealthLevel.damage type){
        attacker=A;
        defender=B;
        attackInitiative=ini;
        damagetype=type;
    }
    public void resolve(){
        System.out.println(attacker.getName()+" decisive attacked "+defender.getName());
        attackdice=attacker.declareDecisiveAttack();
        dv=defender.declareDecisiveDV(attackdice);
        DiceThrow attackRoll=new DiceThrow(attackdice);
        thresholdSuccesses=attackRoll.evaluateResults()-dv;
        System.out.println(attacker.getName()+" rolled "+(thresholdSuccesses+dv)+" successes on "+attackdice+" dice versus "+defender.getName()+"'s DV of "+dv);
        if (thresholdSuccesses<0){

            Action newaction=attacker.declareDecisivePostMiss();
            newaction.resolve();
            if (attackInitiative<10){
                attacker.loseInitiative(2);
            }
            else {
                attacker.loseInitiative(3);
            }
        }
        else {
            rawdamage=attacker.declareDecisivePostHit(thresholdSuccesses,attackInitiative);
            hardness=defender.declareHardness();
            if(rawdamage>hardness){//You're actually doing damage with the attack
                DiceThrow damageRoll=new DiceThrow(rawdamage);
                int damage=damageRoll.evaluateResults(new DecisiveValuation());
                defender.takeDamage(damage,damagetype);
                attacker.setInitiative(3);
            }
        }
    }
}
