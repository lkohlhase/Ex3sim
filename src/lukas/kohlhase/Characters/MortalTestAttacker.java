package lukas.kohlhase.Characters;

import lukas.kohlhase.Actions.Action;
import lukas.kohlhase.Actions.Attack;
import lukas.kohlhase.CombatActor;

import java.util.ArrayList;
import java.util.logging.Level;

public class MortalTestAttacker extends FullCharacter { // A simple full character that acts as a mortal. Whithering attacks till his initiative is over thresh (default: 17) and then decisive attacks.
    private int thresh;



    public MortalTestAttacker() {
        this.name="MortalTestAttacker"+java.util.UUID.randomUUID().toString();
        this.thresh=17;
    }
    public MortalTestAttacker(MortalTestAttacker a){
        super(a);
        this.thresh=a.thresh;
    }
    public MortalTestAttacker(String name){
        super();
        this.name=name;
        this.thresh=17;
    }
    public MortalTestAttacker(String name, int initthreshold){
        super();
        this.name=name;
        this.thresh=initthreshold;
    }
    public Action chooseAction(CombatActor[] actors) {
        ArrayList<Attack> possibleAttacks=this.generateMeleeAttacks();
        for (Attack attack: possibleAttacks){
            if(this.getInitiative()>=this.thresh){
                if(attack.isDecisive()){
                    return attack;
                }
            }
            else{
                if(attack.isWhithering()){
                    return attack;
                }
            }
        }
        logger.log(Level.SEVERE,"There was an error with choosing attacks. Please fix");
        return possibleAttacks.get(0);//When all else fails just return the first element. This is unreachable and really only put in to make the IDE neater. TODO: think about making a custom exception for this.

    }
    public int getThresh() {
        return thresh;
    }

    public void setThresh(int thresh) {
        if (thresh>0)
            this.thresh = thresh;
        else{
            logger.log(Level.WARNING,"Tried to set negative threshhold, this is not okay.");
        }
    }
}
