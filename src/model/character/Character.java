package model.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import helper.Exporter;
import model.service.GameService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    @JsonProperty("chara_id")
    private int id;
    private String name;
    private String nickname;
    private String filename;

    @JsonProperty("class_id")
    private int element_id;
    @JsonProperty("role_id")
    private int class_id;

    private int person_id;
    private int sub_person_id;
    private int change_role_id1;    //class 1
    private int change_role_id2;    //class 2
    private boolean is_change_class;    //element

    @JsonSetter(nulls = Nulls.SKIP)
    private boolean is_legend;
    @JsonProperty("base_rarity")
    private int star;
    private List<Integer> tag_ids;
    private int skill1_id;
    private int skill2_id;
    private int abillity0_id;
    private int abillity1_id;
    private int abillity2_id;
    private int team_skill_id;

    private int character_info;
    @JsonProperty("chara_type")
    private int character_type;

    // Additional fields omitted for brevity, add as needed
    private String rarity;

    public Character(){}

    //helper
    private boolean isPlayableCharacter(){
        return !(
                this.name.contains("?") ||
                this.id > 400007000 ||
                this.character_info >=1);
    }
    private boolean isDoubleCharacer(){
        return  this.character_info >=1;
    }

    public ClassType getClassType() throws IOException {
        return GameService.getInstance().getClassTypeById(this.class_id);
    }
    public List<ClassType> getChangableClassTypes() throws IOException {
        List<ClassType> list = new ArrayList<ClassType>();

        GameService data = GameService.getInstance();
        ClassType classType1 = data.getClassTypeById(this.change_role_id1);
        ClassType classType2 = data.getClassTypeById(this.change_role_id2);
        if (classType1 != null) list.add(classType1);
        if (classType2 != null) list.add(classType2);

        return list;
    }

    public ElementType getElementType() throws IOException {
        return GameService.getInstance().getElementTypeById(this.element_id);
    }
    //define character type (rarity) based on their property
    public String getRarity(){
        if (this.getTeam_skill_id() > 110) return Rarity.RarityType.EX.toString();
        if (this.IsLegends()) return Rarity.RarityType.BF.toString();
        if (this.getStar() != 30) return Rarity.RarityType.STEP_UP.toString();

        return Rarity.RarityType.FREE.toString();
    }

    // Getters and setters

    public List<CharacterTag> getTagList() throws IOException {
        List<CharacterTag> list = new ArrayList<>();
        GameService data = GameService.getInstance();
        for (int id : tag_ids) {
            CharacterTag tag = data.getCharacterTagById(id);
            //if tag with id is not found, add null CharacterTag
            list.add(tag != null ? tag : new CharacterTag());
        }
        return list;
    }
    public void setRarity() {
        this.rarity = getRarity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getSub_person_id() {
        return sub_person_id;
    }

    public void setSub_person_id(int sub_person_id) {
        this.sub_person_id = sub_person_id;
    }

    public int getChange_role_id1() {
        return change_role_id1;
    }

    public void setChange_role_id1(int change_role_id1) {
        this.change_role_id1 = change_role_id1;
    }

    public int getChange_role_id2() {
        return change_role_id2;
    }

    public void setChange_role_id2(int change_role_id2) {
        this.change_role_id2 = change_role_id2;
    }

    public boolean isIs_change_class() {
        return is_change_class;
    }

    public void setIs_change_class(boolean is_change_class) {
        this.is_change_class = is_change_class;
    }
    @JsonProperty("is_legend")
    public boolean IsLegends() {
        return is_legend;
    }

    public void setIs_legend(boolean is_legend) {
        this.is_legend = is_legend;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public List<Integer> getTag_ids() {
        return tag_ids;
    }

    public void setTag_ids(List<Integer> tag_ids) {
        this.tag_ids = tag_ids;
    }

    public int getSkill1_id() {
        return skill1_id;
    }

    public void setSkill1_id(int skill1_id) {
        this.skill1_id = skill1_id;
    }

    public int getSkill2_id() {
        return skill2_id;
    }

    public void setSkill2_id(int skill2_id) {
        this.skill2_id = skill2_id;
    }

    public int getAbillity0_id() {
        return abillity0_id;
    }

    public void setAbillity0_id(int abillity0_id) {
        this.abillity0_id = abillity0_id;
    }

    public int getAbillity1_id() {
        return abillity1_id;
    }

    public void setAbillity1_id(int abillity1_id) {
        this.abillity1_id = abillity1_id;
    }

    public int getAbillity2_id() {
        return abillity2_id;
    }

    public void setAbillity2_id(int abillity2_id) {
        this.abillity2_id = abillity2_id;
    }

    public int getTeam_skill_id() {
        return team_skill_id;
    }

    public void setTeam_skill_id(int team_skill_id) {
        this.team_skill_id = team_skill_id;
    }

    public int getCharacter_info() {
        return character_info;
    }

    public void setCharacter_info(int character_info) {
        this.character_info = character_info;
    }

    public int getCharacter_type() {
        return character_type;
    }

    public void setCharacter_type(int character_type) {
        this.character_type = character_type;
    }

    public static void main(String[] args) throws IOException {
        int chara_id = 400000581;
        Character character = GameService.getInstance().getCharacterById(chara_id);
        System.out.printf("Found character:\n%s\n", Exporter.object2Json(character));
    }
}
//chara_id of "Roger" = 400000581
