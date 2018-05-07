package flight.model;

import java.util.Calendar;

/**
 *
 * @author Daisy Wu
 */
public class Flight implements Comparable<Flight> {

    private String flightCode;
    private String sched;
    private String from;
    private String to;
    private double price;
    private long score;

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getSched() {
        return sched;
    }

    public void setSched(String sched) {
        this.sched = sched;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public int compareTo(Flight o) {
        if (o.getPrice() > this.getPrice()) {
            return 1;
        } else if (o.getPrice() == this.getPrice()) {
            if (o.getSched().equals(this.getSched())) {
                return 0;
            } else {
                Calendar calendar1 = Calendar.getInstance();
                String[] s = o.getSched().split(":");
                calendar1.set(Calendar.HOUR, Integer.parseInt(s[0]));
                calendar1.set(Calendar.MINUTE, Integer.parseInt(s[1]));
                Calendar calendar2 = Calendar.getInstance();
                s = this.getSched().split(":");
                calendar2.set(Calendar.HOUR, Integer.parseInt(s[0]));
                calendar2.set(Calendar.MINUTE, Integer.parseInt(s[1]));
                return calendar2.compareTo(calendar1);
            }
        } else {
            return -1;
        }
    }

}
