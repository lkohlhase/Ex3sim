package lukas.kohlhase.Items;

import java.util.ArrayList;

public class MediumMortalMeleeWeaponFactory {
    public MeleeWeapon Axe(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Axe";
        return returnable;
    }
    public MeleeWeapon ChoppingSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.CHOPPING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Chopping Sword";
        return returnable;
    }
    public MeleeWeapon FightingChain(){
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
    public MeleeWeapon HookSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Hook Sword";
        return returnable;
    }
    public MeleeWeapon Javelin(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Javelin";
        return returnable;
    }
    public MeleeWeapon Mace(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SMASHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Mace";
        return returnable;
    }
    public MeleeWeapon SevenSectionStaff(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MARTIAL);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.DISARMING);
        tags.add(MeleeWeapon.WeaponTags.FLEXIBLE);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Seven Section Staff";
        return returnable;
    }
    public MeleeWeapon Shield(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.SHIELD);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Shield";
        return returnable;
    }
    public MeleeWeapon ShortSpear(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.PIERCING);
        tags.add(MeleeWeapon.WeaponTags.THROWN);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Short Spear";
        return returnable;
    }
    public MeleeWeapon Spear(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.PIERCING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Spear";
        return returnable;
    }
    public MeleeWeapon StraightSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Straight Sword";
        return returnable;
    }
    public MeleeWeapon Staff(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.BASHING);
        tags.add(MeleeWeapon.WeaponTags.REACHING);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Staff";
        return returnable;
    }
    public MeleeWeapon SlashingSword(){
        ArrayList<MeleeWeapon.WeaponTags> tags=new ArrayList<>();
        tags.add(MeleeWeapon.WeaponTags.MELEE);
        tags.add(MeleeWeapon.WeaponTags.LETHAL);
        tags.add(MeleeWeapon.WeaponTags.BALANCED);
        MeleeWeapon returnable=new  MeleeWeapon(tags,MeleeWeapon.WeaponType.MEDIUM,false );
        returnable.name="Staff";
        return returnable;
    }
}
