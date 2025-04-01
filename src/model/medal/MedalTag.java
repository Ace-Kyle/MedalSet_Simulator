package model.medal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.Ability;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedalTag {

    int typeid; //add field for classify effects

    @JsonProperty("medal_tag_id")
    private int id;
    private String name;
    private int tag_category;

    @JsonProperty("set2_ability_id")
    private int effect_pair; //Pair-effect
    @JsonProperty("set3_ability_id")
    private int effect_trio; //Trio-effect
    private int sort_id;

    public MedalTag(){}

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTag_category() { return tag_category; }
    public void setTag_category(int tag_category) { this.tag_category = tag_category; }

    public int getSet2_ability_id() { return effect_pair; }
    public void setSet2_ability_id(int set2_ability_id) { this.effect_pair = set2_ability_id; }

    public int getSet3_ability_id() { return effect_trio; }
    public void setSet3_ability_id(int set3_ability_id) { this.effect_trio = set3_ability_id; }

    public int getSort_id() { return sort_id; }
    public void setSort_id(int sort_id) { this.sort_id = sort_id; }


    public String getAffectByNumberCombineTag(int number) {
        //depend on number of medal have the same specific tag,
        //it will give correspond effects
        return switch (number){
            case 2 -> new Ability(this.effect_pair).getAffects().toString();
            case 3 -> new Ability(this.effect_trio).getAffects().toString();
            default -> "";
        };
    }

}
