package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.CombatScene;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: Save the matrix generated at the end as a csv or some shit, that way we can do analysis on it with actual tools for data analysis like python.
public class MortalCombatTest extends CombatScene { //We use this class to test the winrates of various mortal unarmed builds against each other.
    private static final Logger logger=Logger.getLogger("mylogger");

    public MortalCombatTest(){
        super(new ArrayList<CombatActor>());

        MortalTestAttacker fighter1=new MortalTestAttacker("Steve");
        MortalTestAttacker fighter2=new MortalTestAttacker("Karl");
        fighter1.addEnemy(fighter2);
        fighter2.addEnemy(fighter1);
        fighter1.abilities.Brawl=5;
        fighter1.attributes.Dexterity=5;
        fighter1.attributes.Strength=5;
        fighter1.attributes.Wits=5;
        fighter1.abilities.Awareness=5;
        fighter2.abilities.Brawl=5;
        fighter2.attributes.Dexterity=5;
        fighter2.attributes.Strength=5;
        fighter2.attributes.Wits=5;
        fighter2.abilities.Awareness=5;
        HashMap<Integer,HashMap<Integer,Integer>> dictionary=new HashMap<>();

        this.addParticipant(fighter1);
        this.addParticipant(fighter2);
        for (int i=5; i<20; i++){
            System.out.println(i);
            dictionary.put(i,new HashMap<Integer,Integer>());
            fighter1.setThresh(i);
            for (int j=5; j<20; j++){
                dictionary.get(i).put(j, 0);
                for (int k=0; k<1000; k++) {
                    fighter2.setThresh(j);
                    this.removeParticipant(fighter1);
                    this.removeParticipant(fighter2);
                    this.addParticipant(fighter1);
                    this.addParticipant(fighter2);
                    this.resetCombat();

                    System.out.println("____________________________________________________________________________________________________________________________________");
                    System.out.println("Steve has threshold : " + i + " and Karl has threshold: " + j);
                    this.joinBattle();
                    this.runCombat();
                    if (!fighter1.getHealth().incaped() && fighter2.getHealth().incaped()) {
                        dictionary.get(i).put(j, dictionary.get(i).get(j) + 1);
                    }
                }

            }
        }

        try {
            String filename="MortalCombatTestMatrix.txt";
            FileWriter fileWriter=new FileWriter(filename);
            BufferedWriter writer=new BufferedWriter(fileWriter);
            for (int i=5; i<20; i++){
                String output="";
                for (int j=5; j<20; j++){
                    if (dictionary.get(i).get(j)>=500)
                        output+=" 1";
                    else
                        output+=" 0";

                }
                writer.write(output);
                writer.newLine();
            }
            writer.close();

        }
        catch (IOException ex){
            logger.log(Level.SEVERE,"Error writing to file");
            ex.printStackTrace();
        }


    }
}
