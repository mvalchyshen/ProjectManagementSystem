import conrtroller.DataBaseConnection;
import model.Company;
import repository.BaseRepository;
import repository.CompanyRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseRepository company = new CompanyRepository();
        List all = company.getAll();
        System.out.println(all);
    }

}
