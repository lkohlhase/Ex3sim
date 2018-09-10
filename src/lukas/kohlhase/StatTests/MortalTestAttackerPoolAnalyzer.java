package lukas.kohlhase.StatTests;

import lukas.kohlhase.Characters.FullCharacter;
import lukas.kohlhase.Characters.MortalTestAttacker;
import lukas.kohlhase.Items.MeleeWeapon;

import java.util.HashMap;

public class MortalTestAttackerPoolAnalyzer {
    public HashMap<String, Integer> deaggregated = new HashMap<>(); //Various dictionaries containing aggregated and un aggregated data about the current pool.
    public HashMap<Integer, Integer> dexstats = new HashMap<>();
    public HashMap<Integer, Integer> strstats = new HashMap<>();
    public HashMap<Integer, Integer> stamstats = new HashMap<>();
    public HashMap<Integer, Integer> threshstats = new HashMap<>();
    public HashMap<MeleeWeapon.WeaponType, Integer> typestats = new HashMap<>();
    public HashMap<String, Integer> weaponstats = new HashMap<>();


    public MortalTestAttackerPoolAnalyzer(GeneticPool pool) {
        for (FullCharacter dude : pool.participants) { // We fill our various hashmaps with values whenever we discover an element.
            if (dude instanceof MortalTestAttacker) {
                MortalTestAttacker mdude = (MortalTestAttacker) dude;
                String identifier = key(mdude);
                if (deaggregated.containsKey(identifier)) {
                    deaggregated.put(identifier, deaggregated.get(identifier) + 1);
                } else
                    deaggregated.put(identifier, 1);

                if (dexstats.containsKey(dude.attributes.Dexterity)) {
                    dexstats.put(dude.attributes.Dexterity, dexstats.get(dude.attributes.Dexterity) + 1);
                } else
                    dexstats.put(dude.attributes.Dexterity, 1);
                if (strstats.containsKey(dude.attributes.Strength)) {
                    strstats.put(dude.attributes.Strength, strstats.get(dude.attributes.Strength) + 1);
                } else
                    strstats.put(dude.attributes.Strength, 1);
                if(stamstats.containsKey(dude.attributes.Stamina)){
                    stamstats.put(dude.attributes.Stamina,stamstats.get(dude.attributes.Stamina)+1);
                }
                if(threshstats.containsKey(mdude.getThresh())){
                    threshstats.put(mdude.getThresh(),threshstats.get(mdude.getThresh())+1);
                }
                else
                    threshstats.put(mdude.getThresh(),1);
                if(typestats.containsKey(mdude.arnament.get(0).Type)){
                    typestats.put(mdude.arnament.get(0).Type,typestats.get(mdude.arnament.get(0).Type)+1);
                }
                if (weaponstats.containsKey(mdude.arnament.get(0).name)){
                    weaponstats.put(mdude.arnament.get(0).name,weaponstats.get(mdude.arnament.get(0).name)+1);
                }
                else 
                    weaponstats.put(mdude.arnament.get(0).name,1);
            }
        }
    }

    public String key(MortalTestAttacker dude) {
        String returnable = "";
        returnable += dude.getThresh();
        returnable += "|" + dude.attributes.Dexterity;
        returnable += "|" + dude.attributes.Stamina;
        returnable += "|" + dude.attributes.Strength;
        returnable += "|" + dude.arnament.get(0).name;
        return returnable;
    }
}
