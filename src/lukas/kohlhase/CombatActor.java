package lukas.kohlhase;

import java.util.ArrayList;

public interface CombatActor extends Actor {
    void changeInitiative(int x);
    void gainInitiative(int x);
    void loseInitiative(int x);
    int getInitiative();
    void setInitiative(int x);
    int declareWitheringAttack();
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
    int declareDecisiveAttack();
    int declareWitheringDV(int x);
    int declareDecisiveDV(int x);
    int declareWitheringPostHit(int thresholdsuccesses);
    int declareDecisivePostHit(int x,int y);
    Action declareWitheringPostMiss();
    Action declareDecisivePostMiss();
    int declareSoak(int thresholdsuccesses);
    int declarePostSoakDefender(int postsoaksuccesses);
    int declarePostSoakAttacker(int postsoaksuccesses);
    void endOfRound();
    boolean crashbreakable();
    int declareJoinBattle();
    String getName();
    void setName(String a);
    int declareHardness();
    HealthLevel getHealth();
    void setHealth(HealthLevel a);
    void takeDamage(int b,damage x);
    void addEnemy(CombatActor a);
    void addAlly(CombatActor a);
    void removeEnemy(CombatActor a);
    void removeAlly(CombatActor a);
    void setEnemies(ArrayList<CombatActor> a);
    void setAllies(ArrayList<CombatActor> a);
}
