package buoi_2.bai_tap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class list_1 {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listInt.add((int) (Math.random() * 10) + 1);
        }
        Collections.sort(listInt);
        listInt.forEach(mem -> System.out.println(mem));
        // ------ 1--------------

        List<Integer> list1 = new ArrayList<>();
        List<Integer> count1 = new ArrayList<>();
        int count = 1;
        for (Integer mem : listInt) {
            if (list1.indexOf(mem) == -1) {
                list1.add(mem);
                count1.add(count);
                count = 1;
            } else
                count++;
        }
        count1.add(count);

        count1.remove(0);
        int length = list1.size();
        for (int i = 0; i < length; i++) {
            System.out.println("So: " + list1.get(i) + " ---> xuat hien " + count1.get(i) + " lan");
        }

        // ------- set ---------
        HashSet<Integer> listSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            listSet.add((int) (Math.random() * 20) + 1);
        }

        listSet.add(-11);
        Set<Integer> sortSet = new TreeSet<>(listInt);
        System.out.println(sortSet.toString());

        // ------- map ---------
        Map<Character, Integer> listMap = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            listMap.put((char) ((int) (Math.random() * 26) + 65), (int) (Math.random() * 20) + 1);
        }
        listMap.put('h', 1234);
        listMap.put('e', 23);
        // System.out.println(listMap.toString());

        Map<Character, Integer> sortMap = new TreeMap<>(new Comparator<Character>() {

            @Override
            public int compare(Character arg0, Character arg1) {

                return arg1.compareTo(arg0);
            }

        });
        sortMap.putAll(listMap);
        // System.out.println(sortMap.toString());

        // --------- value ----------
        sortValue lisSortValue = new sortValue(listMap);

        Map<Character, Integer> sortMap2 = new TreeMap<>(lisSortValue);
        sortMap2.putAll(listMap);
        System.out.println(sortMap2);

    }
}
