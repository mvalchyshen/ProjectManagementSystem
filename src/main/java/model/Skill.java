package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

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

    @Column(name = "language", columnDefinition = "ENUM('Java', 'C++', 'C#', 'JS')")
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "level", columnDefinition = "ENUM('Junior', 'Middle', 'Senior')")
    @Enumerated(EnumType.STRING)
    private Level level;
}
