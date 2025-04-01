package model.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.GameService;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassType {
    public ClassType(int classId) {
    }

    enum CLASS_TYPE {
        ATTACKER,
        RUNNER,
        DEFENDER,
        UNKNOWN,
    }
    //in original data, its name is chara_role instead of chara_class
    //it may cause some confuse to ElementType class
    @JsonProperty("role_id")
    private int id;
    private String name;

    public String getName() {
        //example data: Attacker(s), Defender(s), Runner(s)
        if (this.name.toUpperCase().contains(CLASS_TYPE.ATTACKER.toString())) return CLASS_TYPE.ATTACKER.toString();
        if (this.name.toUpperCase().contains(CLASS_TYPE.RUNNER.toString())) return CLASS_TYPE.RUNNER.toString();
        if (this.name.toUpperCase().contains(CLASS_TYPE.DEFENDER.toString())) return CLASS_TYPE.DEFENDER.toString();

        return CLASS_TYPE.UNKNOWN.toString();
    }
    private String nameWithoutLeftover(){
        return this.name.replaceAll("\\(.*\\)", "");
    }
    //getter and setter
    public int getId() { return id; }

    public static ClassType getClassTypeById(int id) throws IOException {
        return GameService.getInstance().getClassTypeById(id);
    }
}
