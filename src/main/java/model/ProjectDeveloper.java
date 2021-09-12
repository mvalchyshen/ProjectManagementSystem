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
@Table(name = "projects_developers")
public class ProjectDeveloper implements BaseEntity<Long>, Serializable {
    @Serial
    private static final long serialVersionUID = -9117267894947632837L;

    @Id
    @Column(name = "id_project")
    private Long projectId;
    @Column(name = "id_developer")
    private Long developerId;
    @Override
    public Long getId() {
        return projectId;
    }
}
