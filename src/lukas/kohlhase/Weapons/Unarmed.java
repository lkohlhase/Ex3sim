package lukas.kohlhase.Weapons;

import lukas.kohlhase.MeleeWeapon;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Unarmed extends MeleeWeapon {
    public Unarmed(){
        super( new ArrayList<WeaponTags>(),WeaponType.LIGHT,false);
        this.Tags.add(WeaponTags.BRAWL);
    }

}
