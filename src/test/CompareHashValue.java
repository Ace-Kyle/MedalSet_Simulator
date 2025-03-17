package test;

public class CompareHashValue {
    int param1 = 0;
    int param2 = 0;
    final int param3 = 0;
    public CompareHashValue(int param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public static void main(String[] args) {
        CompareHashValue h1 = new CompareHashValue(1, 2);
        System.out.println(h1.hashCode());

        System.out.println(h1.param3);
        h1.param1 = 58;
        System.out.println(h1.param3);
    }
}
