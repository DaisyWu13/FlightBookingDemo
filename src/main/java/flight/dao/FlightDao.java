package flight.dao;

import flight.model.Flight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Daisy Wu
 */
public class FlightDao {

    private List<Flight> flights;
    private Map<String, List<Flight>> fromMap;

    public List<Flight> getFlights() {
        return flights;
    }

    public Map<String, List<Flight>> getFromMap() {
        return fromMap;
    }

    public void initData() throws IOException {
        flights = new ArrayList<>();
        fromMap = new HashMap<>();
        File file = new File("flight.txt");
        if (!file.exists()) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        String line = null;
        while (StringUtils.isNotBlank((line = br.readLine()))) {
            String[] s = line.split(",");
            if (s.length < 4) {
                continue;
            }
            Flight flight = new Flight();
            flight.setFlightCode(s[0].trim());
            flight.setSched(s[1].trim());
            flight.setFrom(s[2].trim());
            flight.setTo(s[3].trim());
            flights.add(flight);
            if (!fromMap.containsKey(flight.getFrom())) {
                List<Flight> list = new ArrayList<>();
                list.add(flight);
                fromMap.put(flight.getFrom(), list);
            } else {
                List<Flight> list = fromMap.get(flight.getFrom());
                list.add(flight);
            }
        }
    }

}
