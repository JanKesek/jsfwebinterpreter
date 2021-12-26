package competitionapi.competitionapi.controller;

import competitionapi.competitionapi.jpa.Challenge;
import competitionapi.competitionapi.repo.ChallengeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {
    private ChallengeRepository challengeRepository;

    public ChallengeController(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @GetMapping("/challenges")
    List<Challenge> all() {
        return challengeRepository.findAll();
    }

}
