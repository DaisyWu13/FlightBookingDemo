package flight.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Daisy Wu
 */
public class TakeOff {

    public static final int WEEKDAYS = 1;
    public static final int WEEKENDS = 0;
    private Date time;
    private String from;
    private String to;
    //weekdays - 1; weekends - 0
    private int weekType;
    private Flight flight;

    public TakeOff(Date day, String from, String to) {
        this.time = day;
        this.from = from;
        this.to = to;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getWeekType() {
        return weekType;
    }

    public void setWeekType(int weekType) {
        this.weekType = weekType;
    }

    public void setWeekType() {
        if (null == time) {
            weekType = -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= day && day <= Calendar.FRIDAY) {
            weekType = WEEKDAYS;
        }
        weekType = WEEKENDS;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}
