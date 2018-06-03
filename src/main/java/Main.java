import jdk.nashorn.internal.parser.Scanner;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SuperArray<String> stringSuperArray = new SuperArray<>(10);
        stringSuperArray.add("Heo!");
        stringSuperArray.add("Test");
        stringSuperArray.add("Cos");


        Integer cos = 5;
        sum(5,34,5,34,523,5,343, 0.5, 0.9f);
        sum(5);
        sum(5.2f);

        List<String> cos1 = new LinkedList<>();
        doSomething(cos1);

        Integer[] someIntegerArray = {1,2,3,4,5};
        List<Integer> someCollection = new ArrayList<>();
        someCollection.addAll(Arrays.asList(someIntegerArray));

        fromArrayToCollection(someIntegerArray, someCollection);

//        printList(someCollection);
        printList1(someCollection);
    }

    public static <T> Collection<T> fromArrayToCollection(T[] someArray, List<T> someList){
        someList.addAll(Arrays.asList(someArray));
        return someList;
    }

    public static void printList(List<? super Number> someList){
        for (Object o : someList) {
            System.out.println(o);
        }
    }

    public static <T extends Number> void printList1(List<T> someList){
        for (Object o : someList) {
            System.out.println(o);
        }
    }

    public static void doSomething(List<String> arg1){
        for (String s : arg1) {
            System.out.println(s);
        }
    }

    public static  <T extends Number> int sum(T ... numbers){
        int sum = 0;
        for (T number : numbers) {
            sum += number.intValue();
        }
        return sum;
    }





}
