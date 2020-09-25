package rethinq.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import rethinq.models.enums.WeekDay;

import javax.persistence.*;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WeekDay weekday;
    private Boolean morning;
    private Boolean afternoon;
    private Boolean evening;
    @JsonIgnore
    @ManyToOne
    private TutorCourse tutorCourse;

    public Availability() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeekDay getWeekday() {
        return weekday;
    }

    public void setWeekday(WeekDay weekday) {
        this.weekday = weekday;
    }

    public Boolean getMorning() {
        return morning;
    }

    public void setMorning(Boolean morning) {
        this.morning = morning;
    }

    public Boolean getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Boolean afternoon) {
        this.afternoon = afternoon;
    }

    public Boolean getEvening() {
        return evening;
    }

    public void setEvening(Boolean evening) {
        this.evening = evening;
    }

    public TutorCourse getTutorCourse() {
        return tutorCourse;
    }

    public void setTutorCourse(TutorCourse tutorCourse) {
        this.tutorCourse = tutorCourse;
    }
}
