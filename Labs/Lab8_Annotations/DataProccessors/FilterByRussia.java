package Labs.Lab8_Annotations.DataProccessors;

import Labs.Lab8_Annotations.DataProcessor;
import Labs.Lab8_Annotations.Human;

import java.util.ArrayList;

@DataProcessor
public class FilterByRussia {
    @DataProcessor
    public String filterData(ArrayList<Human> data) {
        String result = "";
        ArrayList<String> map = new ArrayList<>();
        data.stream().toList().forEach((elem) -> {
            if (elem.getCountry().equalsIgnoreCase("россия")) {
                map.add(elem.getName() + ',' + elem.getAge() + ',' + elem.getEducation());
            }
        });
        for (String elem : map) {
            result += elem + '\n';
        }
        return result;
    }
}
