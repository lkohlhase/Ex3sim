package lukas.kohlhase;
import lukas.kohlhase.Characters.TestAttacker;

import java.util.*;



public class Main {

    public static void main(String[] args) {
	// write your code here
        TestAttacker fighter1=new TestAttacker("Karl");
        TestAttacker fighter2=new TestAttacker("Dave");
        Vector<CombatActor> fighters=new Vector<CombatActor>();
        fighters.add(fighter1);
        fighters.add(fighter2);

        CombatScene fighterino=new CombatScene(fighters);
        fighterino.runCombat();
    }
}
