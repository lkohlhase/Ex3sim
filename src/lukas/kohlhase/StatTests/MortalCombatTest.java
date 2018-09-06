package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.CombatScene;
import lukas.kohlhase.Items.ArmorFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: Save the matrix generated at the end as a csv or some shit, that way we can do analysis on it with actual tools for data analysis like python.
public class MortalCombatTest extends CombatScene { //We use this class to test the winrates of various mortal unarmed builds against each other.
    private static final Logger logger=Logger.getLogger("mylogger");

    public MortalCombatTest() {
        super(new ArrayList<CombatActor>());
    }
    public void Testone(){
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
        fighter1.armor=ArmorFactory.ArticulatedPlate();
        fighter2.armor=ArmorFactory.ArticulatedPlate();
        HashMap<Integer,HashMap<Integer,Integer>> dictionary=new HashMap<>();

        this.addParticipant(fighter1);
        this.addParticipant(fighter2);
        for (int i=5; i<30; i++){
            System.out.println(i);
            dictionary.put(i,new HashMap<Integer,Integer>());
            fighter1.setThresh(i);
            for (int j=5; j<30; j++){ // Result for no armor, max stats is that attacking at 12+ inititative is good.
                dictionary.get(i).put(j, 0); //Result for both have buff jackets: attacking at roughly 10ish is good (12 still works, but 10 seems to be slightly better)
                System.out.println("____________________________________________________________________________________________________________________________________");// Buffjacket versus no armor is a STMOP 70% winrate through the bench. No bonuses for low initiative decisvies though.
                System.out.println("Steve has threshold : " + i + " and Karl has threshold: " + j);//for Articulated plate versus no armor, it's about hitting early. You insta win the initiative game, so if they decisive you, they have a chance.
                for (int k=0; k<10000; k++) {
                    fighter2.setThresh(j);//Plate versus plate favors hitting at 10 initiative.
                    this.removeParticipant(fighter1);
                    this.removeParticipant(fighter2);
                    this.addParticipant(fighter1);
                    this.addParticipant(fighter2);
                    this.resetCombat();


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
            for (int i=5; i<30; i++){
                String output="";
                for (int j=5; j<30; j++){
                    output+=" "+dictionary.get(i).get(j);
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
