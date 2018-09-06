package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
   public MortalMeleeWeaponFactory mortal=new MortalMeleeWeaponFactory();
    public MeleeWeapon Unarmed(){
        return this.mortal.light.Unarmed();
    }
    public MeleeWeapon Cestus(){
        return this.mortal.light.Cestus();
    }
    public MeleeWeapon Club(){
        return this.mortal.light.Club();
    }
    public MeleeWeapon Khatar(){
        return this.mortal.light.Khatar();
    }
    public MeleeWeapon Knife(){
        return this.mortal.light.Knife();
    }
    public MeleeWeapon Sai(){
        return this.mortal.light.Sai();
    }
    public MeleeWeapon ShortSword(){
        return this.mortal.light.ShortSword();
    }
    public MeleeWeapon TigerClaws(){
        return this.mortal.light.TigerClaws();
    }
    public MeleeWeapon Whip(){
        return this.mortal.light.Whip();
    }
    public MeleeWeapon WarFan(){
        return this.mortal.light.WarFan();
    }
    public MeleeWeapon Axe(){
        return this.mortal.medium.Axe();
    }
    public MeleeWeapon ChoppingSword(){
        return this.mortal.medium.ChoppingSword();
    }
    public MeleeWeapon FightingChain(){
        return this.mortal.medium.FightingChain();
    }
    public MeleeWeapon HookSword(){
        return this.mortal.medium.HookSword();
    }
    public MeleeWeapon Javelin(){
        return this.mortal.medium.Javelin();
    }
    public MeleeWeapon Mace(){
        return this.mortal.medium.Mace();
    }
    public MeleeWeapon SevenSectionStaff(){
        return this.mortal.medium.SevenSectionStaff();
    }
    public MeleeWeapon Shield(){
        return this.mortal.medium.Shield();
    }
    public MeleeWeapon ShortSpear(){
        return this.mortal.medium.ShortSpear();
    }
    public MeleeWeapon SlashingSword(){
        return this.mortal.medium.SlashingSword();
    }
    public MeleeWeapon StraightSword(){
        return this.mortal.medium.StraightSword();
    }
    public MeleeWeapon Spear(){
        return this.mortal.medium.Spear();
    }
    public MeleeWeapon Staff(){
        return this.mortal.medium.Staff();
    }
}
