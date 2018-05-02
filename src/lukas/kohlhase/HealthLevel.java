package lukas.kohlhase;
import java.util.*;
public class HealthLevel {
    Vector<damage> minus0,minus1,minus2,minus4,incap;
    Vector<damage> tempminus0,tempminus1,tempminus2,tempminus4;

    public HealthLevel(int zeros, int ones,int twos,int fours, int incapd){
        Vector<damage> tempminus0=new Vector<damage>(0);
        Vector<damage> tempminus1=new Vector<damage>(0);
        Vector<damage> tempminus2=new Vector<damage>(0);
        Vector<damage> tempminus4=new Vector<damage>(0);
        for (int i=0;i<zeros;i++){
            minus0.add(damage.UNDAMAGED);
        }
        for (int i=0;i<ones;i++){
            minus1.add(damage.UNDAMAGED);
        }
        for (int i=0;i<twos;i++){
            minus2.add(damage.UNDAMAGED);
        }
        for (int i=0;i<fours;i++){
            minus2.add(damage.UNDAMAGED);
        }
        for (int i=0;i<incapd;i++){
            incap.add(damage.UNDAMAGED);
        }
    }
    public HealthLevel(){
        this(1,2,2,1,1); //Default values for human characters.
    }
    public void takeDamage(int amount,damage type){
        /*
        Takes damage in the exalted way, so first filling up the -0 health levels etc. and then filling up the lower ones.
         */
        for(int i=0;i<amount; i++){
            if (tempminus0.contains(damage.UNDAMAGED)){
                tempminus0.set(tempminus0.indexOf(damage.UNDAMAGED),type);
            }
            else if (minus0.contains(damage.UNDAMAGED)){
                tempminus0.set(minus0.indexOf(damage.UNDAMAGED),type);
            }
            else if (tempminus1.contains(damage.UNDAMAGED)){
                tempminus0.set(tempminus1.indexOf(damage.UNDAMAGED),type);
            }
            else if (minus0.contains(damage.UNDAMAGED)){
                tempminus0.set(tempminus0.indexOf(damage.UNDAMAGED),type);
            }
            else if (minus1.contains(damage.UNDAMAGED)){
                minus1.set(minus1.indexOf(damage.UNDAMAGED),type);
            }
            else if (tempminus2.contains(damage.UNDAMAGED)){
                tempminus2.set(tempminus2.indexOf(damage.UNDAMAGED),type);
            }
            else if (minus2.contains(damage.UNDAMAGED)){
                minus2.set(minus2.indexOf(damage.UNDAMAGED),type);
            }
            else if (tempminus4.contains(damage.UNDAMAGED)){
                tempminus4.set(tempminus4.indexOf(damage.UNDAMAGED),type);
            }
            else if (minus4.contains(damage.UNDAMAGED)){
                minus4.set(minus4.indexOf(damage.UNDAMAGED),type);
            }
            else if (incap.contains(damage.UNDAMAGED)){
                incap.set(incap.indexOf(damage.UNDAMAGED),type);
            } //TODO Handle wrapping over of BASHING damage into LETHAL.
        }
    }
    public boolean incaped(){
        return incap.get(0)!=damage.UNDAMAGED;
    }
}
