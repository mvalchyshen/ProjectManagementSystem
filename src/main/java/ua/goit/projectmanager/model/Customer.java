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
@Table(name = "customers")
public class Customer implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -5982329006424441494L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_customer")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "projects_customers",
            joinColumns = {@JoinColumn(name = "id_customer")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")}
    )
    Set<Project> projects;
}
