package buoi_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class map {
    public static void main(String[] args) {
        Map<String, Integer> listMap = new HashMap<>();
        System.out.println(listMap.put("t001", 4));

        listMap.put("t001", 6);
        listMap.put("t002", 4);
        listMap.put("t003", 6);
        listMap.put("t004", 5);

        Set<String> keyList = listMap.keySet();
        System.out.println(keyList);
        // --------- sap xep gia tri theo entry ------------

        List<Map.Entry<String, Integer>> listMapSet = new ArrayList<>(listMap.entrySet());
        System.out.println("\ntruoc khi sap xep ---> ");

        for (Map.Entry<String, Integer> member : listMapSet) {
            System.out.println("key: " + member.getKey() + "  value: " + member.getValue());
        }
        // ------------ [main xep] --------
        Collections.sort(listMapSet, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {

                return arg1.getValue().compareTo(arg0.getValue());
            }

        });

        // ---------- [end] ------------

        System.out.println("\nSau khi sap xep ---> ");

        for (var member : listMapSet) {
            System.out.println("key: " + member.getKey() + "  value: " + member.getValue());
        }
        // ----------- sap xep gia tri theo treemap ----------

        sapxepValue dsSapXep = new sapxepValue(listMap);

        Map<String, Integer> treeMap = new TreeMap<>(dsSapXep);
        treeMap.putAll(listMap);

        System.out.println("\nsap xep theo class ---> ");

        Iterator<Map.Entry<String, Integer>> treemap = treeMap.entrySet().iterator();
        while (treemap.hasNext()) {
            System.out.println(treemap.next());
            System.out.println(treeMap.entrySet());
        }

        for (Map.Entry<String, Integer> member : treeMap.entrySet()) {
            System.out.println("key: " + member.getKey() + "  value: " + member.getValue());
        }

        // ----------- in theo lamdla -------------
        System.out.println("in theo lamdla");
        treeMap.forEach((k, v) -> System.out.println("key: " + k + " | value: " + v));

        // ------------- in theo stream -----------

        System.out.println("in theo stream");
        treeMap.entrySet().stream()
                .forEach(e -> System.out.println("key: " + e.getKey() + " | value: " + e.getValue()));

    }
}
