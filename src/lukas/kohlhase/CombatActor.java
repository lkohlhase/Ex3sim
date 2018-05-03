package lukas.kohlhase;

import java.util.ArrayList;

public interface CombatActor extends Actor {
    void changeInitiative(int x);
    void gainInitiative(int x);
    void loseInitiative(int x);
    int getInitiative();
    void setInitiative(int x);
    int declareWitheringAttack();
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
