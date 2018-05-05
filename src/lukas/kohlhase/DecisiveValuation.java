package lukas.kohlhase;

public class DecisiveValuation extends Rollvaluation {
    /*
    Same as rollvaluation, however 10s aren't doubled on default damageType rolls.
     */
    public DecisiveValuation(){
        rollvalues= new String[]{"1","0","0","0","0","0","0","1","1","1"};
    }
}
