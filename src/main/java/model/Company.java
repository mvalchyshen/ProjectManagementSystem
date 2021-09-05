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
@Table(name = "companies")
public class Company implements BaseEntity<Long>, Serializable {


    @Serial
    private static final long serialVersionUID = -9129321342784714942L;
    @Id
    @Column(name = "id_company")
    private Long id;
    @Column(name = "name_company")
    private String name;
}
