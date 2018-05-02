package lukas.kohlhase;

import java.util.ArrayList;

public class FullCharacter implements CombatActor {
    /*
        Intended for inheritance from, so that basic calculations of dicepools etc. from stats is possible
     */
    private int initiative;
    int roundsInCrash=10; //Code for isn't crashed.
    int roundsSinceCrash=10; //Hasn't recently been crashed
    String name;
    ArrayList<CombatActor> enemies;
    ArrayList<CombatActor> allies;
    ArrayList<MeleeWeapon> arnament;

    public ArrayList<Action> generateMeleeAttacks(){
        /*
        We generate basic attacks from the melee weapons that we have available.
         */
        ArrayList<Action> possibleattacks=new ArrayList();
        //TODO: continue doing this.
        for(CombatActor enemy: enemies){ //Generate an attack option for every weapon and every enemy you have.
            for(MeleeWeapon weapon: arnament){
                for(String possibility: weapon.usablewith){
                    //TODO: Need to rework WitheringAttack etc. so that we pass information about the state of combat to the attacker. Since attacks only essentially ask the actor stuff, we need to make sure the actor knows information.
                }
            }
        }
        return possibleattacks;
    }
    @Override
    public void changeInitiative(int x) {

    }

    @Override
    public void gainInitiative(int x) {

    }

    @Override
    public void loseInitiative(int x) {

    }

    @Override
    public int getInitiative() {
        return 0;
    }

    @Override
    public void setInitiative(int x) {

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
    public void takeDamage(int b, damage x) {

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
}
