package lukas.kohlhase;

public class AttackState {
    /*
    The intention is for instances of this class to be passed along by attacker and defender, and being changed constantly. Contains all the relevant information about an attack, so taht people can react to it.
     */
    public AttackState currentPhase;
    public int initialAttackpool;
    public int initialDv;
    public int changedAttackpool;
    public int changedDv;
    public Rollvaluation AttackerAttackRollValuation;
    public DiceThrow initialAttackRoll;
    public DiceThrow attackerModifiedAttackRoll;
    public DiceThrow defenderModifiedAttackRoll;
    public int attackRollSuccesses;
    public int threshholdSuccesses;
    public int thresholdModifiedAttacker;
    public int thresholdModifiedDefender;
    public int defenderNaturalSoak;
    public int defenderArmorSoak; //TODO: Change this if we ever see different kinds of soak
    public int totalSoak;
    public int totalSoakModifiedAttacker;
    public int totalSoakModifiedDefender;
    public int postSoakSuccesses;
    public int postSoakSuccessesModifiedAttacker;
    public int postSoakSuccessesModifiedDefender;
    public int rawDamage;
    public int rawDamageModifiedDefender;
    public int rawDamageModifiedAttacker;
    public DiceThrow damageRoll;
    public DiceThrow damageRollModifiedAttacker;
    public DiceThrow damageRollModifiedDefender;
    public Rollvaluation damageRollValuation;
    public int initiativeDamageDone;
    public int initiativeDamageDoneModifiedAttacker;
    public int initiativeDamageDoneModifiedDefender;
    public HealthLevel healthDamageDone;
    public HealthLevel healthDamageDoneModifiedAttacker;
    public HealthLevel healthDamageDoneModifiedDefender; //TODO: Possibly add something like charms used in which phases.
    public int weaponDamage;
    public Boolean defenderCrashed;
    public Boolean attackerCrashed;

}
