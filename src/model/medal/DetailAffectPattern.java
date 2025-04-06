package model.medal;

import model.ability.Affect;
import model.ability.AffectType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DetailAffectPattern {
    private static String separator = "\n-";

    private List<String> extraAffects    = new LinkedList<>(); //not in below category
    private List<String> skill1          = new LinkedList<>();
    private List<String> skill2          = new LinkedList<>();
    private List<String> dodge           = new LinkedList<>();
    private List<String> captureSpeed    = new LinkedList<>();
    private List<String> increaseDamage  = new LinkedList<>();
    private List<String> decreaseDamage  = new LinkedList<>();
    
    public DetailAffectPattern(){}

    public DetailAffectPattern(Map<AffectType, List<Affect>> categoriedList) {
        for (Map.Entry<AffectType, List<Affect>> entry : categoriedList.entrySet()) {
            switch (entry.getKey().getId()){
                case 1: skill1.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                case 2: skill2.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                case 3: dodge.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                case 4: captureSpeed.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                case 5: increaseDamage.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                case 6: decreaseDamage.addAll(Affect.listAffectToListDetail(entry.getValue())); break;
                default: extraAffects.addAll(Affect.listAffectToListDetail(entry.getValue()));
            }
        }
    }

    @Override
    public String toString() {
        return
                """
                Extra affect:
                -%s
                Skill 1:
                -%s
                Skill 2:
                -%s
                Dodge:
                -%s
                Capture Speed:
                -%s
                Increase Damage:
                -%s
                Decrease Damage:
                -%s
                """.formatted(
                        String.join(separator, skill1),
                        String.join(separator, skill2),
                        String.join(separator, dodge),
                        String.join(separator, captureSpeed),
                        String.join(separator, increaseDamage),
                        String.join(separator, decreaseDamage)
                );
    }

    public static void main(String[] args) {
        //for testing only
        List<String> extraAffects    = new LinkedList<>(); //not in below category
        List<String> skill1          = new LinkedList<>();
        List<String> skill2          = new LinkedList<>();
        List<String> dodge           = new LinkedList<>();
        List<String> captureSpeed    = new LinkedList<>();
        List<String> increaseDamage  = new LinkedList<>();
        List<String> decreaseDamage  = new LinkedList<>();

        String sample = "This is a sample";
        skill1.add(sample); skill1.add(sample);
        skill2.add(sample); skill2.add(sample);
        dodge.add(sample); dodge.add(sample);
        captureSpeed.add(sample); captureSpeed.add(sample);
        increaseDamage.add(sample); increaseDamage.add(sample);
        decreaseDamage.add(sample); decreaseDamage.add(sample);

        String result = """
                Extra affect:
                - %s
                Skill 1:
                - %s
                Skill 2:
                - %s
                Dodge:
                - %s
                Capture Speed:
                - %s
                Increase Damage:
                - %s
                Decrease Damage:
                - %s
                """.formatted(
                String.join(separator, extraAffects),
                String.join(separator, skill1),
                String.join(separator, skill2),
                String.join(separator, dodge),
                String.join(separator, captureSpeed),
                String.join(separator, increaseDamage),
                String.join(separator, decreaseDamage)
        );
        System.out.println(result);
    }

}
