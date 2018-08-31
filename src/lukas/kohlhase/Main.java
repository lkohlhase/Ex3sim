package lukas.kohlhase;
import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.Items.MeleeWeapon;
import lukas.kohlhase.Items.MeleeWeaponFactory;

import java.util.*;



public class Main {

    public static void main(String[] args) {

        MortalTestAttacker fighter1=new MortalTestAttacker();
        fighter1.setName("Steve");
        MortalTestAttacker fighter2=new MortalTestAttacker();
        fighter2.setName("Karl");
        ArrayList<CombatActor> fighters=new ArrayList<CombatActor>();
        fighters.add(fighter1);
        fighters.add(fighter2);

        CombatScene fighterino=new CombatScene(fighters);
        fighterino.runCombat();
    }
}
