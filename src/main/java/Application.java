import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.util.ScriptExecutor;

public class Application {
    public static void main(String[] args) {

        ScriptExecutor.start();
        BaseService<Company, Long> companyService = ServiceFactory.of(Company.class);
        Company company = Company.builder()
                .id(10L)
                .name("Maxwell")
                .projects(null)
                .build();
        Company save = companyService.save(company);
        System.out.println(save);

    }

}
