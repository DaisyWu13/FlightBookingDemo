package flight.model;

import flight.control.IFlightControl;

/**
 *
 * @author Daisy Wu
 */
public class Passenger extends AbstractPassenger {

    public static final int REGULAR = 0;
    public static final int REWARD = 1;
    private int customerType;

    public Passenger(int customerType) {
        this.customerType = customerType;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    @Override
    public void book(TakeOff takeOff, IFlightControl flightControl) {
        takeOff.setFlight(flightControl.book(this, takeOff));
        this.getTakeOffs().add(takeOff);
    }

}
