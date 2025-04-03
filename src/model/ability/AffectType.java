package model.ability;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AffectType {
    public enum Type {
        SKILL_1,
        SKILL_2,
        DODGE,
        CAPTURE_SPEED,
        INCREASE_DAMAGE,
        DECREASE_DAMAGE,
        HP_RECOVERY,
        UNDEFINED,
    }
    private int id;
    static Map<Integer, Type> affectType = new HashMap<>();
    static {
        //generate affect types for classify later
        affectType.put(1, AffectType.Type.SKILL_1);
        affectType.put(2, AffectType.Type.SKILL_2);
        affectType.put(3, AffectType.Type.CAPTURE_SPEED);
        affectType.put(4, AffectType.Type.DODGE);
        affectType.put(5, AffectType.Type.INCREASE_DAMAGE);
        affectType.put(6, AffectType.Type.DECREASE_DAMAGE);
    }
    public int getId(){ return id;}
    public static Type getAffectType(int typeId) {
        return affectType.getOrDefault(typeId, Type.UNDEFINED);
    }

    public static boolean isInPredefinedType(int typeId){
        return affectType.containsKey(typeId) &&
                affectType.get(typeId) != Type.UNDEFINED;
    }

    public Map<Integer, List<Ability>> classifyAbilityByAffectType(List<Ability> list){
        Map<AffectType, List<Ability>> map = new HashMap<>();
        for (Ability a : list){
            //FIXME - complete it
            //map.getOrDefault()
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AffectType that = (AffectType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
