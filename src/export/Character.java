package export;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.character.CharacterTrait;
import model.character.ClassType;
import model.character.Skill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Character {
    @JsonProperty("chara_id")
    private int id;
    private String name;
    private String nickname;
    private String filename;

    private String className;
    private String elementName;

    private int person_id;
    private int sub_person_id;
    private List<String> changeRoles = new ArrayList<>();
    private boolean is_change_class;    //element

    private String rarity;
    private int star;
    private List<String> tagNames;
    private Skill skill1;
    private Skill skill2;
    private List<String> abillity0;
    private List<String> abillity1;
    private List<String> abillity2;
    private CharacterTrait traitList;

    public Character(model.character.Character character) throws IOException {
        this.id = character.getId();
        this.name = character.getName();
        this.nickname = character.getNickname();
        this.filename = character.getFilename();
        this.className = character.getClassType().getName();
        this.elementName = character.getElementType().getName();
        this.person_id = character.getPerson_id();
        this.sub_person_id = character.getSub_person_id();

        for (ClassType classType : character.getChangableClassTypes()){
            this.changeRoles.add(classType.getName());
        }
        this.is_change_class = character.isIs_change_class();
        this.rarity = character.getRarity();
        this.star = character.getStar();

    }
}
