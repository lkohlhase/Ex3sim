package lukas.kohlhase.Items;

public class ArmorFactory {
    public static Armor Breastplate(){
        return new Armor(Armor.ArmorType.LIGHT, false);
    }
    public static Armor BuffJacket(){
        return new Armor(Armor.ArmorType.LIGHT,false);
    }
    public static Armor ChainShirt(){
        return new Armor(Armor.ArmorType.LIGHT, false);
    }
    public static Armor Hauberk(){
        return new Armor(Armor.ArmorType.MEDIUM, false);
    }
    public static Armor Lamellar(){
        return new Armor(Armor.ArmorType.MEDIUM, false);
    }
    public static Armor ReinforcedBreastplate(){
        return new Armor(Armor.ArmorType.MEDIUM,false);
    }
    public static Armor ReinforcedBuffJacket(){
        return new Armor(Armor.ArmorType.MEDIUM,false   );
    }
    public static Armor ArticulatedPlate(){
        return new Armor(Armor.ArmorType.HEAVY,false);
    }
    public static Armor PlateAndChain(){
        return new Armor(Armor.ArmorType.HEAVY,false);
    } //TODO: Add Artifact Armors
}
