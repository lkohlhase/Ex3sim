package lukas.kohlhase.Items;

public class ArmorFactory {
    public Armor Breastplate(){
        return new Armor(Armor.ArmorType.LIGHT, false);
    }
    public Armor BuffJacket(){
        return new Armor(Armor.ArmorType.LIGHT,false);
    }
    public Armor ChainShirt(){
        return new Armor(Armor.ArmorType.LIGHT, false);
    }
    public Armor Hauberk(){
        return new Armor(Armor.ArmorType.MEDIUM, false);
    }
    public Armor Lamellar(){
        return new Armor(Armor.ArmorType.MEDIUM, false);
    }
    public Armor ReinforcedBreastplate(){
        return new Armor(Armor.ArmorType.MEDIUM,false);
    }
    public Armor ReinforcedBuffJacket(){
        return new Armor(Armor.ArmorType.MEDIUM,false   );
    }
    public Armor ArticulatedPlate(){
        return new Armor(Armor.ArmorType.HEAVY,false);
    }
    public Armor PlateAndChain(){
        return new Armor(Armor.ArmorType.HEAVY,false);
    }
}
