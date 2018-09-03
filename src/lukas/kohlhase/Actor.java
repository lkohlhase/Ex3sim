package lukas.kohlhase;

import lukas.kohlhase.Actions.Action;

public interface Actor {
    /*
     */
    Action chooseAction(CombatActor[] actors);


}
