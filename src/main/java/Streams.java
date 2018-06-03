import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Oskar", "kominika", "kacper", "Tosia", "gosia");

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Oskar", "Polak", 30));
        personList.add(new Person("Damian", "Mendyk", 21));
        personList.add(new Person("Kacper", "Bieda", 31));
        personList.add(new Person("Dorota", "Polak", 50));
        personList.add(new Person("Mirosław", "Zelent", 35));


        //Zadanie 1 Napisz program, który zgrupuje wszystkich ludzi po nazwiskach. Wypisz do konsoli, ktore nazwisko jest najpopularniejsze
                 personList.stream()
                .collect(Collectors.groupingBy(Person::getLastname))
                .entrySet()
                .stream()
                .max((s,s1) -> Integer.compare(s.getValue().size(), s1.getValue().size()))
                .ifPresent(s -> System.out.println(s.getKey()));

        //Zadanie 2. Napisz program, który wyliczy średnią wartość wieku wszystkich ludzi

                personList.stream()
                        .mapToInt(Person::getAge)
                        .average()
                        .ifPresent(System.out::println);

        //Zadanie 3. Napisz program, który znajdzie najstarszego człowieka i dopisz do jego imienia prefix "Mędrzec".

                personList.stream()
                        .sorted((s, s1) -> Integer.compare(s.getAge(), s1.getAge()) * -1)
                        .limit(1)
                        .map(s -> new Person("Mędrzec " + s.getName(), s.getLastname(), s.getAge()))
                        .findAny()
                        .ifPresent(s -> System.out.println(s.getName()));

        //Zadanie 4. Wyobraź sobie, że tworzymy nadczłowieka. To człowiek składający się z wszystkich innych ludzi, jego imię tworzą pierwsze litery innych ludzi, jego nazwisko tworzą ostatnie litery innych ludzi, jego wiek to suma lat całej reszty ludzi (edited)

                personList.stream()
                        .reduce((s, s1) -> new Person(s.getName() + s1.getName().substring(0,1),
                                                    s.getLastname() + s1.getLastname().substring(s1.getLastname().length()-1, s1.getLastname().length()),
                                                       s.getAge() + s1.getAge()))
                        .ifPresent(System.out::println);

                        //Oskar Baska Kaska Dorota
                        //1. OskarB
                        //2. OskarBK
                        //3. OskarBKD
    }
}
