package lukas.kohlhase;

public class CharmCost {
    public int Mote;
    public int Willpower;
    public HealthLevel Health;
    public int Anima;
    public int Initiative; //All the costs are positive, so cost of 3 is losing 3 iniative.
    public int TempDefence; // Except for TempDefence, which is just added straight onto/off DV. Such is life mydudes.
    public CharmCost(int mote, int willpower, HealthLevel health, int anima,int init) {
        Mote = mote;
        Willpower = willpower;
        this.Health = health;
        Anima = anima;
        Initiative=init;
        TempDefence=0; //Always initialized to 0, unless specifically stated. Not generally a cost that is used.
    }
}
