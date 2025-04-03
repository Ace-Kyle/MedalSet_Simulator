package model.medal;

import model.ability.Ability;
import model.ability.AffectType;
import model.service.GameService;

import java.io.IOException;
import java.util.*;

public class MedalSet {
    Medal[] medalSet = new Medal[3];
    Map<MedalTag, Integer> tagCoAffect;

    public MedalSet(int medal1, int medal2, int medal3) throws IOException {
        GameService gs = GameService.getInstance();
        medalSet[0] = gs.getMedalById(medal1);
        medalSet[1] = gs.getMedalById(medal2);
        medalSet[2] = gs.getMedalById(medal3);
    }


    public void addOrReplace(Medal medal, int position){
        if (isValidPosition(position)) medalSet[position] = medal;
    }
    public void remove(int position){
        if (isValidPosition(position)) this.medalSet[position] = null;
    }
    public void removeAll(){
        for (int i=0; i < this.medalSet.length; i++){
            this.medalSet[i] = null;
        }
    }
    public Map<MedalTag, Integer> getCombineTags() throws IOException {

        Map<MedalTag, Integer> map = new HashMap<>();
        for (int i=0; i < this.medalSet.length; i++){
            List<MedalTag> tagsOfThisMedal = this.medalSet[i].getTagList();
            for (MedalTag tag : tagsOfThisMedal){
                //count tag and their co-effect tags
                map.put(tag,
                        map.getOrDefault(tag, 0) +1);
            }
        }
        return map;
    }
    //Ability
    public List<Ability> getAbilityFromTag() throws IOException {
        List<Ability> list = new LinkedList<>();
        Map<MedalTag, Integer> combineTags = getCombineTags();

        for (MedalTag tag : combineTags.keySet()){

            Ability a = switch(combineTags.get(tag)){
                case 2 -> tag.getPairAffect();
                case 3 -> tag.getTrioAffect();
                default -> throw new IllegalStateException("Unexpected value: " + combineTags.get(tag));
            };
            list.add(a);
        }
        return list;
    }

    public List<Ability> getAbilityFromUniqueTrait() throws IOException {
        List<Ability> list = new LinkedList<>();
        for (Medal medal : medalSet){
            list.add(medal.getUniqueTrait());
        }
        return list;
    }

    public List<Ability> getAllAbilityFromThisSet() throws IOException {
        List<Ability> list = new LinkedList<>();
        list.addAll(getAbilityFromTag());
        list.addAll(getAbilityFromUniqueTrait());
        return list;
    }
    private boolean isValidPosition(int position){
        return position >= 0 && position < medalSet.length;
    }
    //getter and setter

}
