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
        fighter1.attributes.Dexterity=5;
        fighter1.abilities.Brawl=5;
        fighter1.attributes.Wits=5;
        fighter1.abilities.Awareness=5;

        CombatScene fighterino=new CombatScene(fighters);
        fighterino.runCombat();
        fighter1.getHealth().reset();
        fighter2.getHealth().reset();
        fighter1.getHealth().print();
        fighter2.getHealth().print();

    }
}
