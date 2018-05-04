package lukas.kohlhase;

import lukas.kohlhase.Characters.FullCharacter;

public abstract class Charm {
    public CharmCost cost;
    public CharmType type; //simple reflexive etc.

    abstract Boolean hasRequirements(FullCharacter a);

}
