package buoi_3;

import java.util.Comparator;
import java.util.Map;

public class sapxepValue implements Comparator<String> {
    Map<String, Integer> dsMap;

    public sapxepValue(Map<String, Integer> dsMap) {
        this.dsMap = dsMap;
    }

    public sapxepValue() {
    }

    public Map<String, Integer> getDsMap() {
        return dsMap;
    }

    public void setDsMap(Map<String, Integer> dsMap) {
        this.dsMap = dsMap;
    }

    @Override
    public int compare(String key1, String key2) {

        int check = dsMap.get(key2).compareTo(dsMap.get(key1));
        if (check == 0)
            return -1;
        return check;
    }
}
