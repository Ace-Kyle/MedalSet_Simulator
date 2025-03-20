package test;

public class Testing {
    public static void main(String[] args) {
        String name = "Attacker(s)";
        String name2 = "Attacker";
        String nameUP = name2.toUpperCase();
        String remove = name.replaceAll("\\(.*\\)", "");
        System.out.println(name.contains(nameUP.toLowerCase()));
    }
}
