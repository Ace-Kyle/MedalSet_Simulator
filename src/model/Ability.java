package model;

import java.util.List;

public class Ability {
    private List<Affect> affects;
    private int ability_id;
    private String icon_name;

    public Ability(int id) {

    }

    // Getters and setters
    public List<Affect> getAffects() { return affects; }
    public void setAffects(List<Affect> affects) { this.affects = affects; }

    public int getAbility_id() { return ability_id; }
    public void setAbility_id(int ability_id) { this.ability_id = ability_id; }

    public String getIcon_name() { return icon_name; }
    public void setIcon_name(String icon_name) { this.icon_name = icon_name; }
}

