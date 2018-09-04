package lukas.kohlhase;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HealthLevel {
    private static final Logger logger=Logger.getLogger("mylogger");

    Vector<damageType> minus0,minus1,minus2,minus4,incap;
    Vector<damageType> tempminus0,tempminus1,tempminus2,tempminus4;

    public HealthLevel(int zeros, int ones,int twos,int fours, int incapd){
        tempminus0= new Vector<>(0);
        tempminus1=new Vector<damageType>(0);
        tempminus2=new Vector<damageType>(0);
        tempminus4=new Vector<damageType>(0);
        minus0=new Vector<damageType>();
        minus1=new Vector<damageType>();
        minus2=new Vector<damageType>();
        minus4=new Vector<damageType>();
        incap=new Vector<damageType>();

        for (int i=0;i<zeros;i++){
            minus0.add(damageType.UNDAMAGED);
        }
        for (int i=0;i<ones;i++){
            minus1.add(damageType.UNDAMAGED);
        }
        for (int i=0;i<twos;i++){
            minus2.add(damageType.UNDAMAGED);
        }
        for (int i=0;i<fours;i++){
            minus4.add(damageType.UNDAMAGED);
        }
        for (int i=0;i<incapd;i++){
            incap.add(damageType.UNDAMAGED);
        }
    }
    public void reset(){ // Resets the health levels to full undamaged.
        Vector<damageType>[] levels=new Vector[]{minus0,minus1,minus2,minus4,incap};
        for (Vector<damageType> v:levels){
            for (int i=0; i<v.size();i++){
                v.set(i,damageType.UNDAMAGED);
            }
        }
    }
    public HealthLevel(){
        this(1,2,2,1,1); //Default values for human characters.
    }
    public void takeDamage(int amount,damageType type){
        /*
        Takes damageType in the exalted way, so first filling up the -0 health levels etc. and then filling up the lower ones.
         */
        for(int i=0;i<amount; i++){
            if (tempminus0.contains(damageType.UNDAMAGED)){
                tempminus0.set(tempminus0.indexOf(damageType.UNDAMAGED),type);
            }
            else if (minus0.contains(damageType.UNDAMAGED)){
                minus0.set(minus0.indexOf(damageType.UNDAMAGED),type);
            }
            else if (tempminus1.contains(damageType.UNDAMAGED)){
                tempminus1.set(tempminus1.indexOf(damageType.UNDAMAGED),type);
            }
            else if (minus1.contains(damageType.UNDAMAGED)){
                minus1.set(minus1.indexOf(damageType.UNDAMAGED),type);
            }
            else if (tempminus2.contains(damageType.UNDAMAGED)){
                tempminus2.set(tempminus2.indexOf(damageType.UNDAMAGED),type);
            }

            else if (minus2.contains(damageType.UNDAMAGED)){
                minus2.set(minus2.indexOf(damageType.UNDAMAGED),type);
            }
            else if (tempminus4.contains(damageType.UNDAMAGED)){
                tempminus4.set(tempminus4.indexOf(damageType.UNDAMAGED),type);
            }
            else if (minus4.contains(damageType.UNDAMAGED)){
                minus4.set(minus4.indexOf(damageType.UNDAMAGED),type);
            }
            else if (incap.contains(damageType.UNDAMAGED)){
                incap.set(incap.indexOf(damageType.UNDAMAGED),type);
            } //Note: Not handling wrapover of bashing into lethal, since we don't deal with healing anyway.
        }
    }
    public boolean incaped(){
        return incap.get(0)!= damageType.UNDAMAGED;
    }
    public int woundpenalty(){
        if (minus4.get(0)!=damageType.UNDAMAGED){
            return 4;
        }
        else if (minus2.get(0)!=damageType.UNDAMAGED){
            return 2;
        }
        if (minus1.get(0)!=damageType.UNDAMAGED){
            return 1;
        }
        else {
            return 0;
        }
    }
    public void print(){
        String logmessage="";
        logmessage+="Healthlevels: \n";
        logmessage+="-0:";
        logmessage+=printdamage(minus0);
        logmessage+="-1:";
        logmessage+=printdamage(minus1);
        logmessage+="-2:";
        logmessage+=printdamage(minus2);
        logmessage+="-4:";
        logmessage+=printdamage(minus4);

        if (incaped()){
            logmessage+="INCAPACITATED/DEAD";
        }
        logger.log(Level.FINE,logmessage);
    }

    private String printdamage(Vector<damageType> a) {
        String returnmessage="";
        for (damageType box: a){
            if(box == damageType.UNDAMAGED){
                returnmessage+="0";
            }
            else if(box == damageType.LETHAL){
                returnmessage+="L";
            }
            else if (box == damageType.BASHING){
                returnmessage+="B";
            }
            else if (box==damageType.AGGRAVATED){
                returnmessage+="A";
            }
            else{
                returnmessage+="E";
                logger.log(Level.WARNING,"an unexpected damagetype occured "+box.name());
            }

        }
    returnmessage+="\n";
    return returnmessage;
    }
}
