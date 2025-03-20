package model;

import java.util.HashMap;
import java.util.Map;

public class ExportPattern {

    static Map<String, String> ofCharacter(Character data){
        Map<String, String> export = new HashMap<>();
        export.put("name", data.getName());
        export.put("nickname", data.getNickname());
        return export;
    }
}
