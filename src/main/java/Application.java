import conrtroller.DataBaseConnection;
import model.BaseEntity;
import model.Company;
import repository.BaseRepository;
import repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        BaseRepository<Company, Long> company = new CompanyRepository();
//        Object o = company.getById(2L).get();
//        Company c = (Company) o;
//        System.out.println(c);

        Company c = Company.builder()
                .id(9L)
                .name("NavY")
                .build();
        Company save = company.save(c);
        Company byId = company.getById(9L).get();
        System.out.println(byId);
//        Company iodasdasd = Company.builder()
//                .id(9L)
//                .name("iodasdasd")
//                .build();
//        company.save(iodasdasd);

    }

}
