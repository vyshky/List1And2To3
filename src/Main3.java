import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> list1 = new ArrayList<>() {
        };
        list1.add(1);
        list1.add(5);
        list1.add(10);
        list1.add(12);
        list1.add(15);
        list1.add(20);
        list1.add(21);
        list1.add(22);

        List<Integer> list2 = new ArrayList<>() {
        };
        list2.add(-5);
        list2.add(-1);
        list2.add(9);
        list2.add(15);
        list2.add(100);

        List<Integer> list3 = concat(list1, list2);
        System.out.println(list3);

    }

    public static List concat(List<Integer> list1, List<Integer> list2) {
        int size = list1.size() + list2.size();
        if (size == 0) return new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();

        ExtensionList eList1 = new ExtensionList(list1);
        ExtensionList eList2 = new ExtensionList(list2);

        for (int i = 0; i < size; ++i) {
            Integer value1 = eList1.getMinElemnt();
            Integer value2 = eList2.getMinElemnt();

            if (value1 != null && value2 != null) {
                if (value1 < value2) {
                    list3.add(value1);
                    eList1.removeMin();
                } else {
                    list3.add(value2);
                    eList2.removeMin();
                }
            } else if (value1 != null && value2 == null) {
                list3.add(value1);
                eList1.removeMin();
            } else if (value1 == null && value2 != null) {
                list3.add(value2);
                eList2.removeMin();
            }
        }
        return list3;
    }
}