import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class Lambda {
    public static void main(String[] args) {
        IntBinaryOperator someMath = (int a, int b) -> {
            System.out.println("HEHEHH jestem rozbudowana lambda");
            return a * b;
        };


        math(5, 5, (a, b) -> a * b);
        math(5, 5, (a, b) -> a - b);
        math(5, 5, (a, b) -> a / b);
        //==
        math(5, 5, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int a, int b) {
                return a / b;
            }
        });

//        List<String> stringList = new ArrayList<>(Arrays.asList("Dorota", "Oskar", "Tomek", "Kuba", "Nikola"));
//        System.out.println(stringList.stream()
//                .filter(s -> s.contains("o"))
//                .map(s -> s.substring(0, 1))
//                .map(String::toLowerCase)
//                .mapToInt(s -> s.charAt(0))
//                .average()
//                .orElseThrow(IllegalStateException::new));

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(5);
        listInteger.add(10);
        listInteger.add(15);

        System.out.println(map(listInteger, s -> s + 6));
    }

    public static List<Integer> map(List<Integer> list, IntFunction<Integer> increment){
        List<Integer> newList = new ArrayList<>();

        for (Integer integer : list) {
            newList.add(increment.apply(integer));
        }
        return newList;
    }


    public static void math(int a, int b, IntBinaryOperator operation){
        System.out.println(operation.applyAsInt(a, b));
    }
}
