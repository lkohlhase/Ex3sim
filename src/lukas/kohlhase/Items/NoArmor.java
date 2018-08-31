package lukas.kohlhase.Items;

public class NoArmor extends Armor{ //TODO: Think about whether we need to make a factory like we did for weapons. Yes if there's a billion tags to worry abut, else we can do it like this.
    public NoArmor(){
        super(ArmorType.UNARMORED,false);
    }
}
