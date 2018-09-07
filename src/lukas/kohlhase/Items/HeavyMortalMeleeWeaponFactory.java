package lukas.kohlhase.Items;

import java.util.ArrayList;

public class HeavyMortalMeleeWeaponFactory {
    public static MeleeWeapon GreatAxe(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        tags.add(MeleeWeapon.WeaponTags.TWOHANDED);

        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.HEAVY,false );
        returnable.name="Great Axe";
        return returnable;
    }
    public static MeleeWeapon GreatSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        tags.add(MeleeWeapon.WeaponTags.TWOHANDED);

        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.HEAVY,false );
        returnable.name="Great Sword";
        return returnable;
    }
    public static MeleeWeapon Halberd(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        tags.add(MeleeWeapon.WeaponTags.TWOHANDED);

        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.HEAVY,false );
        returnable.name="Halberd";
        return returnable;
    }
    public static MeleeWeapon Tetsubo(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SMASHING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        tags.add(MeleeWeapon.WeaponTags.TWOHANDED);

        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.HEAVY,false );
        returnable.name="Tetsubo";
        return returnable;
    }
    public static ArrayList<MeleeWeapon> all(){
        ArrayList<MeleeWeapon> returnable=new ArrayList<>();
        returnable.add(GreatAxe());
        returnable.add(GreatSword());
        returnable.add(Tetsubo());
        return returnable;
    }
}
