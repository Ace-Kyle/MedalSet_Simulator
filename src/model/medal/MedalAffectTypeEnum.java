package model.medal;

public enum MedalAffectTypeEnum {

    SKILL_1("Skill 1"),
    SKILL_2("Skill 2"),
    DODGE("Dodge"),
    CAPTURE_SPEED("Capture Speed"),
    INCREASE_DAMAGE("Damage Increase"),
    DECREASE_DAMAGE("Damage Reduction"),
    HP_RECOVERY("HP Recovery"),
    UNDEFINED("Unknown");

    public final String label;

    MedalAffectTypeEnum(String label){
        this.label = label;
    }

    public static MedalAffectTypeEnum typeOf(String name){
        try {
            return MedalAffectTypeEnum.valueOf(name);
        } catch (IllegalArgumentException e) {
            return UNDEFINED;
        }
    }

}
