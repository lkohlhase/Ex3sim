package lukas.kohlhase.Items;

import lukas.kohlhase.damageType;

import java.util.ArrayList;
//Possible TODO: worry about attunement costs of weapons.
//TODO: Check why weapons don't seem to have any proper values at all.
public class MeleeWeapon {
    private int Accuracy;

    private int Damage;
    private int Overwhelming;
    private int Defense;
    private int AttunementCost;
    public enum WeaponTags{BALANCED, BASHING, BRAWL, CHOPPING, DISARMING, FLEXIBLE, IMPROVISED, GRAPPLING, LETHAL, MARTIAL, MELEE, NATURAL, PIERCING, REACHING, SHIELD, SMASHING, THROWN, TWOHANDED, WORN}
    public ArrayList<WeaponTags> Tags;
    Boolean Artifact;
    public enum WeaponType{LIGHT,MEDIUM,HEAVY}
    public WeaponType Type; // We can generate the private stuff according to the tags and the type of weapon
    public String name="unspecified";
    public damageType damagetype;
    public ArrayList<String> usablewith = new ArrayList<>();
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
        return this.Accuracy;
    }

    public int getDamage() {
        return this.Damage;
    }

    public int getOverwhelming() {
        return this.Overwhelming;
    }

    public int getDefense() {
        return this.Defense;
    }

    public MeleeWeapon(ArrayList<WeaponTags> tags, WeaponType type, Boolean artifact) {
        Tags = tags;
        Type = type;
        Artifact = artifact;
        switch (type){ //Sets up the stats for weapons without tags
            case LIGHT:
                if(Artifact){
                    this.Accuracy=5;
                    this.Damage=10;
                    this.Defense=0;
                    this.Overwhelming=3;
                    this.AttunementCost = 5;
                }
                else {
                    this.Accuracy=4;
                    this.Damage=7;
                    this.Overwhelming=1;
                    this.Defense=0;
                    this.AttunementCost = 0;
                }
                break;
            case MEDIUM:
                if(Artifact){
                    this.Accuracy=3;
                    this.Damage=12;
                    this.Defense=1;
                    this.Overwhelming=4;
                    this.AttunementCost = 5;
                }
                else {
                    this.Accuracy=2;
                    this.Damage=9;
                    this.Defense=1;
                    this.Overwhelming=1;
                    this.AttunementCost = 0;
                }
                break;
            case HEAVY:
                if(Artifact){
                    this.Accuracy=1;
                    this.Damage=14;
                    this.Defense=0;
                    this.Overwhelming=5;
                    this.AttunementCost = 5;
                }
                else {
                    this.Accuracy=0;
                    this.Damage=11;
                    this.Defense=-1;
                    this.Overwhelming=0;
                    this.AttunementCost = 0;
                }
                break;
        }
        //Now we modify the weapons according to what tags they have.
        ArrayList<WeaponTags> encountered=new ArrayList<>();
        for(WeaponTags tag:tags){
            if(encountered.contains(tag)){
                System.out.println("Duplicate Tags are not allowed, Ignoring one instance of "+tag);
            }
            else{
                encountered.add(tag);
                switch (tag) {
                    case BALANCED:
                        Overwhelming++;
                        break;
                    case BASHING:
                        damagetype= damageType.BASHING;
                        break;
                    case BRAWL:
                        usablewith.add("BRAWL");
                        break;
                    case CHOPPING:
                        usablewith.add("CHOPPING");
                        break;
                    case DISARMING:
                        usablewith.add("DISARMING");
                        break;
                    case FLEXIBLE: //Doesn't fit into our model of how we play. possible TODO: Implement a way to deal with this.
                        break;
                    case IMPROVISED:
                        usablewith.add("IMPROVISEDMELEE");
                        usablewith.add("IMPROVISEDBRAWL");
                        break;
                    case GRAPPLING:
                        usablewith.add("GRAPPLING");
                        break;
                    case LETHAL:
                        damagetype= damageType.LETHAL;
                        break;
                    case MARTIAL:
                        usablewith.add("MARTIAL");
                        break;
                    case MELEE:
                        usablewith.add("MELEE");
                        break;
                    case NATURAL:
                        break;  //TODO: Implement when we implement disarms or other stuff.
                    case PIERCING:
                        usablewith.add("PIERCING");
                        break;
                    case REACHING:
                        break; //TODO: Implement when and if we ever implement mounted combat
                    case SHIELD:
                        Damage=Damage-2; //Implement something for when we ever add flurries.
                        break;
                    case SMASHING:
                        usablewith.add("SMASHING");
                        break;
                    case THROWN:
                        usablewith.add("THROWN");
                        break;
                    case TWOHANDED:
                        break; //TODO: Look into implementing this when we do something with clash attacks.
                    case WORN:
                        break; //TODO: Implement when we implement disarms or other stuff.
                    }
                }
            }

        }
    }

