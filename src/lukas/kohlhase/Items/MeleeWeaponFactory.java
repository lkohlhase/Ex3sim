package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;

public class MeleeWeaponFactory {
    public MeleeWeapon Unarmed(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Unarmed";
        return returnable;
    }
}
