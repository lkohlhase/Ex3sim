package lukas.kohlhase.Items;

import java.util.ArrayList;

public class MortalMeleeWeaponFactory {
    public static LightMortalMeleeWeaponFactory light=new LightMortalMeleeWeaponFactory();
    public static MediumMortalMeleeWeaponFactory medium=new MediumMortalMeleeWeaponFactory();
    public static HeavyMortalMeleeWeaponFactory heavy=new HeavyMortalMeleeWeaponFactory();
    public static ArrayList<MeleeWeapon> all(){
        ArrayList<MeleeWeapon> returnable=light.all();
        for (MeleeWeapon wep: medium.all()){
            returnable.add(wep);
        }
        for (MeleeWeapon wep: heavy.all()){
            returnable.add(wep);
        }
        return returnable;
    }
}
