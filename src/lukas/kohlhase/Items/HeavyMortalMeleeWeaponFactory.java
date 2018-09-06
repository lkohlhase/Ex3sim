package lukas.kohlhase.Items;

import java.util.ArrayList;

public class HeavyMortalMeleeWeaponFactory {
    public MeleeWeapon GreatAxe(){
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
    public MeleeWeapon GreatSword(){
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
    public MeleeWeapon Halberd(){
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
    public MeleeWeapon Tetsubo(){
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
}
