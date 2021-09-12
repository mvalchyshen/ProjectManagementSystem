package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developers_skills")
public class DeveloperSkill implements BaseEntity<Long>, Serializable {
    @Serial
    private static final long serialVersionUID = -3201192066019221335L;

    @Id
    @Column(name = "id_developer")
    private Long developerId;
    @Column(name = "id_skill")
    private Long skillId;

    @Override
    public Long getId() {
        return developerId;
    }
}
