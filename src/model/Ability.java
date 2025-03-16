package model;

public class Ability {
    int abilityId;
    String detail;
    int abilityType;

    public static String join(String[] abilityList){
        //follow by Markdown format
        return "- " + String.join("\n- ", abilityList);
    }
}

