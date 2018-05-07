package flight.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Daisy Wu
 */
public class FlightPriceDao {

    private Map<String, Double> weekRegularPriceMap;
    private Map<String, Double> weekRewardPriceMap;
    private Map<String, Double> weekendsRegularPriceMap;
    private Map<String, Double> weekendsRewardPriceMap;

    public Map<String, Double> getWeekRegularPriceMap() {
        return weekRegularPriceMap;
    }

    public Map<String, Double> getWeekRewardPriceMap() {
        return weekRewardPriceMap;
    }

    public Map<String, Double> getWeekendsRegularPriceMap() {
        return weekendsRegularPriceMap;
    }

    public Map<String, Double> getWeekendsRewardPriceMap() {
        return weekendsRewardPriceMap;
    }

    public void initData() throws IOException {
        weekRegularPriceMap = new HashMap<>();
        weekRewardPriceMap = new HashMap<>();
        weekendsRegularPriceMap = new HashMap<>();
        weekendsRewardPriceMap = new HashMap<>();
        File file = new File("flightPrice.txt");
        if (!file.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String line = null;
        while (StringUtils.isNotBlank((line = br.readLine()))) {
            String[] s = line.split(":");
            if (s.length < 2) {
                continue;
            }
            String flightCode = s[0].trim();
            String[] prices = s[1].split(",");
            int index = 0;
            if (index < prices.length) {
                weekRegularPriceMap.put(flightCode, Double.parseDouble(prices[index++].trim()));
            }
            if (index < prices.length) {
                weekRewardPriceMap.put(flightCode, Double.parseDouble(prices[index++].trim()));
            }
            if (index < prices.length) {
                weekendsRegularPriceMap.put(flightCode, Double.parseDouble(prices[index++].trim()));
            }
            if (index < prices.length) {
                weekendsRewardPriceMap.put(flightCode, Double.parseDouble(prices[index++].trim()));
            }
        }
    }

}
