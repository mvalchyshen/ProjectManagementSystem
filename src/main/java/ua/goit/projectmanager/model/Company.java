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
@Table(name = "companies")
public class Company implements BaseEntity<Long>, Serializable {


    @Serial
    private static final long serialVersionUID = -9129321342784714942L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_company")
    private String name;

    @ManyToMany(mappedBy = "companies")
    Set<Project> projects;

}
