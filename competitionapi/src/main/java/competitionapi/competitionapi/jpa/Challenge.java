package competitionapi.competitionapi.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "Challenge")
@Table(name = "challenge")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "challenge_question", nullable = false, unique = true)
    private String challengeQuestion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "challenge", cascade = CascadeType.ALL)
    private Set<InputOutput> inputOutputs;

    public Challenge(String challengeQuestion) {
        this.challengeQuestion = challengeQuestion;
    }
}
