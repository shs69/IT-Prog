package Labs.Lab8_Annotations;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataManager {

    private ArrayList<Object> processors;
    public ArrayList<Human> data;
    private ExecutorService service;
    private String outputData = "";

    public DataManager() {
        this.processors = new ArrayList<>();
        this.data = new ArrayList<>();
        this.service = Executors.newFixedThreadPool(8);
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        try (
                FileReader reader = new FileReader(source);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elemOfString = line.split(",");
                Pattern pattern = Pattern.compile("(?=.*\\D)");
                Matcher matcher = pattern.matcher(elemOfString[2]);
                if (!matcher.find()) {
                    double age = Float.parseFloat(elemOfString[2]);
                    Human person = new Human(age, elemOfString[0], elemOfString[1], elemOfString[3]);
                    data.add(person);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processData() {
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    futures.add(service.submit(() -> {
                        try {
                            return (String) method.invoke(processor, data);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }));
                }
            }
        }
        for (Future<String> f : futures) {
            try {
                appendToOutput(f.get());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public synchronized void appendToOutput(String data) {
        outputData += data;
    }

    public void saveData(String destination) {
        File file = new File(destination);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
