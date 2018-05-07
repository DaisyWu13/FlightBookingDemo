package flight.control;

import flight.dao.FlightDao;
import flight.dao.FlightPriceDao;
import flight.model.Flight;
import flight.model.Passenger;
import flight.model.TakeOff;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author Daisy Wu
 */
public class FlightControl implements IFlightControl {

    private FlightDao flightDao;
    private FlightPriceDao flightPriceDao;

    @Override
    public void initData() throws IOException {
        flightDao.initData();
        flightPriceDao.initData();
    }

    @Override
    public Flight book(Passenger pssenger, TakeOff takeOff) {
        if (null == pssenger || null == takeOff) {
            return null;
        }
        List<Flight> flights = flightDao.getFromMap().get(takeOff.getFrom());
        if (CollectionUtils.isEmpty(flights)) {
            return null;
        }
        List<Flight> flightTemps = new ArrayList<>();
        for (Flight flight : flights) {
            flightTemps.add(flight);
        }
        takeOff.setWeekType();
        for (Flight flight : flightTemps) {
            setFlightPrice(flight, pssenger.getCustomerType(), takeOff.getWeekType());
        }
        Collections.sort(flightTemps);
        return flightTemps.get(0);
    }

    private void setFlightPrice(Flight flight, int customerType, int weekType) {
        if (customerType == Passenger.REGULAR) {
            if (weekType == TakeOff.WEEKDAYS) {
                flight.setPrice(flightPriceDao.getWeekRegularPriceMap().get(flight.getFlightCode()));
            } else {
                flight.setPrice(flightPriceDao.getWeekendsRegularPriceMap().get(flight.getFlightCode()));
            }
        } else {
            if (weekType == TakeOff.WEEKDAYS) {
                flight.setPrice(flightPriceDao.getWeekRewardPriceMap().get(flight.getFlightCode()));
            } else {
                flight.setPrice(flightPriceDao.getWeekendsRewardPriceMap().get(flight.getFlightCode()));
            }
        }
    }

}
