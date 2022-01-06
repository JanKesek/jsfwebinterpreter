package competitionapi.competitionapi.jpa;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "InputOutput")
@Table(name = "input_output")
public class InputOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input", nullable = false)
    private String input;

    @Column(name = "output", nullable = false)
    private String output;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    private Challenge challenge;

}
