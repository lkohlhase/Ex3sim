package lukas.kohlhase;
import lukas.kohlhase.Actions.Action;
import lukas.kohlhase.Characters.ErrorActor;
import lukas.kohlhase.Dice.DiceThrow;

import java.util.*;

public class CombatScene {
    public ArrayList<CombatActor> participants;
    int currentround;
    public ArrayList<CombatActor> yetToAct =new ArrayList<>();
    public ArrayList<CombatActor> alreadyActed = new ArrayList<>();
    public CombatScene(ArrayList<CombatActor> actors){ //Basic idea is free for all for now
        participants=actors;
        currentround=0;
        for(CombatActor actor: actors){ //Initializing the enemies and allies of the characters.
            ArrayList<CombatActor> enemies= (ArrayList)actors.clone(); //Need to check whether this works with a shallow copy, but it should, since we're not actually changing the actors.
            enemies.remove(actor);
            actor.setEnemies(enemies);
            actor.setAllies(new ArrayList<CombatActor>());//Curently not modelling allies
        }
        joinBattle();

    }

    public void joinBattle(){
        for (CombatActor i: participants){
            int joinbattlepool=i.declareJoinBattle();
            DiceThrow joinBattleRoll=new DiceThrow(joinbattlepool);
            int joinbattleresult=joinBattleRoll.evaluateResults();
            i.setInitiative(joinbattleresult+3);
            yetToAct.add(i);
            System.out.println(i.getName()+" rolled Join Battle with "+joinbattlepool+" dice and got "+joinbattleresult+" successes.");

        }
    }
    public void fullCombat(){
        this.joinBattle();
        this.runCombat();
    }
    public CombatActor getCurrentActor(){
        /*
        Finds the person currently acting by looking for the one with highest initiative;
         */
        if (yetToAct.isEmpty()){
            System.out.println("Round has ended, nothing will be returned");
            return new ErrorActor();
        }
        else {
            Comparator<CombatActor> cmp=new Comparator<CombatActor>() {
                @Override
                public int compare(CombatActor o1, CombatActor o2) {
                    return o1.getInitiative()-o2.getInitiative();
                }
            };

            return Collections.max(yetToAct,cmp);
        }
    }

    public void endRound(){
        if(!yetToAct.isEmpty()){
            System.out.println("A character hasn't taken an action. Sucks to be them I guess");
            yetToAct.clear();

        }
        for(CombatActor i:participants){
            i.endOfRound();
            yetToAct.add(i);

        }
        alreadyActed.clear();
        currentround++;
        for (CombatActor i: participants){
            System.out.println(i.getName()+": "+i.getInitiative()+" Initiative");
            System.out.println(i.getName()+" health:");
            i.getHealth().print();
        }
        System.out.println("Round "+currentround+" is ending. ");
        System.out.println("===================================================================================");

    }

    public void runRound(){
        while(!yetToAct.isEmpty()){
            CombatActor current=getCurrentActor();
            Action currentAction=current.chooseAction(participants.toArray(new CombatActor[participants.size()]));
            currentAction.resolve();
            yetToAct.remove(current);
            alreadyActed.add(current);
            ArrayList<CombatActor> toberemoved=new ArrayList<>();
            for (CombatActor dude: participants){
                if (dude.getHealth().incaped()){
                    toberemoved.add(dude);
                    yetToAct.remove(dude);
                }
            }
            for (CombatActor dude:toberemoved){
                this.removeParticipant(dude);
            }

        }
    }
    public void runCombat(){
        while (!combatOver()){
            runRound();
            endRound();
        }
    }

    public boolean combatOver(){
        if(currentround >15){
            return true;
        }
        return participants.size() <= 1;
    }
    public void resetCombat(){
        for (CombatActor participant: this.participants){
            participant.getHealth().reset();
        }
        this.currentround=0;
    }
    public void addParticipantToFight(CombatActor a){
        participants.add(a);
        int joinbattlepool=a.declareJoinBattle();
        DiceThrow joinBattleRoll=new DiceThrow(joinbattlepool);
        int joinbattleresult=joinBattleRoll.evaluateResults();
        a.setInitiative(joinbattleresult);
        yetToAct.add(a);
    }
    public void addParticipant(CombatActor a){
        participants.add(a);
    }
    public void removeParticipant(CombatActor a){
        participants.remove(a);
        yetToAct.remove(a);
        alreadyActed.remove(a);
    }
}
