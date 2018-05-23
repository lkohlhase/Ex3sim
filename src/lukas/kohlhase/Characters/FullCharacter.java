package lukas.kohlhase.Characters;

import java.util.ArrayList;

import lukas.kohlhase.*;
import lukas.kohlhase.Items.*;
public class FullCharacter implements CombatActor {
    /*
        Intended for inheritance from, so that basic calculations of dicepools etc. from stats is possible
     */
    private int initiative;
    int roundsInCrash=10; //Code for isn't crashed.
    int roundsSinceCrash=10; //Hasn't recently been crashed
    String name;
    ArrayList<CombatActor> enemies=new ArrayList<>();
    ArrayList<CombatActor> allies=new ArrayList<>();
    ArrayList<MeleeWeapon> arnament=new ArrayList<>(); //TODO: Add unarmed attack that every fullcharacter always has.
    Armor armor=new NoArmor(); //If we want a character to have armor, it needs to be explicity set. We can just replace this value with a proper armor.
    Attributes attributes;
    Abilities abilities;
    int temporaryDefenseBonus=0;

    public FullCharacter() { //TODO: Add more Meat to this section, initializing with no skills etc.
        this.arnament.add(new Unarmed());
    }

    public ArrayList<Action> generateMeleeAttacks() {
        /*
        We generate basic attacks from the melee weapons that we have available.
         */
        ArrayList<Action> possibleattacks = new ArrayList();
        for (CombatActor enemy : enemies) { //Generate an attack option for every weapon and every enemy you have.
            for (MeleeWeapon weapon : arnament) {
                for (String possibility : weapon.usablewith) {

                    if (weapon.usablewith.contains(MeleeWeapon.WeaponTags.MELEE) && !possibility.equals("IMPROVISEDBRAWL")) { //If the weapon can be used with Melee, then make melee versions of every attack.
                        WitheringAttack temp = new WitheringAttack(this, enemy);
                        temp.baseAccuracy = weapon.getAccuracy();
                        temp.baseAttackdice = this.attributes.Dexterity + this.abilities.Melee;
                        temp.cost.TempDefence = weapon.getDefense();
                        temp.weapon=weapon;
                        switch (possibility) {
                            case "BRAWL":
                                break;
                            case "CHOPPING":
                                temp.cost.TempDefence--;
                            case "DISARMING":
                                //TODO: Implement when we do disarming stuff. Essentially generate a completely new disarming attack with the weapon here.
                                break;
                            case "IMPROVISEDMELEE":
                                temp.cost.Initiative += 1;
                            case "GRAPPLING":
                                break; //TODO: Implement when we do grappling stuff (aka never)
                            case "MELEE":
                                break; //Baseline version needs no modification
                            case "MARTIAL":
                                break; //Implement when we actually include martial arts
                            case "PIERCING":
                                temp.ignoredArmorSoak = 4;
                                temp.cost.Initiative += 1;
                            case "SMASHING":
                                temp.cost.TempDefence -= 2;
                                temp.cost.Initiative += 2;
                            case "THROWN":
                                break; //TODO: Implement whenever we get around to doing this. Not sure we'll ever add this tag. Probably will just manually add Thrown weapons and add stuff here.
                        }
                        possibleattacks.add(temp);
                    }
                    if (weapon.usablewith.contains(MeleeWeapon.WeaponTags.BRAWL) && !possibility.equals("IMPROVISEDMELEE")) { //If the weapon can be used with Melee, then make BRAWL versions of every attack.
                        WitheringAttack temp = new WitheringAttack(this, enemy);
                        temp.baseAccuracy = weapon.getAccuracy();
                        temp.baseAttackdice = this.attributes.Dexterity + this.abilities.Brawl; //TODO: Implement specialties.
                        temp.weapon=weapon;
                        switch (possibility) {
                            case "BRAWL":
                                break;
                            case "CHOPPING":
                                temp.cost.TempDefence--;
                            case "DISARMING":
                                //TODO: Implement when we do disarming stuff. Essentially generate a completely new disarming attack with the weapon here.
                                break;
                            case "IMPROVISEDBRAWL":
                                temp.cost.Initiative += 1;
                            case "GRAPPLING":
                                break; //TODO: Implement when we do grappling stuff (aka never)
                            case "MELEE":
                                break; //Baseline version needs no modification
                            case "MARTIAL":
                                break; //Implement when we actually include martial arts
                            case "PIERCING":
                                temp.ignoredArmorSoak = 4;
                                temp.cost.Initiative += 1;
                            case "SMASHING":
                                temp.cost.TempDefence -= 2;
                                temp.cost.Initiative += 2;
                            case "THROWN":
                                break; //TODO: Implement whenever we get around to doing this. Not sure we'll ever add this tag. Probably will just manually add Thrown weapons and add stuff here.
                        }

                        //TODO: Generate decisive attacks here as well.

                    }
                }
            }

        }
        return possibleattacks;
    }


