package lukas.kohlhase;

public abstract class Charm {
    public CharmCost cost;
    public CharmType type; //simple reflexive etc.

    abstract Boolean hasRequirements(FullCharacter a);

}
