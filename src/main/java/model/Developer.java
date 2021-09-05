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
@Table(name = "developers")
public class Developer implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = 1759221531278054728L;

    @Id
    @Column(name = "id_developer")
    private Long id;

    @Column(name = "name_developer")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;
}