    public void changeInitiative(int x){
        if (x>0){
            this.gainInitiative(x);
        }
        else {
            this.loseInitiative(x);
        }
    }
    public void gainInitiative(int x){
        if (x<0){
            System.out.println("Attempting to gain a negative amount of initiative. Please fix");
        }
        else {
            if (initiative<0 && x>=initiative ){//Leaving crash
                roundsInCrash=10;
                roundsSinceCrash=-1;
            }
            initiative+=x;
        }

    }
    public void loseInitiative(int x){
        if (x<0){
            System.out.println("Attempting to lose a negative amount of initiative. Please fix");
        }
        else {
            if(x>initiative && roundsInCrash>=10){ //Person wasn't in crash before, and was just crashed
                roundsInCrash=1;
                initiative-=x;
                roundsSinceCrash=-5;
            }
            else {//Just standard initiative loss
                initiative-=x;

            }
        }
    }

    public int getInitiative(){
        return initiative;
    }
    public void setInitiative(int x){ //Only intended to be used for resetting initiative
        initiative=x;
    }

    @Override
    public int declareWitheringAttack() {
        return 0;
    }

    @Override
    public int declareDecisiveAttack() {
        return 0;
    }

    @Override
    public int declareWitheringDV(int x) {
        return 0;
    }

    @Override
    public int declareDecisiveDV(int x) {
        return 0;
    }

    @Override
    public int declareWitheringPostHit(int thresholdsuccesses) {
        return 0;
    }

    @Override
    public int declareDecisivePostHit(int x, int y) {
        return 0;
    }

    @Override
    public Action declareWitheringPostMiss() {
        return null;
    }

    @Override
    public Action declareDecisivePostMiss() {
        return null;
    }

    @Override
    public int declareSoak(int thresholdsuccesses) {
        return 0;
    }

    @Override
    public int declarePostSoakDefender(int postsoaksuccesses) {
        return 0;
    }

    @Override
    public int declarePostSoakAttacker(int postsoaksuccesses) {
        return 0;
    }

    @Override
    public void endOfRound() {

    }

    @Override
    public boolean crashbreakable() {
        return false;
    }

    @Override
    public int declareJoinBattle() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String a) {

    }

    @Override
    public int declareHardness() {
        return 0;
    }

    @Override
    public HealthLevel getHealth() {
        return null;
    }

    @Override
    public void setHealth(HealthLevel a) {

    }

    @Override
    public void takeDamage(int b, damageType x) {

    }

    @Override
    public Action chooseAction(CombatActor[] actors) {
        return null;
    }

    @Override
    public void addEnemy(CombatActor a) {
        if(!enemies.contains(a)){
            enemies.add(a);
        }
    }

    @Override
    public void addAlly(CombatActor a) {
        if(!allies.contains(a)){
            allies.add(a);
        }
    }

    @Override
    public void removeEnemy(CombatActor a) {
        enemies.remove(a);
    }

    @Override
    public void removeAlly(CombatActor a) {
        allies.remove(a);
    }

    @Override
    public void setEnemies(ArrayList<CombatActor> a) {
        enemies=a;
    }

    @Override
    public void setAllies(ArrayList<CombatActor> a) {
        allies=a;
    }
