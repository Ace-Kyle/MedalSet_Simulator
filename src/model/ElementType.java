package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringTokenizer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementType {
    enum ELEMENT_TYPE {
        RED,
        BLUE,
        GREEN,
        DARK,
        LIGHT,
    }
    @JsonProperty("class_id")
    private int id;
    private String name;

    ElementType(){}

    public int getId() { return id; }

    public String getName() {
        StringTokenizer tokens = new StringTokenizer(name, " ");
        return tokens.nextToken();
    }

}
