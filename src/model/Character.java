package model;

import java.util.List;

public class Character {
    private int chara_id;
    private String name;
    private String name_en;
    private String nickname;
    private int person_id;
    private int base_rarity;
    private int max_rarity;
    private List<Integer> tag_ids;
    private int skill1_id;
    private int skill2_id;
    private Integer abillity0_id;
    private int abillity1_id;
    private int abillity2_id;
    // Additional fields omitted for brevity, add as needed

    // Getters and setters
    public int getChara_id() { return chara_id; }
    public void setChara_id(int chara_id) { this.chara_id = chara_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getName_en() { return name_en; }
    public void setName_en(String name_en) { this.name_en = name_en; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getPerson_id() { return person_id; }
    public void setPerson_id(int person_id) { this.person_id = person_id; }

    public int getBase_rarity() { return base_rarity; }
    public void setBase_rarity(int base_rarity) { this.base_rarity = base_rarity; }

    public int getMax_rarity() { return max_rarity; }
    public void setMax_rarity(int max_rarity) { this.max_rarity = max_rarity; }

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
}
