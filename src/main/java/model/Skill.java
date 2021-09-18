package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skills")
public class Skill implements BaseEntity<Long>, Serializable {


    @Serial
    private static final long serialVersionUID = -8055968859783323177L;

    @Id
    @Column(name = "id_skill")
    private Long id;

    @Column(name = "language")
    private String language;

    @Column(name = "level", columnDefinition = "ENUM('Junior', 'Middle', 'Senior')")
    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany
    @JoinTable(
            name = "developers_skills",
            joinColumns = {@JoinColumn(name = "id_skill")},
            inverseJoinColumns = {@JoinColumn(name = "id_developer")}
    )
    private Set<Developer> developers;

}
