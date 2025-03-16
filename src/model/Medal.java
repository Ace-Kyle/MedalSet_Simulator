package model;

import java.util.List;

public class Medal {

    int id;
    String name;
    boolean isEvent;
    String iconName;

    Ability uniqueTrait;
    List<MedalTag> tags;

    public Medal(int id){
        this.id = id;
    }
}
