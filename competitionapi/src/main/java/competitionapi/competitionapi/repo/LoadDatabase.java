package competitionapi.competitionapi.repo;

import competitionapi.competitionapi.jpa.Challenge;
import competitionapi.competitionapi.jpa.InputOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ChallengeRepository repository) {
        InputOutput inputOutput1 = InputOutput.builder()
                .input("5").output("15")
                .build();
        InputOutput inputOutput2 = InputOutput.builder()
                .input("3").output("3")
                .build();
        InputOutput inputOutput3 = InputOutput.builder()
                .input("4").output("6")
                .build();
        Set<InputOutput> exampleTestCases = new HashSet<>();
        exampleTestCases.add(inputOutput1);
        exampleTestCases.add(inputOutput2);
        exampleTestCases.add(inputOutput3);
        Challenge challenge = new Challenge("For a positive integer n calculate the value of the sum of all positive integers that are not greater than n i.e. 1 + 2 + 3 + ... + n. For instance, when n = 5 the correct answer is 15.");
        challenge.setInputOutputs(exampleTestCases);


        return args -> {
            log.info("Preloading " + repository.save(challenge));
        };
    }
}