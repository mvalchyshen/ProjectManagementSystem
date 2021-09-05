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
@Table(name = "projects")
public class Project implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -5378443679592549063L;

    @Id
    @Column(name = "id_project")
    private Long id;

    @Column(name = "name_project")
    private String name;

    @Column(name = "cost")
    private int cost;
}
