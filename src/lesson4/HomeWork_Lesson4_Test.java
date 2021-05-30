package lesson4;

public class HomeWork_Lesson4_Test {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        for (int value = 0; value < 10; value++) {
            linkedList.insertFirst(value);
        }

        System.out.println("----------- for each test ----------------------");
        for (int value : linkedList) {
            System.out.println(value);
        }

        System.out.println("----------- TwoSideLinkedList test ----------------------");
        TwoSideLinkedList<Integer> list = new TwoSideLinkedListImpl<>();

        doAndDisplay("insertFirst '0'", () -> list.insertFirst(0), list);
        doAndDisplay("insertLast '1'", () -> list.insertLast(1), list);
        doAndDisplay("insertLast '2'", () -> list.insertLast(2), list);
        doAndDisplay("insertFirst '3'", () -> list.insertFirst(3), list);

        System.out.println("contains '0' = " + list.contains(0));
        System.out.println("contains '5' = " + list.contains(5));

        doAndDisplay("remove '1' =", () -> list.remove(1), list);

        doAndDisplay("remove '3' =", () -> list.remove(3), list);
        doAndDisplay("remove '2' =", () -> list.remove(2), list);
    }

    private static void doAndDisplay(String comment, Runnable runnable, TwoSideLinkedList<?> list) {
        runnable.run();
        System.out.println(comment + " " + list);
    }
}
