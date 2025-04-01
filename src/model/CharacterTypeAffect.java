package model;

public class CharacterTypeAffect {
    private int total_level;
    private int ability_id;

    public int getTotal_level() {
        return total_level;
    }

    public int getAbility_id() {
        return ability_id;
    }

    public CharacterTypeAffect(int totalLevel) {
        total_level = totalLevel;
    }

    private String getAffect(){
        return "";
    }
}
