package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Medal {

    @JsonProperty("medal_id")
    private int id;
    private String name;
    private String icon_name;
    private boolean is_event;

    private List<Integer> tag_ids;
    private int ability_id; //unique trait

    private int original_id; //if it is COLORED or NORMAL medal


    public Medal(){}

    //TODO check later
    public MedalType getMedalType(){
        if (is_event) return MedalType.EVENT;
        if (original_id != 0) return MedalType.COLORED;
        return MedalType.NORMAL;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Integer> getTag_ids() { return tag_ids; }
    public void setTag_ids(List<Integer> tag_ids) { this.tag_ids = tag_ids; }

    public int getAbility_id() { return ability_id; }
    public void setAbility_id(int ability_id) { this.ability_id = ability_id; }



    public String getIcon_name() { return icon_name; }
    public void setIcon_name(String icon_name) { this.icon_name = icon_name; }
}