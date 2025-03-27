package export;

import java.util.ArrayList;
import java.util.List;

public class MedalSet {
    Medal medal1;
    Medal medal2;
    Medal medal3;


    public List<Medal> getListOfMedals(){
        List<Medal> list = new ArrayList<Medal>();
        list.add(medal1);
        list.add(medal2);
        list.add(medal3);
        return list;
    }
    //update info when changing medal list (add, remove, replace)
    private void updateMedalSetInfo(){}
}
