package competitionapi.competitionapi.repo;

import competitionapi.competitionapi.jpa.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
