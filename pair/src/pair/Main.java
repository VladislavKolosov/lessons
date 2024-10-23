package pair;

public class Main {
    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(1,3);
        Pair<Integer> pair2 = new Pair<>(2,4);

        System.out.println("Equals: " + PairUtil.equals(pair1,pair2));

        Pair<Integer> pair3 = PairUtil.copy(pair1);
        System.out.println("Copy pair - First: " + pair3.getFirst() + "| Second: " + pair3.getSecond());

        System.out.println("Before swap: " + pair3);
        PairUtil.swap(pair3);
        System.out.println("After swap: " + pair3);

        Pair<Integer> pair4 = new Pair<>(1,3);
        System.out.println("Equals: " + PairUtil.equals(pair1,pair4));


        System.out.println("__________________________________");

        Pair<String> strPair1 = new Pair<>("Banana","Apple");
        Pair<String> strPair2 = new Pair<>("Mom","Dad");

        System.out.println("Equals: " + PairUtil.equals(strPair1,strPair2));

        Pair<String> newStringPair = PairUtil.copy(strPair2);
        System.out.println("Copy pair: " + newStringPair);

        System.out.println("Before swap: " + strPair1);
        PairUtil.swap(strPair1);
        System.out.println("After swap: " + strPair1);


        System.out.println("__________________________________");

        Pair<Number> numberPair1 = new Pair<>(1.1,2.9);
        Pair<Number> numberPair2 = new Pair<>(1.1,2.9);
        System.out.println("Equals: " + PairUtil.equals(numberPair1,numberPair2));

        Pair<Number> newNumberPair = PairUtil.copy(numberPair1);
        System.out.println("Copy pair: " + newNumberPair);

        System.out.println("Before swap: " + numberPair1);
        PairUtil.swap(numberPair1);
        System.out.println("After swap: " + numberPair1);
    }
}
