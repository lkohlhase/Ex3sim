package lukas.kohlhase.Actions;
import lukas.kohlhase.AttackState;
import lukas.kohlhase.CharmCost;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.Dice.DiceThrow;
import lukas.kohlhase.Items.MeleeWeapon;

public class WitheringAttack implements Attack{
    public CombatActor attacker,defender;
    public MeleeWeapon weapon;
    public int baseAttackdice;
    public int baseAccuracy;
    public int woundpenalty;
    public CharmCost cost;
    public int ignoredArmorSoak=0;
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
        This will eventually replace resolve(), and is being reworked to work with the attackstate idea of things.
         */
        //TODO: Possibly break this sort of stuff into different functions
        System.out.println(attacker.getName()+" withering attacked "+defender.getName());
        AttackState state=new AttackState();
        state.weaponDamage=weapon.getDamage();
        state.initialAttackpool=baseAttackdice+baseAccuracy-woundpenalty;
        attacker.declareWitheringAttack(state); // If the attacker wants to change the pool, he modifies the state accordingly.
        defender.declareWitheringDV(state); // Defender declares their dv against this specific attack. This sets both initialdv and changedDv
        state.initialAttackRoll= new DiceThrow(state.changedAttackpool);
        attacker.modifyWitheringAttackRollAttacker(state); //This sets stuff like modifiedAttackRollAttacker and AttackerRollValuation
        defender.modifyWitheringAttackRollDefender(state); //This sets defender modifiedAttackRollDefender
        state.attackRollSuccesses=state.modifiedAttackRollDefender.evaluateResults(state.AttackRollValuationAttacker);
        state.threshholdSuccesses=state.attackRollSuccesses-state.changedDv;
        System.out.println(attacker.getName()+" rolled "+state.changedAttackpool+" dice against "+defender.getName()+"'s dv of "+state.changedDv+" and gained "+state.attackRollSuccesses+" successes.");
        attacker.changeWitheringThreshholdAttacker(state); //This sets thresholdModifiedAttacker
        defender.changeWitheringThreshholdDefender(state); //This sets thresholdModifiedDefender
        if(state.thresholdModifiedDefender>=0) {
            System.out.println(attacker.getName()+" hit "+defender.getName()+" with "+state.thresholdModifiedDefender+" threshhold successes.");
            attacker.modifyWitheringRawDamageAttacker(state); //Sets normal raw damageType, based on strength and weapon damageType, and then sets rawDamagemModifiedAttacker
            defender.modifyWitheringRawDamageDefender(state); //this sets rawDamageModifiedDefender, and sets up the various soak values, so natural soak and armor soak.
            System.out.println("The raw damage of the attack is: "+state.rawDamageModifiedDefender);
            state.totalSoak = Math.max(state.defenderArmorSoak - ignoredArmorSoak, 0) + state.defenderNaturalSoak; //
            attacker.modifyTotalSoakAttacker(state); //This sets totalSoakmodifiedAttacker. Don't think this actually has support in the solar charmset, but giving opportunities to work with.
            defender.modifyTotalSoakDefender(state); // This sets totalSoakmodifiedDefender.
            state.postSoakSuccesses=Math.max(state.rawDamageModifiedDefender-state.totalSoakModifiedDefender,weapon.getOverwhelming());
            System.out.println(state.totalSoakModifiedDefender+" damage is soaked, leading to post soak dice of "+state.postSoakSuccesses);
            attacker.declarePostSoakAttacker(state); //sets postSoakSuccessesModifiedAttacker
            defender.declarePostSoakDefender(state); //sets postSoakSuccessesModifiedDefender
            DiceThrow droll=new DiceThrow(state.postSoakSuccessesModifiedDefender);
            state.damageRoll=droll;
            attacker.modifyWitheringDamageRollAttacker(state); //sets damageRollmodifiedAttacker and damageRollvValuation
            defender.modifyWitheringDamageRollDefender(state); //sets damageRollmodifiedDefender
            state.initiativeDamageDone=state.damageRollModifiedDefender.evaluateResults(state.damageRollValuation);
            System.out.println(attacker.getName()+" rolls "+state.postSoakSuccessesModifiedDefender+" dice and achieves "+state.initiativeDamageDone+" successes.");
            attacker.modifyInitiativeDamageAttacker(state);
            defender.modifyInitiativeDamageDefender(state); //Since this is the last change of initiative, we can check whether the defender was crashed here.
            attacker.updateInitiativeAttacker(state);
            defender.updateInitiativeDefender(state);//Here we should handle all the initiative changes respectively, with checking if people are crashed etc.
        }
        else{
            attacker.failedWitheringAttackAttacker(state);
            defender.failedWitheringAttackDefender(state);
        }

    }

    public Boolean isWhithering(){
        return true;
    }
    public Boolean isDecisive(){
        return false;
    }
}
