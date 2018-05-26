package lukas.kohlhase;
import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;

import java.util.*;



public class Main {

    public static void main(String[] args) {
	// write your code here
        FullCharacter fighter1=new FullCharacter();
        MortalTestAttacker fighter2=new MortalTestAttacker();
        Vector<CombatActor> fighters=new Vector<CombatActor>();
        fighters.add(fighter1);
        fighters.add(fighter2);

        CombatScene fighterino=new CombatScene(fighters);
        fighterino.runCombat();
    }
}
