package lukas.kohlhase.Items;

public class Armor {
    private int Hardness;
    private int Soak;
    private int MobilityPenalty;
    private int AttunementCost;
    Boolean Artifact;
    public enum ArmorType{LIGHT,MEDIUM,HEAVY,UNARMORED}

    ArmorType Type;
    public Armor( ArmorType type, Boolean artifact) {
        Type = type;
        Artifact = artifact;
        switch (type) { //Sets up the stats for weapons without tags
            case LIGHT:
                if (Artifact) {
                    Hardness = 4;
                    Soak = 5;
                    MobilityPenalty = 0;
                    AttunementCost = 4;
                } else {
                    Hardness = 0;
                    Soak = 3;
                    MobilityPenalty = 0;
                    AttunementCost = 0;
                }

            case MEDIUM:
                if (Artifact) {
                    Hardness = 7;
                    Soak = 8;
                    MobilityPenalty = 1;
                    AttunementCost = 5;
                } else {
                    Hardness = 0;
                    Soak = 5;
                    MobilityPenalty = 1;
                    AttunementCost = 0;
                }
            case HEAVY:
                if (Artifact) {
                    Hardness = 10;
                    Soak = 11;
                    MobilityPenalty = 2;
                    AttunementCost = 6;
                } else {
                    Hardness = 0;
                    Soak = 7;
                    MobilityPenalty = 2;
                    AttunementCost = 0;
                }
            case UNARMORED:
                Hardness=0;
                Soak=0;
                MobilityPenalty=0;
                AttunementCost=0;
        }
    }
//Don't think we need setters. Not behaviour we really want.
    public int getHardness() {
        return Hardness;
    }

    public int getSoak() {
        return Soak;
    }

    public int getMobilityPenalty() {
        return MobilityPenalty;
    }

    public int getAttunementCost() {
        return AttunementCost;
    }
}
