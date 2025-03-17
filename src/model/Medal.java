package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Medal {
    private int medal_id;
    private String name;
    private List<Integer> tag_ids;
    private List<ItemCreate> item_create;
    private int ability_id;
    private int ability2_group_id;
    private int ability3_group_id;
    private int ability4_group_id;
    private String icon_name;

    public Medal(int id) {
    }
    public Medal(){}

    // Getters and setters
    public int getMedal_id() { return medal_id; }
    public void setMedal_id(int medal_id) { this.medal_id = medal_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Integer> getTag_ids() { return tag_ids; }
    public void setTag_ids(List<Integer> tag_ids) { this.tag_ids = tag_ids; }

    public List<ItemCreate> getItem_create() { return item_create; }
    public void setItem_create(List<ItemCreate> item_create) { this.item_create = item_create; }

    public int getAbility_id() { return ability_id; }
    public void setAbility_id(int ability_id) { this.ability_id = ability_id; }

    public int getAbility2_group_id() { return ability2_group_id; }
    public void setAbility2_group_id(int ability2_group_id) { this.ability2_group_id = ability2_group_id; }

    public int getAbility3_group_id() { return ability3_group_id; }
    public void setAbility3_group_id(int ability3_group_id) { this.ability3_group_id = ability3_group_id; }

    public int getAbility4_group_id() { return ability4_group_id; }
    public void setAbility4_group_id(int ability4_group_id) { this.ability4_group_id = ability4_group_id; }

    public String getIcon_name() { return icon_name; }
    public void setIcon_name(String icon_name) { this.icon_name = icon_name; }
}