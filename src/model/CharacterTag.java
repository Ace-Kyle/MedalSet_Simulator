package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterTag {

    private int chara_tag_id;
    private String name;
    CharacterTypeAffect[] chara_type_effects;

    public CharacterTag() {
    }

    public int getId() {
        return chara_tag_id;
    }

    public void setId(int chara_tag_id) {
        this.chara_tag_id = chara_tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterTypeAffect[] getChara_type_effects() {
        return chara_type_effects;
    }

    public void setChara_type_effects(CharacterTypeAffect[] chara_type_effects) {
        this.chara_type_effects = chara_type_effects;
    }
}
