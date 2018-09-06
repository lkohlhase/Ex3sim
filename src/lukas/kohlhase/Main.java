package lukas.kohlhase;
import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.Items.MeleeWeapon;
import lukas.kohlhase.Items.MeleeWeaponFactory;
import lukas.kohlhase.StatTests.MortalCombatTest;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        Logger logger=Logger.getLogger("mylogger");
        logger.setLevel(Level.INFO);
        Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINER);
//        MortalTestAttacker fighter1=new MortalTestAttacker();
//        fighter1.setName("Steve");
//        MortalTestAttacker fighter2=new MortalTestAttacker();
//        fighter2.setName("Karl");
//        ArrayList<CombatActor> fighters=new ArrayList<CombatActor>();
//        fighters.add(fighter1);
//        fighters.add(fighter2);
//        fighter1.attributes.Dexterity=5;
//        fighter1.abilities.Brawl=5;
//        fighter1.attributes.Wits=5;
//        fighter1.abilities.Awareness=5;
//        CombatScene scene=new CombatScene(fighters);
//        scene.runCombat();
        MortalCombatTest testerino=new MortalCombatTest();
        testerino.Testone();


    }
}
