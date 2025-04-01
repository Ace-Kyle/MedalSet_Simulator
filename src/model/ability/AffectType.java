package model.ability;

import java.util.HashMap;
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
    public static Type getAffectType(int typeId) {
        return affectType.getOrDefault(typeId, Type.UNDEFINED);
    }

    public static boolean isInPredefinedType(int typeId){
        return affectType.containsKey(typeId) &&
                affectType.get(typeId) != Type.UNDEFINED;
    }
}
