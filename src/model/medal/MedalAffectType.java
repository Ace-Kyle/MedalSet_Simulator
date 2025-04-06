package model.medal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import model.service.GameService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class MedalAffectType {
    private int id;
    private String name;
    private int[] type_ids;

    MedalAffectType() {}

    public static MedalAffectType getInstanceById(int id) throws IOException {
        return GameService.getInstance().getMedalAffectTypeById(id);
    }

    //all these boolean methods have parameter "id"
    //That parameter is "affect_type" in Ability (in raw data)
    public boolean isSkill1(int id) throws IOException {
        return GameService.getInstance()
                .isMedalAffectTypeNameHasId(MedalAffectTypeEnum.SKILL_1.label, id);
    }
    public boolean isSkill2(int id) throws IOException {
        return GameService.getInstance()
                .isMedalAffectTypeNameHasId(MedalAffectTypeEnum.SKILL_2.label, id);
    }
    public boolean isCaptureSpeed(int id) throws IOException {
        return GameService.getInstance().
                isMedalAffectTypeNameHasId(MedalAffectTypeEnum.CAPTURE_SPEED.label, id);
    };
    public boolean isDodge(int id) throws IOException {
        return GameService.getInstance().
                isMedalAffectTypeNameHasId(MedalAffectTypeEnum.DODGE.label, id);
    };
    public boolean isIncreaseDamage() throws IOException {
        return GameService.getInstance()
                .isMedalAffectTypeNameHasId(MedalAffectTypeEnum.INCREASE_DAMAGE.label, id);
    }
    public boolean isDecreaseDamage() throws IOException {
        return GameService.getInstance()
                .isMedalAffectTypeNameHasId(MedalAffectTypeEnum.DECREASE_DAMAGE.label, id);
    }

    //custom getter and setter



    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getType_ids() {
        return type_ids;
    }

    public void setType_ids(int[] type_ids) {
        this.type_ids = type_ids;
    }
}
