package ua.goit.projectmanager.model;

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
@Table(name = "developers")
public class Developer implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = 1759221531278054728L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_developer")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(mappedBy = "developers")
    private Set<Skill> skills;
    @ManyToMany
    @JoinTable(
            name = "projects_developers",
            joinColumns = {@JoinColumn(name = "id_developer")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")}
    )
    private Set<Project> projects;
}
