package flight.model;

import flight.control.IFlightControl;
import java.util.List;

/**
 *
 * @author Daisy Wu
 */
public abstract class AbstractPassenger {

    private String code;
    private String name;
    private List<TakeOff> takeOffs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TakeOff> getTakeOffs() {
        return takeOffs;
    }

    public void setTakeOffs(List<TakeOff> takeOffs) {
        this.takeOffs = takeOffs;
    }

    public abstract void book(TakeOff takeOff, IFlightControl flightControl);
}
