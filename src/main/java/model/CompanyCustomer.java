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
@Table(name = "companies_customers")
public class CompanyCustomer implements BaseEntity<Long>, Serializable {
    @Serial
    private static final long serialVersionUID = 3948186190902241234L;
    @Id
    @Column(name = "id_company")
    private Long companyId;
    @Column(name = "id_customer")
    private Long customerId;

    @Override
    public Long getId() {
        return companyId;
    }
}
