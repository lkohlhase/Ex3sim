package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.CombatActor;
import lukas.kohlhase.Items.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneticPool {
    private static final Logger logger=Logger.getLogger("mylogger");
    public Mutater mutater = new MortalThreshWeaponAttsMutater();
    private ArrayList<MortalTestAttacker> participants;
    private Random rand=new Random();
    public GeneticPool(ArrayList<MortalTestAttacker> prototypes, int numcopies, String mutationtype){

        System.out.println("Not yet implemented");
    }
    public void runPool(int numfights){
        System.out.println("Not yet Implemented");
    }

}
