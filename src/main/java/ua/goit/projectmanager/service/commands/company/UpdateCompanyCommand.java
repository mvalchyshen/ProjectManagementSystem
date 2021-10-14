package ua.goit.projectmanager.service.commands.company;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class UpdateCompanyCommand implements Command {
    private final BaseService<Company, Long> companyService;
    private View view;
    public UpdateCompanyCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.companyService = ServiceFactory.of(Company.class);
    }

    @Override
    public void process() {
        view.write("write id which company you want to update",companyService.getAll());
        Long id = Long.parseLong(view.read());
        view.write("type a new name");
        Company company = companyService.getById(id).get();
        company.setName(view.read());
        companyService.save(company);
        view.write("company updated",
                "Old company", company,
                "New Company",companyService.getById(id).get());
    }

    @Override
    public String commandName() {
        return "update_company";
    }

    @Override
    public String description() {
        return "update company by Id in DB";
    }
}
