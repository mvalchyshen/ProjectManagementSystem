package ua.goit.projectmanager.model;

import com.sun.source.doctree.SeeTree;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"companies","customers","developers"})
@Entity
@Table(name = "projects")
public class Project implements BaseEntity<Long>, Serializable {


    @Serial
    private static final long serialVersionUID = 2373092481741317883L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_project")
    private String name;

    @Column(name = "cost")
    private int cost;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "companies_projects",
            joinColumns = {@JoinColumn(name = "id_project")},
            inverseJoinColumns = {@JoinColumn(name = "id_company")}
    )
    private Set<Company> companies;
    @ManyToMany(mappedBy = "projects")
    private Set<Customer> customers;
    @ManyToMany(mappedBy = "projects")
    private Set<Developer> developers;

}
