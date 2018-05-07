package flight.control;

import flight.model.Flight;
import flight.model.Passenger;
import flight.model.TakeOff;
import java.io.IOException;

/**
 *
 * @author Daisy Wu
 */
public interface IFlightControl {

    void initData() throws IOException;

    Flight book(Passenger pssenger, TakeOff takeOff);
}
