package lukas.kohlhase.Actions;

import lukas.kohlhase.*;
import lukas.kohlhase.Dice.DecisiveValuation;
import lukas.kohlhase.Dice.DiceThrow;
import lukas.kohlhase.Items.MeleeWeapon;

public class DecisiveAttack implements Attack {
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
        System.out.println(attacker.getName()+" rolls "+state.changedAttackpool+" dice against "+defender.getName()+"'s dv of "+state.changedDv+" achieving "+state.attackRollSuccesses+" successes.");
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
    public Boolean isWhithering(){
        return false;
    }
    public Boolean isDecisive(){
        return true;
    }
}
