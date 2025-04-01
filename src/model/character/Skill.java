package model.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Skill {
    enum ACTIVE_TYPE {
        CHARGE,
        NORMAL,
        COUNTER
    }
    enum SKILL_NUMBER {
        SKILL_1,
        SKILL_1S,
        SKILL_2,
        SKILL_2S,
        SKILL_3,
    }
    enum SKILL_RANGE {
        CLOSE,
        MIDDLE,
        LONG,
        EXTRA_LONG,
        UNKNOWN,
    }
    int id;
    String name;
    int cooldown;
    String description;
    String iconName;
    ACTIVE_TYPE activeType;
    String[] extraAffect;

    public Skill(int id) { this.id = id; }


}
