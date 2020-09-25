package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
