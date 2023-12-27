package Labs.Lab8_Annotations.DataProccessors;

import Labs.Lab8_Annotations.DataProcessor;
import Labs.Lab8_Annotations.Human;

import java.util.ArrayList;
@DataProcessor
public class TransformIntoLowerCase{
    @DataProcessor
    public String transformData(ArrayList<Human> data) {
        String result = "";
        ArrayList<String> resultArray = new ArrayList<>();
        data.stream().toList().forEach((elem) ->
        {
            resultArray.add(elem.getCountry().toLowerCase() + "," + elem.getName().toLowerCase() + "," + elem.getAge() + "," + elem.getEducation().toLowerCase());
        });
        for (String elem: resultArray){
            result += elem + '\n';
        }
        return result;
    }
}
