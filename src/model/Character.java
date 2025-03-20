package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    @JsonProperty("chara_id")
    private int id;
    private String name;
    private String name_en;
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
    private int is_change_class;    //element

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

    // Getters and setters
    public String getFilename() { return filename;}
    public int getClass_id(){ return class_id; }
    public int getElement_id(){ return element_id; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getName_en() { return name_en; }
    public void setName_en(String name_en) { this.name_en = name_en; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getPerson_id() { return person_id; }
    public void setPerson_id(int person_id) { this.person_id = person_id; }

    public int getBase_rarity() { return star; }
    public void setBase_rarity(int base_rarity) { this.star = base_rarity; }

    public List<Integer> getTag_ids() { return tag_ids; }
    public void setTag_ids(List<Integer> tag_ids) { this.tag_ids = tag_ids; }

    public int getSkill1_id() { return skill1_id; }
    public void setSkill1_id(int skill1_id) { this.skill1_id = skill1_id; }

    public int getSkill2_id() { return skill2_id; }
    public void setSkill2_id(int skill2_id) { this.skill2_id = skill2_id; }

    public Integer getAbillity0_id() { return abillity0_id; }
    public void setAbillity0_id(Integer abillity0_id) { this.abillity0_id = abillity0_id; }

    public int getAbillity1_id() { return abillity1_id; }
    public void setAbillity1_id(int abillity1_id) { this.abillity1_id = abillity1_id; }

    public int getAbillity2_id() { return abillity2_id; }
    public void setAbillity2_id(int abillity2_id) { this.abillity2_id = abillity2_id; }
    public int getTeam_skill_id() { return team_skill_id; }
    public boolean getIsLegend() { return is_legend; }
    public int getStar() { return star; }

}
//chara_id of "Roger" = 400000581
