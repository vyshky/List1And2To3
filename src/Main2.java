import java.util.ArrayList;
import java.util.List;

public class Main2 {
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
        List<Integer> list3 = new ArrayList<Integer>();

        for1:
        for (int i = 0; i < size; ++i) {
            Integer index1 = min(list1);
            Integer index2 = min(list2);

            Integer value1 = list1.get(index1);
            Integer value2 = list2.get(index2);
            while (value1 < value2) {
                list3.add(value1);
                list1.remove((int) index1);
                index1 = min(list1);
                if (index1 == null) {
                    list3.add(value2);
                    break for1;
                }
                value1 = list1.get(index1);
                ++i;
            }
            while (value2 < value1) {
                list3.add(value2);
                list2.remove((int) index2);
                index2 = min(list2);
                if (index2 == null) {
                    list3.add(value1);
                    break for1;
                }
                value2 = list2.get(index2);
                ++i;
            }
            if (value2 == value1) {
                list3.add(value2);
                list2.remove((int) index2);
                list3.add(value1);
                list1.remove((int) index1);
            }
        }
        return list3;
    }

    public static Integer min(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        int min = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); ++i) {
            if (min > list.get(i)) {
                min = list.get(i);
                index = i;
            }
        }
        return index;
    }
}