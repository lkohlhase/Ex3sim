package lukas.kohlhase.Items;

import java.util.ArrayList;

public class MortalMeleeWeaponFactory {
    public static LightMortalMeleeWeaponFactory light;
    public static MediumMortalMeleeWeaponFactory medium;
    public static HeavyMortalMeleeWeaponFactory heavy;
    public static ArrayList<MeleeWeapon> all(){
        ArrayList<MeleeWeapon> returnable=light.all();
        returnable.addAll(medium.all());
        returnable.addAll(heavy.all());
        return returnable;
    }
}
