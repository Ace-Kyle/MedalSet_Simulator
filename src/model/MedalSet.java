package model;

import java.util.*;

public class MedalSet {
    List<Medal> medals = new LinkedList<>();
    Map<MedalTag, Integer> tags;
    List<String> extraAffects;
    List<String> skill1;
    List<String> skill2;
    List<String> dodge;
    List<String> captureSpeed;
    List<String> increaseDamage;
    List<String> decreaseDamage;

    public MedalSet(int medal1, int medal2, int medal3) {
        this.medals.add(GameService.getInstance().getMedalById(medal1));
        this.medals.add(GameService.getInstance().getMedalById(medal2));
        this.medals.add(GameService.getInstance().getMedalById(medal3));
    }
    private static boolean isUniqueTrait(int typeId){
        return !AffectType.isInPredefinedType(typeId);
    }

    /*private void setTags(){
        //<tagId, amount>
        Map<MedalTag, Integer> combine = new HashMap<>();

        for(Medal medal : medals){
            for (MedalTag tag: medal.tags){
                combine.put(tag, combine.getOrDefault(tag, 0) + 1);
            }
        }
        tags = combine;
    }*/

    private void setEffects(){
        for(Map.Entry<MedalTag, Integer> entry : tags.entrySet()){
            MedalTag tag = entry.getKey();

            //only add if combine tag has 2 or greater
            if (entry.getValue() >= 2) {
                switch (AffectType.getAffectType(tag.typeid)){
                    case SKILL_1         -> skill1.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                    case SKILL_2         -> skill2.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                    case DODGE           -> dodge.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                    case CAPTURE_SPEED   -> captureSpeed.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                    case INCREASE_DAMAGE -> increaseDamage.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                    case DECREASE_DAMAGE -> decreaseDamage.add(tag.getAffectByNumberCombineTag(entry.getValue()));

                    default              -> extraAffects.add(tag.getAffectByNumberCombineTag(entry.getValue()));
                }
            }
        }

    }
}
