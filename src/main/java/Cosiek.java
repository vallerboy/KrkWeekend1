@FunctionalInterface
public interface Cosiek {
    int cos = 5;
    void cos1();

    default void cos2() {
        System.out.println("HelloWorld");
    }
}
