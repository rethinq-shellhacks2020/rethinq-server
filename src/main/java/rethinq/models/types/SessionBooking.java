package rethinq.models.types;

public class SessionBooking {
    private String date;
    private Integer time;    //army time
    private Integer hours;


    public SessionBooking(String date, Integer time, Integer hours) {
        this.date = date;
        this.time = time;
        this.hours = hours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
