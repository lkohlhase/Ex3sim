package lukas.kohlhase;

public class CharmCost {
    public int Mote;
    public int Willpower;
    public HealthLevel Health;
    public int Anima;
    public int Initiative;

    public CharmCost(int mote, int willpower, HealthLevel health, int anima,int init) {
        Mote = mote;
        Willpower = willpower;
        this.Health = health;
        Anima = anima;
        Initiative=init;
    }
}
