package rethinq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rethinq.models.TutorRequest;

public interface TutorRequestRepository extends JpaRepository<TutorRequest, Long> {
}
