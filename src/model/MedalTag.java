package model;

import java.util.HashMap;
import java.util.Map;

public class MedalTag {
    int id;
    String name;

    String pairAffect; //has 2 medals that has the same tag
    String trioAffect; //has 3 medals that has the same tag

    int sortId;
    int categoryId;
    int typeid;

    public String getAffectByNumberCombineTag(int number) {
        return switch (number){
            case 2 -> pairAffect;
            case 3 -> trioAffect;
            default -> "";
        };
    }

}
