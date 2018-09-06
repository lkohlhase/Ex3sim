package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
    public MeleeWeapon Unarmed(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Unarmed";
        return returnable;
    }
    public MeleeWeapon Cestus(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SMASHING);
        tags.add(MeleeWeapon.WeaponTags.WORN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Cestus";
        return returnable;
    }
}
