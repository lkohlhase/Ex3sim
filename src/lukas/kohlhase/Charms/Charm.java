package lukas.kohlhase.Charms;

import lukas.kohlhase.Characters.FullCharacter;

public abstract class Charm {
    public CharmCost cost;
    public CharmType type; //simple reflexive etc.
    public String name;
    abstract Boolean hasRequirements(FullCharacter a);

}
