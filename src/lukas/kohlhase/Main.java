package lukas.kohlhase;
import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.TestAttacker;

import java.util.*;



public class Main {

    public static void main(String[] args) {
	// write your code here
        FullCharacter fighter1=new FullCharacter();
        TestAttacker fighter2=new TestAttacker("Dave");
        Vector<CombatActor> fighters=new Vector<CombatActor>();
        fighters.add(fighter1);
        fighters.add(fighter2);

        CombatScene fighterino=new CombatScene(fighters);
        fighterino.runCombat();
    }
}
