package model;

import java.util.List;

public class Character {

    public Character(int id, String name) {
        this.id = id;
        this.name = name;
    }
    String name;
    String nickname;
    int id;
    String filename;

    List<Skill> skills;
    Trait trait;

    List<ClassType> classTypeList;
    List<ElementType> elementTypeList;
    Rarity.RarityType rarity;

    boolean isChangeClass;
    boolean isElement;
    boolean isDoubleTeam;
    boolean isLegend;
    int charactetType;
    int chartacterInfo;

    private boolean isBossCharacter(){
        return this.id > 40070000 || this.name.equals("???") || this.charactetType >= 1;
    }
    private boolean isDoubleCharacter(){
        return !this.isBossCharacter() && this.chartacterInfo >= 1;
    }
    private boolean isChangeClassAble(){
        return this.classTypeList.size() > 1;
    }

}
