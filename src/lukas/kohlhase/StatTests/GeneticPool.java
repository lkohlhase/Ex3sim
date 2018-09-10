package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.CombatScene;
import lukas.kohlhase.Items.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneticPool {
    private static final Logger logger=Logger.getLogger("mylogger");
    public Mutater mutater=new MortalThreshWeaponAttsMutater();
    public ArrayList<FullCharacter> participants;
    private Random rand=new Random();
    public GeneticPool(ArrayList<MortalTestAttacker> prototypes, int numcopies){
        participants=new ArrayList<FullCharacter>();
        for (MortalTestAttacker proto: prototypes) {
            for (int i=0; i<numcopies; i++){
                participants.add(new MortalTestAttacker(proto));
            }

        }
    }
    public void runPool(int numfights){
        for (int i=0; i<numfights; i++){

            FullCharacter fighter1=participants.get(rand.nextInt(participants.size()));
            FullCharacter fighter2=participants.get(rand.nextInt(participants.size()));
            participants.remove(fighter1);
            participants.remove(fighter2);
            while (fighter1==fighter2){
                fighter2=participants.get(rand.nextInt(participants.size()));
            }
            ArrayList<CombatActor> fighters=new ArrayList<>();
            fighters.add(fighter1);
            fighters.add(fighter2);
            CombatScene scene=new CombatScene(fighters);
            scene.fullCombat();
            FullCharacter deadfighter;
            FullCharacter winner;
            if (fighter1.isDead()){
                deadfighter=fighter1;
                winner=fighter2;
                fighter2.getHealth().reset();
                participants.add(fighter2);
            }
            else {
                deadfighter = fighter2;
                winner=fighter1;
                fighter1.getHealth().reset();
                participants.add(fighter1);
            }
            if (rand.nextInt(2)==1) { //50% of mutation on lost fight
                FullCharacter mutantson=new FullCharacter(winner);
                mutater.mutate(mutantson);
                mutantson.getHealth().reset();
                participants.add(mutantson);
            }
            else{
                deadfighter.getHealth().reset();
                participants.add(deadfighter);
            }
        }
    }

}
