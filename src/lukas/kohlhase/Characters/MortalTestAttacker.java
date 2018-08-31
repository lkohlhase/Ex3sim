package lukas.kohlhase.Characters;

import lukas.kohlhase.Actions.Action;
import lukas.kohlhase.Actions.Attack;
import lukas.kohlhase.CombatActor;

import java.util.ArrayList;

public class MortalTestAttacker extends FullCharacter {
    public MortalTestAttacker() {
        this.name="MortalTestAttacker"+java.util.UUID.randomUUID().toString();
    }

    public Action chooseAction(CombatActor[] actors) {
        ArrayList<Attack> possibleAttacks=this.generateMeleeAttacks();
        for (Attack attack: possibleAttacks){
            if(this.getInitiative()>=17){
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
        System.out.println("There was an error with choosing attacks. This is literally just in for testing purposes");
        return possibleAttacks.get(0);//When all else fails just return the first element. This is unreachable and really only put in to make the IDE neater. TODO: think about making a custom exception for this.

    }
}
