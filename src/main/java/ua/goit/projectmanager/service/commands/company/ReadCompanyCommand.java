package ua.goit.projectmanager.service.commands.company;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class ReadCompanyCommand implements Command {
    private final BaseService<Company, Long> companyService;
    private View view;
    public ReadCompanyCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.companyService = ServiceFactory.of(Company.class);
    }

    @Override
    public void process() {
        view.write(companyService.getAll());
    }

    @Override
    public String commandName() {
        return "getAll_companies";
    }

    @Override
    public String description() {
        return "get all companies from DB";
    }
}
