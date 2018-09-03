package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.CombatScene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MortalCombatTest extends CombatScene { //We use this class to test the winrates of various mortal unarmed builds against each other.
    public MortalCombatTest(){
        super(new ArrayList<CombatActor>());
        PrintStream console=System.out;
        PrintStream test;
        try {
            test = new PrintStream(new File("MortalCombatTest.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file");
            test=console;
        };
        System.setOut(test);
        MortalTestAttacker fighter1=new MortalTestAttacker("Steve");
        MortalTestAttacker fighter2=new MortalTestAttacker("Karl");
        fighter1.addEnemy(fighter2);
        fighter2.addEnemy(fighter1);
        HashMap<Integer,HashMap<Integer,Integer>> dictionary=new HashMap<>();

        this.addParticipant(fighter1);
        this.addParticipant(fighter2);
        for (int i=5; i<6; i++){
            System.setOut(console);
            System.out.println(i);
//            System.setOut(test);
            dictionary.put(i,new HashMap<Integer,Integer>());
            fighter1.setThresh(i);
            for (int j=5; j<6; j++){
                fighter2.setThresh(j);
                this.removeParticipant(fighter1);
                this.removeParticipant(fighter2);
                this.addParticipant(fighter1);
                this.addParticipant(fighter2);
                this.resetCombat();
                dictionary.get(i).put(j,0);
                System.out.println("____________________________________________________________________________________________________________________________________");
                System.out.println("Steve has threshold : "+i+" and Karl has threshold: "+j);
                this.joinBattle();
                this.runCombat();
            }
        }
    }
}
