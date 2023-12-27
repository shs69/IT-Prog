package Labs.Lab8_Annotations.DataProccessors;

import Labs.Lab8_Annotations.DataProcessor;
import Labs.Lab8_Annotations.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@DataProcessor
public class CountryCount {
    @DataProcessor
    public String countryCount(ArrayList<Human> data) {
        String result = "";
        HashMap<String, Integer> map = new HashMap<>();
        data.stream().toList().forEach((elem) -> {
            String country = elem.getCountry();
            if (map.containsKey(country)) {
                map.put(country, map.get(country) + 1);
            } else {
                map.put(country, 1);
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += entry.getKey() + ':' + entry.getValue() + '\n';
        }
        return result;
    }

}
