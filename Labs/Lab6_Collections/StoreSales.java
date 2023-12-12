package Labs.Lab6_Collections;

import java.util.Map;
import java.util.TreeMap;

public class StoreSales {
    private Map<String, Integer> sales;

    public StoreSales() {
        sales = new TreeMap<>();
    }

    public void addSale(String product, int count) {
        if (sales.containsKey(product)) {
            int prevCount = sales.get(product);
            sales.put(product, prevCount + count);
        } else {
            sales.put(product, count);
        }
    }

    public String salesList() {
        StringBuilder list = new StringBuilder();
        for (String product: sales.keySet()) {
            list.append(product).append(", ");
        }
        if (!list.isEmpty()){
            list.deleteCharAt(list.length() - 1);
            list.deleteCharAt(list.length() - 1);
        }
        return list.toString();
    }

    public String getSalesSum() {
        double totalSales = 0;
        for (int count: sales.values()) {
            totalSales += count;
        }
        return String.valueOf(totalSales);
    }

    public String getPopularProduct() {
        int maxCount = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry: sales.entrySet()) {
            if (entry.getValue() > maxCount) {
                res = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return res;
    }
}
