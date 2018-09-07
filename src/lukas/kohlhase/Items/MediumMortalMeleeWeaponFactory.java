package lukas.kohlhase.Items;

import javax.crypto.Mac;
import java.util.ArrayList;

public class MediumMortalMeleeWeaponFactory {
    public static MeleeWeapon Axe(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Axe";
        return returnable;
    }
    public static MeleeWeapon ChoppingSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Chopping Sword";
        return returnable;
    }
    public static MeleeWeapon FightingChain(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        tags.add(MeleeWeapon.WeaponTags.FLEXIBLE);
        tags.add(MeleeWeapon.WeaponTags.GRAPPLING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Fighting Chain";
        return returnable;
    }
    public static MeleeWeapon HookSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Hook Sword";
        return returnable;
    }
    public static MeleeWeapon Javelin(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Javelin";
        return returnable;
    }
    public static MeleeWeapon Mace(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SMASHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Mace";
        return returnable;
    }
    public static MeleeWeapon SevenSectionStaff(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        tags.add(MeleeWeapon.WeaponTags.FLEXIBLE);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Seven Section Staff";
        return returnable;
    }
    public static MeleeWeapon Shield(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SHIELD);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Shield";
        return returnable;
    }
    public static MeleeWeapon ShortSpear(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.PIERCING);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Short Spear";
        return returnable;
    }
    public static MeleeWeapon Spear(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.PIERCING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Spear";
        return returnable;
    }
    public static MeleeWeapon StraightSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Straight Sword";
        return returnable;
    }
    public static MeleeWeapon Staff(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Staff";
        return returnable;
    }
    public static MeleeWeapon SlashingSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Staff";
        return returnable;
    }
    public static ArrayList<MeleeWeapon> all(){
        ArrayList<MeleeWeapon> returnable=new ArrayList<>();
        returnable.add(Axe());
        returnable.add(ChoppingSword());
        returnable.add(FightingChain());
        returnable.add(HookSword());
        returnable.add(Javelin());
        returnable.add(Mace());
        returnable.add(SevenSectionStaff());
        returnable.add(Shield());
        returnable.add(ShortSpear());
        returnable.add(Spear());
        returnable.add(StraightSword());
        returnable.add(Staff());
        returnable.add(SlashingSword());
        return returnable;
    }
}
