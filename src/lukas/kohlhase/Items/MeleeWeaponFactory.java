package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
   public static MortalMeleeWeaponFactory mortal=new MortalMeleeWeaponFactory();
    public static MeleeWeapon Unarmed(){
        return mortal.light.Unarmed();
    }
    public static MeleeWeapon Cestus(){
        return mortal.light.Cestus();
    }
    public static MeleeWeapon Club(){
        return mortal.light.Club();
    }
    public static MeleeWeapon Khatar(){
        return mortal.light.Khatar();
    }
    public static MeleeWeapon Knife(){
        return mortal.light.Knife();
    }
    public static MeleeWeapon Sai(){
        return mortal.light.Sai();
    }
    public static MeleeWeapon ShortSword(){
        return mortal.light.ShortSword();
    }
    public static MeleeWeapon TigerClaws(){
        return mortal.light.TigerClaws();
    }
    public static MeleeWeapon Whip(){
        return mortal.light.Whip();
    }
    public static MeleeWeapon WarFan(){
        return mortal.light.WarFan();
    }
    public static MeleeWeapon Axe(){
        return mortal.medium.Axe();
    }
    public static MeleeWeapon ChoppingSword(){
        return mortal.medium.ChoppingSword();
    }
    public static MeleeWeapon FightingChain(){
        return mortal.medium.FightingChain();
    }
    public static MeleeWeapon HookSword(){
        return mortal.medium.HookSword();
    }
    public static MeleeWeapon Javelin(){
        return mortal.medium.Javelin();
    }
    public static MeleeWeapon Mace(){
        return mortal.medium.Mace();
    }
    public static MeleeWeapon SevenSectionStaff(){
        return mortal.medium.SevenSectionStaff();
    }
    public static MeleeWeapon Shield(){
        return mortal.medium.Shield();
    }
    public static MeleeWeapon ShortSpear(){
        return mortal.medium.ShortSpear();
    }
    public static MeleeWeapon SlashingSword(){
        return mortal.medium.SlashingSword();
    }
    public static MeleeWeapon StraightSword(){
        return mortal.medium.StraightSword();
    }
    public static MeleeWeapon Spear(){
        return mortal.medium.Spear();
    }
    public static MeleeWeapon Staff(){
        return mortal.medium.Staff();
    }
    public static MeleeWeapon Halberd(){ return mortal.heavy.Halberd(); }
    public static MeleeWeapon Tetsubo(){
        return mortal.heavy.Tetsubo();
    }
    public static MeleeWeapon GreatSword(){
        return mortal.heavy.GreatSword();
    }
    public static MeleeWeapon GreatAxe(){
        return mortal.heavy.GreatAxe();
    }
    //TODO: Add Artifact Weapons
    public static ArrayList<MeleeWeapon> all(){
        return mortal.all();
    }
}
