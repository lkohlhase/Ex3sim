package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.CombatActor;

import java.util.ArrayList;
import java.util.Random;

public class GeneticPool {
    private ArrayList<FullCharacter> participants;
    private Random rand=new Random();
    public GeneticPool(ArrayList<FullCharacter> prototypes, int numcopies, String mutationtype){
        System.out.println("Not yet implemented");
    }
    public void runPool(int numfights){
        System.out.println("Not yet Implemented");
    }
    private void mutateAttThreshWeapon(FullCharacter mutant){
        int rng=rand.nextInt(3);
        switch (rng){
            case 0: //change the attribute distribution
                break;
            case 1:
                break;//Change the threshhold
            case 2:
                break;//Change the weapon
        }
    }
}
