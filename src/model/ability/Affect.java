package model.ability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Affect {
    private int no;
    private int affect_type;
    private Integer affect2_type;
    private int cond_type;
    private Integer cond_param;
    private Integer cond_prob;
    private String detail;
    private Double affect_param1;
    private Double affect2_param1;

    public Map<AffectType, List<Affect>> classifyAffectByAffectType(List<Ability> list) throws IOException {
        Map<AffectType, List<Affect>> map = new HashMap<>();
        for (Ability a : list){
            //get list of effects from ability
            for (Affect effect : a.getAffects()){

                int affectTypeId = effect.getAffect_type();
                AffectType type = AffectType.getAffectTypeById(affectTypeId);
                List<Affect> group = map.getOrDefault(
                        type,
                        new LinkedList<Affect>());
                group.add(effect);    //add affect to group
                map.put(type, group); //add to result map
            }
        }
        return map;
    }

    public static List<String> listAffectToListDetail(List<Affect> list){
        List<String> listDetail = new LinkedList<>();
        for (Affect a : list){
            listDetail.add(a.getDetail());
        }
        return listDetail;
    }

    // Getters and setters
    public int getNo() { return no; }
    public void setNo(int no) { this.no = no; }

    public int getAffect_type() { return affect_type; }
    public void setAffect_type(int affect_type) { this.affect_type = affect_type; }

    public Integer getAffect2_type() { return affect2_type; }
    public void setAffect2_type(Integer affect2_type) { this.affect2_type = affect2_type; }

    public int getCond_type() { return cond_type; }
    public void setCond_type(int cond_type) { this.cond_type = cond_type; }

    public Integer getCond_param() { return cond_param; }
    public void setCond_param(Integer cond_param) { this.cond_param = cond_param; }

    public Integer getCond_prob() { return cond_prob; }
    public void setCond_prob(Integer cond_prob) { this.cond_prob = cond_prob; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public Double getAffect_param1() { return affect_param1; }
    public void setAffect_param1(Double affect_param1) { this.affect_param1 = affect_param1; }

    public Double getAffect2_param1() { return affect2_param1; }
    public void setAffect2_param1(Double affect2_param1) { this.affect2_param1 = affect2_param1; }
}

