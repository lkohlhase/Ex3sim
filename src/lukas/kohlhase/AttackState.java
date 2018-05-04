package lukas.kohlhase;

public class AttackState {
    /*
    The intention is for instances of this class to be passed along by attacker and defender, and being changed constantly. Contains all the relevant information about an attack, so taht people can react to it.
     */
    AttackState currentPhase;
    int initialAttackpool;
    int initialDv;
    int changedAttackpool;
    int changedDv;
    Rollvaluation AttackerAttackRollValuation;
    DiceThrow initialAttackRoll;
    DiceThrow attackerModifiedAttackRoll;
    DiceThrow defenderModifiedAttackRoll;
    int attackRollSuccesses;
    int threshholdSuccesses;
    int thresholdModifiedAttacker;
    int thresholdModifiedDefender;
    int defenderNaturalSoak;
    int defenderArmorSoak; //TODO: Change this if we ever see different kinds of soak
    int totalSoak;
    int totalSoakModifiedAttacker;
    int totalSoakModifiedDefender;
    int postSoakSuccesses;
    int postSoakSuccessesModifiedAttacker;
    int postSoakSuccessesModifiedDefender;
    int rawDamage;
    int rawDamageModifiedDefender;
    int rawDamageModifiedAttacker;
    DiceThrow damageRoll;
    DiceThrow damageRollModifiedAttacker;
    DiceThrow damageRollModifiedDefender;
    Rollvaluation damageRollValuation;
    int initiativeDamageDone;
    int initiativeDamageDoneModifiedAttacker;
    int initiativeDamageDoneModifiedDefender;
    HealthLevel healthDamageDone;
    HealthLevel healthDamageDoneModifiedAttacker;
    HealthLevel healthDamageDoneModifiedDefender; //TODO: Possibly add something like charms used in which phases.

}
