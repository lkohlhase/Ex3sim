package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
   MortalMeleeWeaponFactory mortal=new MortalMeleeWeaponFactory();
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
}
