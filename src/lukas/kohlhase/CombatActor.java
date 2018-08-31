package lukas.kohlhase;

import lukas.kohlhase.Actions.Action;

import java.util.ArrayList;

public interface CombatActor extends Actor {
    void changeInitiative(int x);
    void gainInitiative(int x);
    void loseInitiative(int x);
    int getInitiative();
    void setInitiative(int x);
    int declareWitheringAttack();
//========================= Responses to various phases of withering attacks ===========================================
    void declareWitheringAttack(AttackState x);
    void declareWitheringDV(AttackState x);
    void modifyWitheringAttackRollAttacker(AttackState x);
    void modifyWitheringAttackRollDefender(AttackState x);
    void changeWitheringThreshholdAttacker(AttackState x);
    void changeWitheringThreshholdDefender(AttackState x);
    void modifyWitheringRawDamageAttacker(AttackState x);
    void modifyWitheringRawDamageDefender(AttackState x);
    void modifyTotalSoakAttacker(AttackState x); //Don't need to specify withering here, since soak is only applied to withering attacks anyway.
    void modifyTotalSoakDefender(AttackState x);
    void declarePostSoakAttacker(AttackState x);
    void declarePostSoakDefender(AttackState x);
    void modifyWitheringDamageRollAttacker(AttackState x);
    void modifyWitheringDamageRollDefender(AttackState x);
    void modifyInitiativeDamageAttacker(AttackState x);
    void modifyInitiativeDamageDefender(AttackState x);
    void updateInitiativeAttacker(AttackState x);
    void updateInitiativeDefender(AttackState x);
    void failedWitheringAttackAttacker(AttackState x);
    void failedWitheringAttackDefender(AttackState x);
//=========================Responses to various phases of decisive attacks =============================================
    void declareDecisiveAttack(AttackState x);
    void declareDecisiveDV(AttackState x);
    void modifyDecisiveAttackRollAttacker(AttackState x);
    void modifyDecisiveAttackRollDefender(AttackState x);
    void changeDecisiveThreshholdAttacker(AttackState x);
    void changeDecisiveThreshholdDefender(AttackState x);
    void modifyDecisiveHitAttacker(AttackState x);
    void modifyDecisiveHitDefender(AttackState x);
    void modifyDecisiveDamageRollAttacker(AttackState x);
    void modifyDecisiveDamageRollDefender(AttackState x);
    void resetBaseInitiative(AttackState x);
    void modifyDecisiveDamageDoneAttacker(AttackState x);
    void modifyDecisiveDamageDoneDefender(AttackState x);
    void declareDecisivePostMissAttacker(AttackState x);
    void declareDecisivePostMissDefender(AttackState x);

//=========================Old Implementation of Attack Responses etc.     =============================================

    void endOfRound();
    boolean crashbreakable();
    int declareJoinBattle();
    String getName();
    void setName(String a);
    HealthLevel getHealth();
    void setHealth(HealthLevel a);
    void takeDamage(int b,damageType x);
    void addEnemy(CombatActor a);
    void addAlly(CombatActor a);
    void removeEnemy(CombatActor a);
    void removeAlly(CombatActor a);
    void setEnemies(ArrayList<CombatActor> a);
    void setAllies(ArrayList<CombatActor> a);
}
