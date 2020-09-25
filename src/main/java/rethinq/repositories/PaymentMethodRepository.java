package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
