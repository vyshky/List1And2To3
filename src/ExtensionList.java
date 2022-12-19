import java.util.List;

public class ExtensionList {
    int minValueIndex;
    List<Integer> list;

    public ExtensionList(List<Integer> list) {
        this.list = list;
        minValueIndex = 0;
    }

    public Integer getMinElemnt() {
        if (list.size() == 0) {
            return null;
        }
        int min = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            if (min > list.get(i)) {
                min = list.get(i);
                minValueIndex = i;
            }
        }
        return min;
    }

    public void removeMin() {
        list.remove(minValueIndex);
    }
}

