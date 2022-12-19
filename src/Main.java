import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
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

        for1:
        for (int i = 0; i < size; ++i) {
            Integer value1 = getMinElemnt(list1);
            Integer value2 = getMinElemnt(list2);

            if (value1 != null && value2 != null) {
                if (value1 < value2) {
                    list3.add(value1);
                    removeMinElement(list1);
                } else {
                    list3.add(value2);
                    removeMinElement(list2);
                }
            } else if (value1 != null && value2 == null) {
                list3.add(value1);
                removeMinElement(list1);
            } else if (value1 == null && value2 != null) {
                list3.add(value2);
                removeMinElement(list2);
            }
        }
        return list3;
    }

    public static void removeMinElement(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        int min = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); ++i) {
            if (min > list.get(i)) {
                min = list.get(i);
                index = i;
            }
        }
        list.remove(index);
    }

    public static Integer getMinElemnt(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        return Collections.min(list);
//        Можно использовать это
//        int min = list.get(0);
//        for (Integer item : list) {
//            if (min > item) {
//                min = item;
//            }
//        }
//        return min;
    }
}