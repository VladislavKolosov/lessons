package pair;

import java.util.Objects;

public class PairUtil {
    public static <T> boolean equals(Pair<T> first, Pair<T> second) {
        if (first == null || second == null){
            return false;
        }
        return Objects.equals(first.getFirst(), second.getFirst())
                && Objects.equals(first.getSecond(),second.getSecond());

        // return first.getFirst().equals(second.getFirst()) && first.getSecond().equals(second.getSecond());
    }

    public static <T> Pair<T> copy(Pair<T> pair){
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }
    public static <T> void swap(Pair<T> pair){
        T temp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(temp);
    }

}
