package lukas.kohlhase.Weapons;

import lukas.kohlhase.damage;

import java.util.ArrayList;
//Possible TODO: worry about attunement costs of weapons.
public class MeleeWeapon {
    private int Accuracy;
    private int Damage;
    private int Overwhelming;
    private int Defense;
    public enum WeaponTags{BALANCED, BASHING, BRAWL, CHOPPING, DISARMING, FLEXIBLE, IMPROVISED, GRAPPLING, LETHAL, MARTIAL, MELEE, NATURAL, PIERCING, REACHING, SHIELD, SMASHING, THROWN, TWOHANDED, WORN}
    public ArrayList<WeaponTags> Tags;
    Boolean Artifact;
    public enum WeaponType{LIGHT,MEDIUM,HEAVY}
    WeaponType Type; // We can generate the private stuff according to the tags and the type of weapon
    damage damagetype;
    public ArrayList<String> usablewith;
    public void setAccuracy(int accuracy) {
        Accuracy = accuracy;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public void setOverwhelming(int overwhelming) {
        Overwhelming = overwhelming;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getAccuracy() {
        return Accuracy;
    }

    public int getDamage() {
        return Damage;
    }

    public int getOverwhelming() {
        return Overwhelming;
    }

    public int getDefense() {
        return Defense;
    }

    public MeleeWeapon(ArrayList<WeaponTags> tags, WeaponType type, Boolean artifact) {
        Tags = tags;
        Type = type;
        Artifact = artifact;
        switch (type){ //Sets up the stats for weapons without tags
            case LIGHT:
                if(Artifact){
                    Accuracy=5;
                    Damage=10;
                    Defense=0;
                    Overwhelming=3;
                }
                else {
                    Accuracy=4;
                    Damage=7;
                    Overwhelming=1;
                    Defense=0;
                }

            case MEDIUM:
                if(Artifact){
                    Accuracy=3;
                    Damage=12;
                    Defense=1;
                    Overwhelming=4;
                }
                else {
                    Accuracy=2;
                    Damage=9;
                    Defense=1;
                    Overwhelming=1;
                }
            case HEAVY:
                if(Artifact){
                    Accuracy=1;
                    Damage=14;
                    Defense=0;
                    Overwhelming=5;
                }
                else {
                    Accuracy=0;
                    Damage=11;
                    Defense=-1;
                    Overwhelming=0;
                }
        }
        //Now we modify the weapons according to what tags they have.
        ArrayList<WeaponTags> encountered=new ArrayList<>();
        for(WeaponTags tag:tags){
            if(encountered.contains(tag)){
                System.out.println("Duplicate Tags are not allowed, Ignoring it");
            }
            else{
                encountered.add(tag);
                switch (tag) {
                    case BALANCED:
                        Overwhelming++;
                    case BASHING:
                        damagetype=damage.BASHING;
                    case BRAWL:
                        usablewith.add("BRAWL");
                    case CHOPPING:
                        usablewith.add("CHOPPING");
                    case DISARMING:
                        usablewith.add("DISARMING");
                    case FLEXIBLE: //Doesn't fit into our model of how we play. possible TODO: Implement a way to deal with this.
                        break;
                    case IMPROVISED:
                        usablewith.add("IMPROVISEDMELEE");
                        usablewith.add("IMPROVISEDBRAWL");
                    case GRAPPLING:
                        usablewith.add("GRAPPLING");
                    case LETHAL:
                        damagetype=damage.LETHAL;
                    case MARTIAL:
                        usablewith.add("MARTIAL");
                    case MELEE:
                        usablewith.add("MELEE");
                    case NATURAL:
                        break;  //TODO: Implement when we implement disarms or other stuff.
                    case PIERCING:
                        usablewith.add("PIERCING");
                    case REACHING:
                        break; //TODO: Implement when and if we ever implement mounted combat
                    case SHIELD:
                        Damage=Damage-2; //Implement something for when we ever add flurries.
                    case SMASHING:
                        usablewith.add("SMASHING");
                    case THROWN:
                        usablewith.add("THROWN");
                    case TWOHANDED:
                        break; //TODO: Look into implementing this when we do something with clash attacks.
                    case WORN:
                        break; //TODO: Implement when we implement disarms or other stuff.
                    }
                }
            }
        }

    }

