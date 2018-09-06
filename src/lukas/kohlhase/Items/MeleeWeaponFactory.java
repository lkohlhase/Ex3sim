package lukas.kohlhase.Items;

import java.util.ArrayList;
import lukas.kohlhase.Items.MeleeWeapon;
//NOTE: It's important that every weapon has either bashing or lethal tag. else ther will be issues.
public class MeleeWeaponFactory {
    public MeleeWeapon Unarmed(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.NATURAL);
        tags.add(MeleeWeapon.WeaponTags.GRAPPLING);
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
    public MeleeWeapon Club(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SMASHING);
        tags.add(MeleeWeapon.WeaponTags.IMPROVISED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Club";
        return returnable;
    }
    public MeleeWeapon Khatar(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.PIERCING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Khatar";
        return returnable;
    }
    public MeleeWeapon Knife(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Knife";
        return returnable;
    }
    public MeleeWeapon Sai(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Sai";
        return returnable;
    }
    public MeleeWeapon ShortSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Short Sword";
        return returnable;
    }
    public MeleeWeapon TigerClaws(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.WORN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Tiger Claws";
        return returnable;
    }
    public MeleeWeapon Whip(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.BRAWL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        tags.add(MeleeWeapon.WeaponTags.FLEXIBLE);
        tags.add(MeleeWeapon.WeaponTags.GRAPPLING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="Whip";
        return returnable;
    }
    public MeleeWeapon WarFan(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.LIGHT,false );
        returnable.name="War Fan";
        return returnable;
    }
}
