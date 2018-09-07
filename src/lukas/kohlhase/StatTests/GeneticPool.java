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

    private ArrayList<MortalTestAttacker> participants;
    private Random rand=new Random();
    public GeneticPool(ArrayList<MortalTestAttacker> prototypes, int numcopies, String mutationtype){
        System.out.println("Not yet implemented");
    }
    public void runPool(int numfights){
        System.out.println("Not yet Implemented");
    }
    private void mutateAttThreshWeapon(MortalTestAttacker mutant){
        int rng=rand.nextInt(3);
        switch (rng){
            case 0: //change the attribute distribution
                logger.log(Level.INFO,"Changing the stat distribution");
                int rnga=rand.nextInt(3);
                switch (rnga){
                    case 0:
                        if (mutant.attributes.Dexterity<5){
                            Boolean stam=rand.nextInt(2)==0;
                            if (mutant.attributes.Stamina>1 && stam){
                                logger.log(Level.INFO,"Increasing dex and decreasing stamina");
                                mutant.attributes.Dexterity++;
                                mutant.attributes.Stamina--;
                            }
                            if (mutant.attributes.Strength>1 && !stam){
                                logger.log(Level.INFO,"Increasing dex and decreasing strength");

                                mutant.attributes.Dexterity++;
                                mutant.attributes.Strength--;
                            }
                        }
                        else
                            logger.log(Level.INFO,"Not changing distribtuions of attributes");
                        break;
                    case 1:
                        if (mutant.attributes.Strength<5){
                            Boolean stam=rand.nextInt(2)==0;
                            if (mutant.attributes.Stamina>1 && stam){
                                logger.log(Level.INFO,"Increasing Strength and decreasing stamina");
                                mutant.attributes.Strength++;
                                mutant.attributes.Stamina--;
                            }
                            if (mutant.attributes.Dexterity>1 && !stam){
                                logger.log(Level.INFO,"Increasing strength and decreasing dex");

                                mutant.attributes.Dexterity--;
                                mutant.attributes.Strength++;
                            }
                        }
                        else
                            logger.log(Level.INFO,"Not changing distribtuions of attributes");
                        break;
                    case 2:
                        if (mutant.attributes.Stamina<5){
                            Boolean dex=rand.nextInt(2)==0;
                            if (mutant.attributes.Dexterity>1  && dex){
                                logger.log(Level.INFO,"Increasing stamina and decreasing dex");
                                mutant.attributes.Dexterity--;
                                mutant.attributes.Stamina++;
                            }
                            if (mutant.attributes.Strength>1 && !dex){
                                logger.log(Level.INFO,"Increasing stamina and decreasing strength");

                                mutant.attributes.Stamina++;
                                mutant.attributes.Strength--;
                            }
                        }
                        else
                            logger.log(Level.INFO,"Not changing distribtuions of attributes");
                        break;
                }
                break;

            case 1://Change the threshhold
                logger.log(Level.INFO,"Mutating the threshold for decisive attacks");
                int rngt=rand.nextInt(3);
                switch (rngt){
                    case 0:
                        logger.log(Level.INFO,"Decreasing Threshhold");
                        mutant.setThresh(mutant.getThresh()-1);
                        break;
                    case 1:
                        logger.log(Level.INFO,"Threshhold staying the same");
                        mutant.setThresh(mutant.getThresh());
                        break;
                    case 2:
                        logger.log(Level.INFO,"Increasing Threshhold");
                        mutant.setThresh(mutant.getThresh()+1);
                        break;
                }
                break;
            case 2:
                logger.log(Level.INFO, "Mutating Weapon");
                int rngw;
                switch(mutant.arnament.get(0).Type){//Change the weapon
                    case LIGHT:
                        mutant.arnament=new ArrayList<MeleeWeapon>();
                        rngw=rand.nextInt(LightMortalMeleeWeaponFactory.all().size());
                        mutant.arnament.add(LightMortalMeleeWeaponFactory.all().get(rngw));
                        logger.log(Level.FINE,"Changing to "+LightMortalMeleeWeaponFactory.all().get(rngw).name+". ");
                        break;
                    case MEDIUM:
                        mutant.arnament=new ArrayList<MeleeWeapon>();
                        rngw=rand.nextInt(MediumMortalMeleeWeaponFactory.all().size());
                        mutant.arnament.add(MediumMortalMeleeWeaponFactory.all().get(rngw));
                        logger.log(Level.FINE,"Changing to "+LightMortalMeleeWeaponFactory.all().get(rngw).name+". ");
                        break;
                    case HEAVY:
                        mutant.arnament=new ArrayList<MeleeWeapon>();
                        rngw=rand.nextInt(HeavyMortalMeleeWeaponFactory.all().size());
                        mutant.arnament.add(HeavyMortalMeleeWeaponFactory.all().get(rngw));
                        logger.log(Level.FINE,"Changing to "+LightMortalMeleeWeaponFactory.all().get(rngw).name+". ");
                        break;
                }
                break;
        }
    }
}
