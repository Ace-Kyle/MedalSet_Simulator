package model.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.ability.Ability;
import model.character.*;
import model.character.Character;
import model.medal.Medal;
import model.medal.MedalAffectType;
import model.medal.MedalTag;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameData {
    //field name must be the same in JSON
    //otherwise, use @JsonProperty to mapping with new one
    private List<Ability> ability;
    private List<model.character.Character> charas;
    private List<Skill> chara_skill;
    private List<Medal> medal;
    private List<MedalTag> medal_tag;

    //add Element, Class, TeamBoost
    private List<ElementType> chara_class;
    private List<ClassType> chara_role;
    private List<CharacterTag> character_tag;
    private List<CharacterTeamSkill> chara_team_skill;
    private List<MedalAffectType> medal_affect_type;

    // Getters and setters
    public List<Ability> getAbility() { return ability; }
    public void setAbility(List<Ability> ability) { this.ability = ability; }

    public List<model.character.Character> getCharas() { return charas; }
    public void setCharas(List<Character> charas) { this.charas = charas; }

    public List<Medal> getMedal() { return medal; }
    public void setMedal(List<Medal> medal) { this.medal = medal; }

    public List<MedalTag> getMedal_tag() { return medal_tag; }
    public void setMedal_tag(List<MedalTag> medal_tag) { this.medal_tag = medal_tag; }

    //extent adding
    public List<ElementType> getElement() { return chara_class; }
    public List<ClassType> getRole() { return chara_role; }
    public List<CharacterTeamSkill> getCharacterTeamSkill() { return chara_team_skill; }
    public List<CharacterTag> getCharacterTag() { return character_tag; }
    public List<Skill> getSkill() { return chara_skill; }
    public void setSkill(List<Skill> skill) { this.chara_skill = skill; }

    public List<MedalAffectType> getMedalAffectType() {
        return medal_affect_type;
    }

    public void setMedalAffectType(List<MedalAffectType> medal_affect_type) {
        this.medal_affect_type = medal_affect_type;
    }
}
