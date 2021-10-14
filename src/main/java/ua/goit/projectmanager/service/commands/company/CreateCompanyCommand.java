package ua.goit.projectmanager.service.commands.company;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class CreateCompanyCommand implements Command {
    private final BaseService<Company, Long> companyService;
    private View view;
    public CreateCompanyCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.companyService = ServiceFactory.of(Company.class);
    }

    @Override
    public void process() {
        view.write("write company name");
        String name = view.read();
        Company company = Company.builder()
                .name(name)
                .build();
        Company save = companyService.save(company);
        view.write("Company saved :", save);
    }

    @Override
    public String commandName() {
        return "create_company";
    }

    @Override
    public String description() {
        return "to create a new company in DB";
    }
}
