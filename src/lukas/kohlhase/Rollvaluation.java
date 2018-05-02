package lukas.kohlhase;

public class Rollvaluation {
    String[] rollvalues;
    public Rollvaluation(String[] values){
        for (int j=0; j<values.length; j++){
            String i=values[j];
            if (i!="1" && i!="2" && i!="reroll" && i!="0"&& i!="cascading1" && i!="cascading2") {
                System.out.println("Encountered an unexpected value for a diceresult");
                values[j]="1";
            }
        rollvalues=values;
        }
    }
    public Rollvaluation(){
        rollvalues= new String[]{"2","0","0","0","0","0","0","1","1","1"};
    }

}
