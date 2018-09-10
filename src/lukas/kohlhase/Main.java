package lukas.kohlhase;
import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.Items.MeleeWeapon;
import lukas.kohlhase.Items.MeleeWeaponFactory;
import lukas.kohlhase.StatTests.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        Logger logger=Logger.getLogger("mylogger");
        logger.setLevel(Level.SEVERE);
        Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINER);
        MortalTestAttacker fighter1=new MortalTestAttacker();
        fighter1.setName("Steve");
        MortalTestAttacker fighter2=new MortalTestAttacker();
        fighter2.setName("Karl");
        ArrayList<CombatActor> fighters=new ArrayList<CombatActor>();
        fighters.add(fighter1);
        fighters.add(fighter2);
        fighter1.attributes.Dexterity=5;
        fighter1.abilities.Brawl=5;
        fighter1.attributes.Wits=5;
        fighter1.abilities.Awareness=5;
        fighter1.attributes.Strength=3;
        fighter1.attributes.Stamina=3;
        fighter1.setWeapon(MeleeWeaponFactory.Cestus());
//        CombatScene scene=new CombatScene(fighters);
//        scene.runCombat();
        int attributeTotal=10;
        ArrayList<MortalTestAttacker> prototypes=new ArrayList<>();
        for (MeleeWeapon Weapon: MeleeWeaponFactory.all()){
            for(int dex=1; dex<=5; dex++){
                for(int stam=1;stam<=5; stam++){
                    int str=attributeTotal-dex-stam;
                    if(1<= str && str<= 5){
                        for(int thresh=3; thresh<=25; thresh++){
                            MortalTestAttacker prot= new MortalTestAttacker();
                            prot.setThresh(thresh);
                            prot.attributes.Dexterity=dex;
                            prot.attributes.Stamina=stam;
                            prot.attributes.Strength=str;
                            prot.arnament=new ArrayList<>();
                            prot.arnament.add(Weapon);
                            prototypes.add(prot);
                        }
                    }
                }
            }
        }
        GeneticPool genpool=new GeneticPool(prototypes,5);
        MortalTestAttackerPoolAnalyzer analyzer=new MortalTestAttackerPoolAnalyzer(genpool);
        for (int j=0; j<2; j++){
            for(int i: analyzer.dexstats.keySet()){
                System.out.println(i+":"+analyzer.dexstats.get(i));
            }
            genpool.runPool(2);
        }


    }


}
