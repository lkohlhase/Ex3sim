package lukas.kohlhase.Characters;

import lukas.kohlhase.*;

import java.util.ArrayList;

public class TestAttacker implements CombatActor {
    /*
    A generic attacker, only can do withering attacks, and only has initiative.
     */
    private int initiative;
    int roundsInCrash=10; //Code for isn't crashed.
    int roundsSinceCrash=10; //Hasn't recently been crashed
    String name;
    HealthLevel health=new HealthLevel();
    ArrayList<CombatActor> enemies;
    ArrayList<CombatActor> allies;
    public TestAttacker(String newname){
        name=newname;
        initiative=3;
    }
    public TestAttacker(){
        initiative=3;
        name="Karl Ivanovic der Zweite";
    }
    public int getInitiative(){
        return initiative;
    }
    public void setInitiative(int x){ //Only intended to be used for resetting initiative
        initiative=x;
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

    public int declareWitheringAttack(){
        return 11; //Attacks with a dicepool of 10, so 5 attribute+5 skill+1 accuracy
    }
    public int declareWitheringDV(int x){
        return 5; //DV of 5
    }
    public int declareWitheringPostHit(int threshold){
        return threshold+5+5;//5 strength and 5 weapon damage.
    }

    public Action declareWitheringPostMiss(){
        Action donothing=new DoNothing();
        return donothing;
    }
    public int declareSoak(int threshold){
        return 2; //Basic Soak of 2, should make most attacks ping
    }
    public int declarePostSoakDefender(int postsoaksuccesses){
        return postsoaksuccesses;
    }
    public int declarePostSoakAttacker(int postsoaksuccesses){
        return postsoaksuccesses;
    }
    public void endOfRound(){
        roundsInCrash++;
        if (roundsInCrash==3){
            roundsInCrash=10;
            roundsSinceCrash=-1;
            this.setInitiative(3);
        }
        roundsSinceCrash++;
    }
    public boolean crashbreakable(){
        return roundsSinceCrash>=2;
    }

    @Override
    public void declareWitheringAttack(AttackState x) {

    }

    @Override
    public void declareWitheringDV(AttackState x) {

    }

    @Override
    public void AttackerModifyAttackRoll(AttackState x) {

    }

    @Override
    public void DefenderModifyAttackRoll(AttackState x) {

    }

    @Override
    public void changeThreshholdAttacker(AttackState x) {

    }

    @Override
    public void changeThreshholdDefender(AttackState x) {

    }

    @Override
    public void modifyRawDamageAttacker(AttackState x) {

    }

    @Override
    public void modifyRawDamageDefender(AttackState x) {

    }

    @Override
    public void modifyTotalSoakAttacker(AttackState x) {

    }

    @Override
    public void modifyTotalSoakDefender(AttackState x) {

    }

    @Override
    public void declarePostSoakAttacker(AttackState x) {

    }

    @Override
    public void declarePostSoakDefender(AttackState x) {

    }

    @Override
    public void modifyDamageRollAttacker(AttackState x) {

    }

    @Override
    public void modifyDamageRollDefender(AttackState x) {

    }

    @Override
    public void modifyInitiativeDamageAttacker(AttackState x) {

    }

    @Override
    public void modifyInitiativeDamageDefender(AttackState x) {

    }

    @Override
    public void updateInitiativeAttacker(AttackState x) {

    }

    @Override
    public void updateInitiativeDefender(AttackState x) {

    }

    @Override
    public void failedAttackAttacker(AttackState x) {

    }

    @Override
    public void failedAttackDefender(AttackState x) {

    }

    public Action chooseAction(CombatActor[] actors){
        CombatActor opponent=new ErrorActor();
        for(int i=0; i<actors.length;i++){
            if (actors[i]!=this){
                opponent=actors[i];
                break;
            }
        }
        WitheringAttack attack=new WitheringAttack(this,opponent);
        return attack;
    }
    public int declareJoinBattle(){
        return 10; //Starts with Join Battle pool of 10
    }
    public String getName(){
        return name;
    }
    public void setName(String a){
        name=a;
    }

    @Override
    public void setHealth(HealthLevel a) {
        health=a;
    }

    @Override
    public int declareHardness() {
        return 5;
    }

    @Override
    public int declareDecisiveDV(int x) {
        return 5;
    }

    @Override
    public int declareDecisiveAttack() {
        return 10; //5 attribute+5 skill
    }

    @Override
    public Action declareDecisivePostMiss() {
        return new DoNothing();
    }

    @Override
    public int declareDecisivePostHit(int x, int y) {
        return y;
    }

    @Override
    public void takeDamage(int b, damage x) {
        health.takeDamage(b,x);
    }

    @Override
    public HealthLevel getHealth() {
        return health;
    }

    public int getRoundsInCrash() {
        return roundsInCrash;
    }

    public int getRoundsSinceCrash() {
        return roundsSinceCrash;
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
}
