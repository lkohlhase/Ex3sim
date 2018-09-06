package lukas.kohlhase.Characters;

import lukas.kohlhase.*;
import lukas.kohlhase.Actions.Action;
import lukas.kohlhase.Actions.DoNothing;

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
    public boolean crashbreakable() {
        return false;
    }

    @Override
    public int declareJoinBattle() {
        return 0;
    }

    @Override
    public int declareWitheringAttack() {
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
    public void declareDecisiveAttack(AttackState x) {

    }

    @Override
    public void declareDecisiveDV(AttackState x) {

    }

    @Override
    public void modifyDecisiveAttackRollAttacker(AttackState x) {

    }

    @Override
    public void modifyDecisiveAttackRollDefender(AttackState x) {

    }

    @Override
    public void changeDecisiveThreshholdAttacker(AttackState x) {

    }

    @Override
    public void changeDecisiveThreshholdDefender(AttackState x) {

    }

    @Override
    public void modifyDecisiveHitAttacker(AttackState x) {

    }

    @Override
    public void modifyDecisiveHitDefender(AttackState x) {

    }

    @Override
    public void modifyDecisiveDamageRollAttacker(AttackState x) {

    }

    @Override
    public void modifyDecisiveDamageRollDefender(AttackState x) {

    }



    @Override
    public void modifyDecisiveDamageDoneAttacker(AttackState x) {

    }

    @Override
    public void modifyDecisiveDamageDoneDefender(AttackState x) {

    }

    @Override
    public void declareDecisivePostMissAttacker(AttackState x) {

    }

    @Override
    public void declareDecisivePostMissDefender(AttackState x) {

    }

    @Override
    public void resetBaseInitiative() {

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
    public void setHealth(HealthLevel a) {

    }
}

