package model.medal;

import model.ability.AffectType;
import model.service.GameService;

import java.io.IOException;
import java.util.*;

public class MedalSet {
    Medal[] medalSet = new Medal[3];
    Map<MedalTag, Integer> tagCoAffect;
    List<MedalTag> tagList;
    List<String> extraAffects;
    List<String> skill1;
    List<String> skill2;
    List<String> dodge;
    List<String> captureSpeed;
    List<String> increaseDamage;
    List<String> decreaseDamage;

    public MedalSet(int medal1, int medal2, int medal3) throws IOException {
        GameService gs = GameService.getInstance();
        medalSet[0] = gs.getMedalById(medal1);
        medalSet[1] = gs.getMedalById(medal2);
        medalSet[2] = gs.getMedalById(medal3);
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

    public void addOrReplace(Medal medal, int position){
        if (isValidPosition(position)) medalSet[position] = medal;
    }
    public void remove(int position){
        if (isValidPosition(position)) this.medalSet[position] = null;
    }
    public void removeAll(){
        for (int i=0; i < this.medalSet.length){
            this.medalSet[i] = null;
        }
    }
    Map<MedalTag, Integer> getCombineTags(){
        Map<MedalTag, Integer> map = new HashMap<>();
        for (int i=0; i < this.medalSet.length; i++){
            List<MedalTag> tagsOfThisMedal = this.medalSet[i].getTagList();
            for (MedalTag tag : tagsOfThisMedal){
                map.put(tag,
                        map.getOrDefault(tag, 0) +1)
            }
        }
        return map;
    }
    private boolean isValidPosition(int position){
        return position >= 0 && position < medalSet.length;
    }
    //getter and setter

}
