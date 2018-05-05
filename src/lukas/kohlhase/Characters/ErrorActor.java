package lukas.kohlhase.Characters;

import lukas.kohlhase.*;

import java.util.ArrayList;

public class ErrorActor implements CombatActor {
    /*
    Most basic test case, does nothing.
     */
    @Override
    public Action chooseAction(CombatActor[] actors) {
        return null;
    }

    @Override
    public Action declareWitheringPostMiss() {
        return null;
    }

    @Override
    public boolean crashbreakable() {
        return false;
    }

    @Override
    public int declareWitheringAttack() {
        return 0;
    }

    @Override
    public int declareWitheringDV(int x) {
        return 0;
    }

    @Override
    public int declareJoinBattle() {
        return 0;
    }

    @Override
    public int declareWitheringPostHit(int thresholdsuccesses) {
        return 0;
    }

    @Override
    public int declarePostSoakAttacker(int postsoaksuccesses) {
        return 0;
    }

    @Override
    public int declarePostSoakDefender(int postsoaksuccesses) {
        return 0;
    }

    @Override
    public int declareSoak(int thresholdsuccesses) {
        return 0;
    }

    @Override
    public int getInitiative() {
        return 0;
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
    public void setInitiative(int x) {

    }

    @Override
    public void takeDamage(int b, damageType x) {

    }

    @Override
    public void addEnemy(CombatActor a) {

    }

    @Override
    public void addAlly(CombatActor a) {

    }

    @Override
    public void removeEnemy(CombatActor a) {

    }

    @Override
    public void removeAlly(CombatActor a) {

    }

    @Override
    public void setEnemies(ArrayList<CombatActor> a) {

    }

    @Override
    public void setAllies(ArrayList<CombatActor> a) {

    }

    @Override
    public void endOfRound() {

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String a) {

    }

    @Override
    public Action declareDecisivePostMiss() {
        return new DoNothing();
    }

    @Override
    public int declareDecisiveAttack() {
        return 0;
    }

    @Override
    public int declareDecisiveDV(int x) {
        return 0;
    }

    @Override
    public int declareDecisivePostHit(int x,int y) {
        return 0;
    }

    @Override
    public void declareWitheringAttack(AttackState x) {

    }

    @Override
    public void declareWitheringDV(AttackState x) {

    }

    @Override
    public void modifyWitheringAttackRollAttacker(AttackState x) {

    }

    @Override
    public void modifyWitheringAttackRollDefender(AttackState x) {

    }

    @Override
    public void changeWitheringThreshholdAttacker(AttackState x) {

    }

    @Override
    public void changeWitheringThreshholdDefender(AttackState x) {

    }

    @Override
    public void modifyWitheringRawDamageAttacker(AttackState x) {

    }

    @Override
    public void modifyWitheringRawDamageDefender(AttackState x) {

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
    public void modifyWitheringDamageRollAttacker(AttackState x) {

    }

    @Override
    public void modifyWitheringDamageRollDefender(AttackState x) {

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
    public void failedWitheringAttackAttacker(AttackState x) {

    }

    @Override
    public void failedWitheringAttackDefender(AttackState x) {

    }

    @Override
    public HealthLevel getHealth() {
        return null;
    }

    @Override
    public int declareHardness() {
        return 0;
    }

    @Override
    public void setHealth(HealthLevel a) {

    }
}

