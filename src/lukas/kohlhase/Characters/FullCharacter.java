package lukas.kohlhase.Characters;

import java.util.ArrayList;

import lukas.kohlhase.*;
import lukas.kohlhase.Actions.*;
import lukas.kohlhase.Dice.DecisiveValuation;
import lukas.kohlhase.Dice.DiceThrow;
import lukas.kohlhase.Dice.Rollvaluation;
import lukas.kohlhase.Items.*;
public class FullCharacter implements CombatActor {
    /*
        Intended for inheritance from, so that basic calculations of dicepools etc. from stats is possible
     */
    private int initiative;
    int roundsInCrash=10; //Code for isn't crashed.
    int roundsSinceCrash=10; //Hasn't recently been crashed
    String name;
    ArrayList<CombatActor> enemies=new ArrayList<>(); //This is generated when we make the CombatScene.
    ArrayList<CombatActor> allies=new ArrayList<>(); //Same here
    ArrayList<MeleeWeapon> arnament=new ArrayList<>();
    Armor armor=new NoArmor(); //If we want a character to have armor, it needs to be explicitly set. We can just replace this value with a proper armor.
    public Attributes attributes;
    public Abilities abilities;
    int temporaryDefenseBonus=0;
    HealthLevel health=new HealthLevel();

    public FullCharacter() {
        this.arnament.add(new MeleeWeaponFactory().Unarmed());
        this.abilities= new Abilities();
        this.attributes= new Attributes();
        this.name="FullCharacter"+java.util.UUID.randomUUID().toString(); //This ensures uniqueness. Might just randomly generate a recognizable name though.
        this.initiative=3;
    }
    public FullCharacter(String name){
        this.arnament.add(new MeleeWeaponFactory().Unarmed());
        this.abilities= new Abilities();
        this.attributes= new Attributes();
        this.name=name; //This ensures uniqueness. Might just randomly generate a recognizable name though.
        this.initiative=3;
        this.armor=new NoArmor();
    }

    public FullCharacter(String name, Attributes attributes, Abilities abilities) {
        this.arnament.add(new MeleeWeaponFactory().Unarmed());
        this.name = name;
        this.attributes = attributes;
        this.abilities = abilities;
        this.initiative=3;
    }

    public ArrayList<Attack> generateMeleeAttacks() {
        /*
        We generate basic attacks from the melee weapons that we have available.
         */
        ArrayList<Attack> possibleattacks = new ArrayList<Attack>();
        for (CombatActor enemy : enemies) { //Generate an attack option for every weapon and every enemy you have.
            for (MeleeWeapon weapon : arnament) {
                for (String possibility : weapon.usablewith) {

                    if (weapon.usablewith.contains("MELEE") && !possibility.equals("IMPROVISEDBRAWL")) { //If the weapon can be used with Melee, then make melee versions of every attack.
                        WitheringAttack tempWithering = new WitheringAttack(this, enemy);


                        tempWithering.baseAccuracy = weapon.getAccuracy();
                        tempWithering.baseAttackdice = this.attributes.Dexterity + this.abilities.Melee;
                        tempWithering.cost.TempDefence = weapon.getDefense();
                        tempWithering.weapon=weapon;
                        tempWithering.woundpenalty=this.health.woundpenalty();
                        switch (possibility) {
                            case "BRAWL":
                                break;
                            case "CHOPPING":
                                tempWithering.cost.TempDefence--;
                            case "DISARMING":
                                //TODO: Implement when we do disarming stuff. Essentially generate a completely new disarming attack with the weapon here.
                                break;
                            case "IMPROVISEDMELEE":
                                tempWithering.cost.Initiative += 1;
                            case "GRAPPLING":
                                break; //TODO: Implement when we do grappling stuff (aka never)
                            case "MELEE":
                                break; //Baseline version needs no modification
                            case "MARTIAL":
                                break; //Implement when we actually include martial arts
                            case "PIERCING":
                                tempWithering.ignoredArmorSoak = 4;
                                tempWithering.cost.Initiative += 1;
                            case "SMASHING":
                                tempWithering.cost.TempDefence -= 2;
                                tempWithering.cost.Initiative += 2;
                            case "THROWN":
                                break; //TODO: Implement whenever we get around to doing this. Not sure we'll ever add this tag. Probably will just manually add Thrown weapons and add stuff here.
                        }
                        possibleattacks.add(tempWithering);
                    }
                    if (weapon.usablewith.contains("BRAWL") && !possibility.equals("IMPROVISEDMELEE")) { //If the weapon can be used with Melee, then make BRAWL versions of every attack.
                        WitheringAttack tempWitheringB = new WitheringAttack(this, enemy);
                        tempWitheringB.baseAccuracy = weapon.getAccuracy();
                        tempWitheringB.baseAttackdice = this.attributes.Dexterity + this.abilities.Brawl; //TODO: Implement specialties.
                        tempWitheringB.weapon=weapon;
                        tempWitheringB.woundpenalty=this.health.woundpenalty();
                        switch (possibility) {
                            case "BRAWL":
                                break;
                            case "CHOPPING":
                                tempWitheringB.cost.TempDefence--;
                            case "DISARMING":
                                //TODO: Implement when we do disarming stuff. Essentially generate a completely new disarming attack with the weapon here.
                                break;
                            case "IMPROVISEDBRAWL":
                                tempWitheringB.cost.Initiative += 1;
                            case "GRAPPLING":
                                break; //TODO: Implement when we do grappling stuff (aka never)
                            case "MELEE":
                                break; //Baseline version needs no modification
                            case "MARTIAL":
                                break; //Implement when we actually include martial arts
                            case "PIERCING":
                                tempWitheringB.ignoredArmorSoak = 4;
                                tempWitheringB.cost.Initiative += 1;
                            case "SMASHING":
                                tempWitheringB.cost.TempDefence -= 2;
                                tempWitheringB.cost.Initiative += 2;
                            case "THROWN":
                                break; //TODO: Implement whenever we get around to doing this. Not sure we'll ever add this tag. Probably will just manually add Thrown weapons and add stuff here.
                        }
                    possibleattacks.add(tempWitheringB);

                    }


                }
            DecisiveAttack murder=new DecisiveAttack(this,enemy,this.initiative,weapon.damagetype); //There is only one possible decisive attack with every weapon.
            if (weapon.usablewith.contains("MELEE")){
                murder.baseAttackdice=this.abilities.Melee+this.attributes.Dexterity-this.health.woundpenalty();
                }
            else if (weapon.usablewith.contains("BRAWL")){
                murder.baseAttackdice=this.abilities.Brawl+this.attributes.Dexterity-this.health.woundpenalty();

            }
            murder.weapon=weapon;
            possibleattacks.add(murder);
            }

        }
        return possibleattacks;
    }


