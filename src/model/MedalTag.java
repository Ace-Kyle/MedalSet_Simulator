package model;

import java.util.HashMap;
import java.util.Map;

public class MedalTag {
    public int typeid;
    private int medal_tag_id;
    private String name;
    private int tag_category;
    private int set2_ability_id;
    private int set3_ability_id;
    private int sort_id;

    // Getters and setters
    public int getMedal_tag_id() { return medal_tag_id; }
    public void setMedal_tag_id(int medal_tag_id) { this.medal_tag_id = medal_tag_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTag_category() { return tag_category; }
    public void setTag_category(int tag_category) { this.tag_category = tag_category; }

    public int getSet2_ability_id() { return set2_ability_id; }
    public void setSet2_ability_id(int set2_ability_id) { this.set2_ability_id = set2_ability_id; }

    public int getSet3_ability_id() { return set3_ability_id; }
    public void setSet3_ability_id(int set3_ability_id) { this.set3_ability_id = set3_ability_id; }

    public int getSort_id() { return sort_id; }
    public void setSort_id(int sort_id) { this.sort_id = sort_id; }


    public String getAffectByNumberCombineTag(int number) {
        return switch (number){
            case 2 -> new Ability(this.set2_ability_id).getAffects().toString();
            case 3 -> new Ability(this.set3_ability_id).getAffects().toString();
            default -> "";
        };
    }

}
