package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedalSet {
    List<Medal> medals = new ArrayList<Medal>();
    Map<MedalTag, Integer> tags;
    List<String> extraAffects;
    List<String> skill1;
    List<String> skill2;
    List<String> dodge;
    List<String> captureSpeed;
    List<String> increaseDamage;
    List<String> decreaseDamage;

    public MedalSet(int medal1, int medal2, int medal3) {
        this.medals.add(new Medal(medal1));
        this.medals.add(new Medal(medal2));
        this.medals.add(new Medal(medal3));
    }
    private static boolean isUniqueTrait(int typeId){
        return !AffectType.isInPredefinedType(typeId);
    }

    private void setTags(){
        //<tagId, amount>
        Map<MedalTag, Integer> combine = new HashMap<>();

        for(Medal medal : medals){
            for (MedalTag tag: medal.tags){
                combine.put(tag, combine.getOrDefault(tag, 0) + 1);
            }
        }
        tags = combine;
    }

    private void setEffects(){
        for(Map.Entry<MedalTag, Integer> entry : tags.entrySet()){
            MedalTag tag = entry.getKey();

            //only add if combine tag has 2 or greater
            switch (AffectType.getAffectType(tag.typeid)){
                case SKILL_1 -> {
                    if (entry.getValue() >1) skill1.add( tag.getAffectByNumberCombineTag(  entry.getValue()));
                }
                case SKILL_2 -> {
                    if
                }
            }
        }

    }
}
