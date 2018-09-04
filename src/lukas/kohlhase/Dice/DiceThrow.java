package lukas.kohlhase.Dice;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiceThrow {
    /*
    Used for throwing dice in our simulations.
     */
    private static final Logger logger=Logger.getLogger("mylogger");

    int[] Results= {0,0,0,0,0,0,0,0,0,0};
    public DiceThrow(int numDice){
        for (int i=0; i<numDice; i++){
            Random rand=new Random();
            int dieroll=rand.nextInt(10);
            Results[dieroll]++;
        }
        String logoutput="Diceroll: ";
        for (int j=1; j<10; j++){
            for (int i=0; i<Results[j];i++){
                logoutput+=(j)+" ";
            }
        }
        for (int i=0; i<Results[0];i++){
            logoutput+="10 ";
        }
        logger.log(Level.FINER,logoutput);
    }
    public int evaluateResults(){
        int successcount=0;
        int rerollcount=0;
        Rollvaluation rollvalues=new Rollvaluation();
        for (int i=0; i<Results.length; i++){
            String numbervalue=rollvalues.rollvalues[i];
            int count=Results[i];
            for (int j=0; j<count;j++){
                if (numbervalue=="0" || numbervalue=="1" || numbervalue=="2"){
                    successcount+=Integer.parseInt(numbervalue);
                }
                else if(numbervalue=="reroll"){
                    rerollcount++;
                }
                else if(numbervalue=="cascading1"){
                    successcount++;
                    rerollcount++;
                }
                else if(numbervalue=="cascading2"){
                    successcount+=2;
                    rerollcount++;
                }
            }

        }
        return successcount;
    }
    public int evaluateResults(Rollvaluation d){
        int successcount=0;
        int rerollcount=0;
        for (int i=0; i<Results.length; i++){
            String numbervalue= d.rollvalues[i];
            int count=Results[i];
            for (int j=0; j<count;j++){
                if (numbervalue.equals("0") || numbervalue.equals("1") || numbervalue.equals("2")){
                    successcount+=Integer.parseInt(numbervalue);
                }
                else if(numbervalue.equals("reroll")){
                    rerollcount++;
                }
                else if(numbervalue.equals("cascading1")){
                    successcount++;
                    rerollcount++;
                }
                else if(numbervalue.equals("cascading2")){
                    successcount+=2;
                    rerollcount++;
                }
            }

        }
        return successcount; // TODO: Make a version of this that is not pure default, and make it reroll etc.
    }
    public DiceThrow(DiceThrow tobecopied){
        /*
        Very simple copy constructor for DiceThrow. Since it only contains the results of one throw, we simply copy results over.
         */
        this.Results=tobecopied.Results;
    }
}
