package lukas.kohlhase.Actions;

import lukas.kohlhase.*;
import lukas.kohlhase.Dice.DecisiveValuation;
import lukas.kohlhase.Dice.DiceThrow;
import lukas.kohlhase.Items.MeleeWeapon;

public class DecisiveAttack implements Action {
    int attackInitiative,attackdice,dv,thresholdSuccesses,rawdamage,hardness;
    CombatActor attacker,defender;
    damageType damagetype;
    public int baseAttackdice;
    public MeleeWeapon weapon;
    public CharmCost cost;
    public DecisiveAttack(CombatActor A,CombatActor B){
        attacker=A;
        defender=B;
        attackInitiative=attacker.getInitiative();
        damagetype= damageType.LETHAL;
    }
    public DecisiveAttack(CombatActor A, CombatActor B, int ini, damageType type){
        attacker=A;
        defender=B;
        attackInitiative=ini;
        damagetype=type;
    }
    public void resolve(){
        /*
        Same deal as with resolve2() in WitheringAttack, currently put in so that I can keep the old structure intact, and rebuild with
         */
        System.out.println(attacker.getName()+" decisive attacked "+defender.getName());
        AttackState state=new AttackState();
        state.initialAttackpool=baseAttackdice;
        attacker.declareDecisiveAttack(state);
        defender.declareDecisiveDV(state);
        DiceThrow attackRoll=new DiceThrow(state.changedAttackpool);
        state.initialAttackRoll=attackRoll;
        attacker.modifyDecisiveAttackRollAttacker(state);
        defender.modifyDecisiveAttackRollDefender(state);
        state.attackRollSuccesses=state.modifiedAttackRollDefender.evaluateResults(state.AttackRollValuationAttacker);
        state.threshholdSuccesses=state.attackRollSuccesses-state.changedDv;
        attacker.changeDecisiveThreshholdAttacker(state);
        defender.changeDecisiveThreshholdDefender(state);
        if(state.thresholdModifiedDefender>=0){//Decisive Attack hit
            state.decisiveRawDamage=attacker.getInitiative();
            attacker.modifyDecisiveHitAttacker(state); //Maybe it's possible to do stuff when you've hit the target. Haven't checked charms yet. Set Initiative for damageRoll
            defender.modifyDecisiveHitDefender(state); //Set stuff like hardness, possibly perfect the attack or w/e.
            if (state.decisiveRawDamageModifiedDefender>=state.hardness){ //Attack does damage.
                DiceThrow damageRoll=new DiceThrow(state.decisiveRawDamageModifiedDefender);
                state.damageRoll=damageRoll;
                attacker.modifyDecisiveDamageRollAttacker(state);
                defender.modifyDecisiveDamageRollDefender(state);
                int damagedone=state.damageRollModifiedDefender.evaluateResults(state.damageRollValuation);
                state.healthDamageDone=damagedone;
                attacker.modifyDecisiveDamageDoneAttacker(state);
                defender.modifyDecisiveDamageDoneDefender(state);
                defender.takeDamage(state.healthDamageDoneModifiedDefender,weapon.damagetype);
            }
            attacker.resetBaseInitiative(state);

        }
        else {
            attacker.declareDecisivePostMissAttacker(state);//Handles the attacker losing initiative for a miss.
            defender.declareDecisivePostMissDefender(state);
        }

    }
    public void resolve2(){
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
            if(rawdamage>hardness){//You're actually doing damageType with the attack
                DiceThrow damageRoll=new DiceThrow(rawdamage);
                int damage=damageRoll.evaluateResults(new DecisiveValuation());
                defender.takeDamage(damage,damagetype);
                attacker.setInitiative(3);
            }
        }
    }
}
