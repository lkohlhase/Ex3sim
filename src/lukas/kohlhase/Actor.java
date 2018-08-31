package lukas.kohlhase;

import lukas.kohlhase.Actions.Action;

public interface Actor {
    /*
    TODO: Make model for health using health levels
     */
    Action chooseAction(CombatActor[] actors);


}
