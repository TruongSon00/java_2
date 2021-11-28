package buoi_2.bai_tap;

import java.util.Comparator;
import java.util.Map;

public class sortValue implements Comparator<Character> {
    private Map<Character, Integer> list;

    public sortValue(Map<Character, Integer> list) {
        this.list = list;
    }

    public Map<Character, Integer> getList() {
        return list;
    }

    public void setList(Map<Character, Integer> list) {
        this.list = list;
    }

    @Override
    public int compare(Character key1, Character key2) {
        int check = list.get(key1).compareTo(list.get(key2));
        return check;
    }

}
