package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameData {
    private List<Ability> ability;
    private List<Character> charas;
    private List<Medal> medal;
    private List<MedalTag> medal_tag;

    // Getters and setters
    public List<Ability> getAbility() { return ability; }
    public void setAbility(List<Ability> ability) { this.ability = ability; }

    public List<Character> getCharas() { return charas; }
    public void setCharas(List<Character> charas) { this.charas = charas; }

    public List<Medal> getMedal() { return medal; }
    public void setMedal(List<Medal> medal) { this.medal = medal; }

    public List<MedalTag> getMedal_tag() { return medal_tag; }
    public void setMedal_tag(List<MedalTag> medal_tag) { this.medal_tag = medal_tag; }
}
