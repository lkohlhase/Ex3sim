package lukas.kohlhase;

import java.util.ArrayList;

public interface CombatActor extends Actor {
    public void changeInitiative(int x);
    public void gainInitiative(int x);
    public void loseInitiative(int x);
    public int getInitiative();
    public void setInitiative(int x);
    public int declareWitheringAttack();
    public int declareDecisiveAttack();
    public int declareWitheringDV(int x);
    public int declareDecisiveDV(int x);
    public int declareWitheringPostHit(int thresholdsuccesses);
    public int declareDecisivePostHit(int x,int y);
    public Action declareWitheringPostMiss();
    public Action declareDecisivePostMiss();
    public int declareSoak(int thresholdsuccesses);
    public int declarePostSoakDefender(int postsoaksuccesses);
    public int declarePostSoakAttacker(int postsoaksuccesses);
    public void endOfRound();
    public boolean crashbreakable();
    public int declareJoinBattle();
    public String getName();
    public void setName(String a);
    public int declareHardness();
    public HealthLevel getHealth();
    public void setHealth(HealthLevel a);
    public void takeDamage(int b,damage x);
    public void addEnemy(CombatActor a);
    public void addAlly(CombatActor a);
    public void removeEnemy(CombatActor a);
    public void removeAlly(CombatActor a);
    public void setEnemies(ArrayList<CombatActor> a);
    public void setAllies(ArrayList<CombatActor> a);
}
