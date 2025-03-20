package model;

public class Rarity {
    enum RarityType {
        EX,
        BF,
        STEP_UP,
        FREE,
    }
    //define character type (rarity) based on their property
    public String getRarityName(Character character){
        if (character.getTeam_skill_id() > 110) return RarityType.EX.toString();
        if (character.getIsLegend()) return RarityType.BF.toString();
        if (character.getStar() != 30) return RarityType.STEP_UP.toString();

        return RarityType.FREE.toString();
    }
}