//================================== Response to Withering Attacks here ===============================================================
    /*
    Since hthis is the default implementation, it does no strategical stuff and does not use any charms.
     */
    @Override
    public void declareWitheringAttack(AttackState x) {
        x.changedAttackpool=x.initialAttackpool;
    }

    @Override
    public void declareWitheringDV(AttackState x) {
        int parryDV=(attributes.Dexterity+Math.max(abilities.Melee,abilities.Brawl)/2)+temporaryDefenseBonus; //We round down, so just using integer division here is fine.
        int dodgeDV=(attributes.Dexterity+abilities.Dodge)/2+temporaryDefenseBonus-armor.getMobilityPenalty();
        x.initialDv=Math.max(parryDV,dodgeDV); //Choose the higher one always.
        x.changedDv=x.initialDv;
    }

    @Override
    public void modifyWitheringAttackRollAttacker(AttackState x) {
        x.modifiedAttackRollAttacker =new DiceThrow(x.initialAttackRoll);
        x.AttackRollValuationAttacker =new Rollvaluation(); //Just the default rollvaluation that mortals use.
    }

    @Override
    public void modifyWitheringAttackRollDefender(AttackState x) {
        x.modifiedAttackRollDefender =new DiceThrow(x.modifiedAttackRollAttacker);
    }

    @Override
    public void changeWitheringThreshholdAttacker(AttackState x) {
        x.thresholdModifiedAttacker=x.threshholdSuccesses;
    }

    @Override
    public void changeWitheringThreshholdDefender(AttackState x) {
        x.thresholdModifiedDefender=x.thresholdModifiedAttacker;
    }

    @Override
    public void modifyWitheringRawDamageAttacker(AttackState x) {
        x.rawDamage=attributes.Strength+x.weaponDamage+x.thresholdModifiedDefender;
        x.rawDamageModifiedAttacker=x.rawDamage;
    }

    @Override
    public void modifyWitheringRawDamageDefender(AttackState x) {
        x.rawDamageModifiedDefender=x.rawDamageModifiedAttacker;
        x.defenderNaturalSoak=attributes.Stamina;
        x.defenderArmorSoak=0; //TODO: Implement Armor and then add the proper value here.
    }

    @Override
    public void modifyTotalSoakAttacker(AttackState x) {
        x.totalSoakModifiedAttacker=x.totalSoak;
    }

    @Override
    public void modifyTotalSoakDefender(AttackState x) {
        x.totalSoakModifiedDefender=x.totalSoakModifiedAttacker;
    }

    @Override
    public void declarePostSoakAttacker(AttackState x) {
        x.postSoakSuccessesModifiedAttacker=x.postSoakSuccesses;
    }

    @Override
    public void declarePostSoakDefender(AttackState x) {
        x.postSoakSuccessesModifiedDefender=x.postSoakSuccessesModifiedAttacker;
    }

    @Override
    public void modifyWitheringDamageRollAttacker(AttackState x) {
        x.damageRollModifiedAttacker=new DiceThrow(x.damageRoll);
        x.damageRollValuation=new Rollvaluation(); //Default values again
    }

    @Override
    public void modifyWitheringDamageRollDefender(AttackState x) {
        x.damageRollModifiedDefender=new DiceThrow(x.damageRollModifiedAttacker);
    }

    @Override
    public void modifyInitiativeDamageAttacker(AttackState x) {
        x.initiativeDamageDoneModifiedAttacker=x.initiativeDamageDone;
    }

    @Override
    public void modifyInitiativeDamageDefender(AttackState x) {
        x.initiativeDamageDoneModifiedDefender=x.initiativeDamageDoneModifiedAttacker;
        x.defenderCrashed= (x.initiativeDamageDoneModifiedDefender>initiative && this.crashbreakable());

    }

    @Override
    public void updateInitiativeAttacker(AttackState x) {
        this.gainInitiative(1); //Opponent was hit
        if(x.defenderCrashed){
            this.gainInitiative(5);
        }
        this.changeInitiative(x.initiativeDamageDoneModifiedDefender);
        x.attackerCrashed=(initiative<=0 && this.crashbreakable());

    }

    @Override
    public void updateInitiativeDefender(AttackState x) {
        if (x.defenderCrashed)
            this.gainInitiative(5);
        this.changeInitiative(x.initiativeDamageDoneModifiedDefender);
    }

    @Override
    public void failedWitheringAttackAttacker(AttackState x) {
        //Default response to missing your attack is just to shout unluckers and be done with it.
    }

    @Override
    public void failedWitheringAttackDefender(AttackState x) {
        //Default response to opponent missing his attack is to LUL and be done with it.
    }

    @Override
    public void declareDecisiveAttack(AttackState x) {
        x.changedAttackpool=x.initialAttackpool; //Default is no change in attack pool
    }

    @Override
    public void declareDecisiveDV(AttackState x) {//Exactly the same as withering dv
        int parryDV=(attributes.Dexterity+Math.max(abilities.Melee,abilities.Brawl)/2)+temporaryDefenseBonus; //We round down, so just using integer division here is fine.
        int dodgeDV=(attributes.Dexterity+abilities.Dodge)/2+temporaryDefenseBonus-armor.getMobilityPenalty();
        x.initialDv=Math.max(parryDV,dodgeDV); //Choose the higher one always.
        x.changedDv=x.initialDv;
    }

    @Override
    public void modifyDecisiveAttackRollAttacker(AttackState x) {
        x.modifiedAttackRollAttacker =new DiceThrow(x.initialAttackRoll);
        x.AttackRollValuationAttacker =new Rollvaluation(); //Standard dice throw
    }

    @Override
    public void modifyDecisiveAttackRollDefender(AttackState x) {
        x.modifiedAttackRollDefender =x.modifiedAttackRollAttacker;
    }

    @Override
    public void changeDecisiveThreshholdAttacker(AttackState x) {
        x.thresholdModifiedAttacker=x.threshholdSuccesses;
    }

    @Override
    public void changeDecisiveThreshholdDefender(AttackState x) {
        x.thresholdModifiedDefender=x.thresholdModifiedAttacker;
    }

    @Override
    public void modifyDecisiveHitAttacker(AttackState x) {
        x.decisiveRawDamage=this.initiative;
        x.decisiveRawDamageModifiedAttacker=x.decisiveRawDamage;
    }

    @Override
    public void modifyDecisiveHitDefender(AttackState x) {
        x.hardness=this.armor.getHardness();
        x.decisiveRawDamageModifiedDefender=x.decisiveRawDamageModifiedAttacker;
    }

    @Override
    public void modifyDecisiveDamageRollAttacker(AttackState x) {
        x.damageRollModifiedAttacker=x.damageRoll;

    }

    @Override
    public void modifyDecisiveDamageRollDefender(AttackState x) {
        x.damageRollModifiedDefender=x.damageRollModifiedAttacker;
    }

    @Override
    public void resetBaseInitiative(AttackState x) {
        this.initiative=3;
    }

    @Override
    public void modifyDecisiveDamageDoneAttacker(AttackState x) {
        x.healthDamageDoneModifiedAttacker=x.healthDamageDone;
    }

    @Override
    public void modifyDecisiveDamageDoneDefender(AttackState x) {
        x.healthDamageDoneModifiedDefender=x.healthDamageDoneModifiedAttacker;
    }

    @Override
    public void declareDecisivePostMissAttacker(AttackState x) {
        if(this.initiative>11){
            this.loseInitiative(2);
        }
        else{
            this.loseInitiative(1);
        }
    }

    @Override
    public void declareDecisivePostMissDefender(AttackState x) {
        //Do nothing
    }
}
