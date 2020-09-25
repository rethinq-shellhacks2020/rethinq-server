package rethinq.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import rethinq.models.enums.PaymentPlatform;

import javax.persistence.*;

@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentPlatform paymentPlatform;

    private String platformId;

    @JsonIgnore
    @ManyToOne
    private Student student;

    public PaymentMethod() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentPlatform getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(PaymentPlatform paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
