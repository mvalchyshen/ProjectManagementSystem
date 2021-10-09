import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.model.Project;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.util.ScriptExecutor;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        ScriptExecutor.start();
        BaseService<Company, Long> companyService = ServiceFactory.of(Company.class);
        BaseService<Project, Long> projectService = ServiceFactory.of(Project.class);

        Project project = Project.builder()
                .id(10l)
                .cost(10000)
                .name("asdasdas")
                .build();
        Company company = Company.builder()
                .id(10L)
                .name("Maxwell")
                .build();
        projectService.save(project);
        Company save = companyService.save(company);
        System.out.println(save);

    }

}
