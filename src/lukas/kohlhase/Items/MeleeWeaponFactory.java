package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
    public static MortalMeleeWeaponFactory mortal;
    public static MeleeWeapon Unarmed(){
        return LightMortalMeleeWeaponFactory.Unarmed();
    }
    public static MeleeWeapon Cestus(){
        return LightMortalMeleeWeaponFactory.Cestus();
    }
    public static MeleeWeapon Club(){
        return LightMortalMeleeWeaponFactory.Club();
    }
    public static MeleeWeapon Khatar(){
        return LightMortalMeleeWeaponFactory.Khatar();
    }
    public static MeleeWeapon Knife(){
        return LightMortalMeleeWeaponFactory.Knife();
    }
    public static MeleeWeapon Sai(){
        return LightMortalMeleeWeaponFactory.Sai();
    }
    public static MeleeWeapon ShortSword(){
        return LightMortalMeleeWeaponFactory.ShortSword();
    }
    public static MeleeWeapon TigerClaws(){
        return LightMortalMeleeWeaponFactory.TigerClaws();
    }
    public static MeleeWeapon Whip(){
        return LightMortalMeleeWeaponFactory.Whip();
    }
    public static MeleeWeapon WarFan(){
        return LightMortalMeleeWeaponFactory.WarFan();
    }
    public static MeleeWeapon Axe(){
        return MediumMortalMeleeWeaponFactory.Axe();
    }
    public static MeleeWeapon ChoppingSword(){
        return MediumMortalMeleeWeaponFactory.ChoppingSword();
    }
    public static MeleeWeapon FightingChain(){
        return MediumMortalMeleeWeaponFactory.FightingChain();
    }
    public static MeleeWeapon HookSword(){
        return MediumMortalMeleeWeaponFactory.HookSword();
    }
    public static MeleeWeapon Javelin(){
        return MediumMortalMeleeWeaponFactory.Javelin();
    }
    public static MeleeWeapon Mace(){
        return MediumMortalMeleeWeaponFactory.Mace();
    }
    public static MeleeWeapon SevenSectionStaff(){
        return MediumMortalMeleeWeaponFactory.SevenSectionStaff();
    }
    public static MeleeWeapon Shield(){
        return MediumMortalMeleeWeaponFactory.Shield();
    }
    public static MeleeWeapon ShortSpear(){
        return MediumMortalMeleeWeaponFactory.ShortSpear();
    }
    public static MeleeWeapon SlashingSword(){
        return MediumMortalMeleeWeaponFactory.SlashingSword();
    }
    public static MeleeWeapon StraightSword(){
        return MediumMortalMeleeWeaponFactory.StraightSword();
    }
    public static MeleeWeapon Spear(){
        return MediumMortalMeleeWeaponFactory.Spear();
    }
    public static MeleeWeapon Staff(){
        return MediumMortalMeleeWeaponFactory.Staff();
    }
    public static MeleeWeapon Halberd(){ return HeavyMortalMeleeWeaponFactory.Halberd(); }
    public static MeleeWeapon Tetsubo(){
        return HeavyMortalMeleeWeaponFactory.Tetsubo();
    }
    public static MeleeWeapon GreatSword(){
        return HeavyMortalMeleeWeaponFactory.GreatSword();
    }
    public static MeleeWeapon GreatAxe(){
        return HeavyMortalMeleeWeaponFactory.GreatAxe();
    }
    //TODO: Add Artifact Weapons
    public static ArrayList<MeleeWeapon> all(){
        return mortal.all();
    }
}
