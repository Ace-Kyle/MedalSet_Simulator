package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {
    private List<Affect> affects;
    private int ability_id;
    private String icon_name;

    public Ability(int id) {

    }
    public Ability(){}
    //custom
    public String getAffectDetail(){
        //merge all affect detail into single one
        List<String> list = new ArrayList<>();
        for (Affect a : affects) {
            list.add(a.getDetail());
        }
        return String.join("\n", list);
    }

    // Getters and setters
    public List<Affect> getAffects() { return affects; }
    public void setAffects(List<Affect> affects) { this.affects = affects; }

    public int getAbility_id() { return ability_id; }
    public void setAbility_id(int ability_id) { this.ability_id = ability_id; }

    public String getIcon_name() { return icon_name; }
    public void setIcon_name(String icon_name) { this.icon_name = icon_name; }
}

