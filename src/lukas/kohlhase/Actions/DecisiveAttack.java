package lukas.kohlhase.Actions;

import lukas.kohlhase.*;
import lukas.kohlhase.Charms.CharmCost;
import lukas.kohlhase.Dice.DiceThrow;
import lukas.kohlhase.Items.MeleeWeapon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DecisiveAttack implements Attack {
    private static final Logger logger=Logger.getLogger("mylogger");
    int attackInitiative;
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
        logger.log(Level.FINE,attacker.getName()+" decisive attacked "+defender.getName());
        AttackState state=new AttackState();
        state.initialAttackpool=baseAttackdice;
        attacker.declareDecisiveAttack(state);
        defender.declareDecisiveDV(state);
        state.initialAttackRoll= new DiceThrow(state.changedAttackpool);
        attacker.modifyDecisiveAttackRollAttacker(state);
        defender.modifyDecisiveAttackRollDefender(state);
        state.attackRollSuccesses=state.modifiedAttackRollDefender.evaluateResults(state.AttackRollValuationAttacker);
        logger.log(Level.FINE,attacker.getName()+" rolls "+state.changedAttackpool+" dice against "+defender.getName()+"'s dv of "+state.changedDv+" achieving "+state.attackRollSuccesses+" successes.");
        state.threshholdSuccesses=state.attackRollSuccesses-state.changedDv;
        attacker.changeDecisiveThreshholdAttacker(state);
        defender.changeDecisiveThreshholdDefender(state);
        if(state.thresholdModifiedDefender>=0){//Decisive Attack hit
            logger.log(Level.FINE,attacker.getName()+" hits "+defender.getName());
            state.decisiveRawDamage=attacker.getInitiative();
            attacker.modifyDecisiveHitAttacker(state); //Maybe it's possible to do stuff when you've hit the target. Haven't checked charms yet. Set Initiative for damageRoll
            defender.modifyDecisiveHitDefender(state); //Set stuff like hardness, possibly perfect the attack or w/e.
            if (state.decisiveRawDamageModifiedDefender>=state.hardness){ //Attack does damage
                DiceThrow damageRoll=new DiceThrow(state.decisiveRawDamageModifiedDefender);
                state.damageRoll=damageRoll;
                attacker.modifyDecisiveDamageRollAttacker(state);
                defender.modifyDecisiveDamageRollDefender(state);
                int damagedone=state.damageRollModifiedDefender.evaluateResults(state.damageRollValuation);
                logger.log(Level.FINE,attacker.getName()+" rolled "+state.decisiveRawDamageModifiedDefender+" dice and had "+damagedone+" successes.");
                state.healthDamageDone=damagedone;
                attacker.modifyDecisiveDamageDoneAttacker(state);
                defender.modifyDecisiveDamageDoneDefender(state);
                defender.takeDamage(state.healthDamageDoneModifiedDefender,weapon.damagetype);
                logger.log(Level.FINE,"After the attack "+defender.getName()+" has the following healthlevels");
                defender.getHealth().print();
            }
            else {
                logger.log(Level.FINE,"Attack does no damage, since the hardness was not overcome.");
            }
            attacker.resetBaseInitiative();

        }
        else {
            logger.log(Level.FINE,attacker.getName()+" has missed a decisive attack on "+defender.getName());
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
