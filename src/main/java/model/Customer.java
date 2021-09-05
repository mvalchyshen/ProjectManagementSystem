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
@Table(name = "customers")
public class Customer implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -5982329006424441494L;

    @Id
    @Column(name = "id_customer")

    private Long id;

    @Column(name = "name_customer")
    private String name;
}