    public void changeInitiative(int x){
        if (x>0){
            this.gainInitiative(x);
        }
        else {
            this.loseInitiative(-x);
        }
    }
    public void gainInitiative(int x){
        if (x<0){
            System.out.println("Attempting to gain a negative amount of initiative. Please fix");
        }
        else {
            if (initiative<0 && x+initiative>=0 ){//Leaving crash
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
                initiative-=x;
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
    public boolean crashbreakable() { //TODO: Implement this properly
        return roundsSinceCrash > 3;
    }

    @Override
    public int declareJoinBattle() {
        return this.abilities.Awareness+this.attributes.Wits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String a) {
        this.name=a;
    }


    @Override
    public HealthLevel getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(HealthLevel a) {
        this.health=a;
    }

    @Override
    public void takeDamage(int b, damageType x) {
        this.health.takeDamage(b,x);
    }

    @Override
    public Action chooseAction(CombatActor[] actors) { //FullCharacter is really only an interface that we want to inherit from, so it shouldn't actually be used for choosing actions.
        return new DoNothing();
    }

    public void addEnemy(CombatActor a) {
        if(!enemies.contains(a)){
            enemies.add(a);
        }
    }

    public void addAlly(CombatActor a) {
        if(!allies.contains(a)){
            allies.add(a);
        }
    }


    public void removeEnemy(CombatActor a) {
        enemies.remove(a);
    }


    public void removeAlly(CombatActor a) {
        allies.remove(a);
    }


    public void setEnemies(ArrayList<CombatActor> a) {
        enemies=a;
    }


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
//TODO: Add woundpenalty to calculations here.
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
        x.defenderArmorSoak=armor.getSoak();
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
            System.out.println(this.getName()+" crashed his opponent.");
            this.gainInitiative(5);
        }
        this.changeInitiative(x.initiativeDamageDoneModifiedDefender);
        x.attackerCrashed=(initiative<=0 && this.crashbreakable());

    }

    @Override
    public void updateInitiativeDefender(AttackState x) {
        if (x.defenderCrashed)
            this.loseInitiative(5);
        this.changeInitiative(-x.initiativeDamageDoneModifiedDefender);
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
        x.damageRollValuation=new DecisiveValuation();

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

    @Override
    public void endOfRound() {

    }
}
