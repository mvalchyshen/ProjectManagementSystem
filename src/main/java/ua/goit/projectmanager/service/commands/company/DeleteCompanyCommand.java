package ua.goit.projectmanager.service.commands.company;

import ua.goit.projectmanager.model.Company;
import ua.goit.projectmanager.service.BaseService;
import ua.goit.projectmanager.service.ServiceFactory;
import ua.goit.projectmanager.service.commands.Command;
import ua.goit.projectmanager.view.View;

import java.util.Map;

public class DeleteCompanyCommand implements Command {
    private final BaseService<Company, Long> companyService;
    private View view;
    public DeleteCompanyCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.companyService = ServiceFactory.of(Company.class);
    }

    @Override
    public void process() {
        view.write("Write company Id to delete",companyService.getAll());
        Long id = Long.parseLong(view.read());
        companyService.deleteById(id);
        view.write("Company with id="+id+"was deleted",companyService.getAll());
    }

    @Override
    public String commandName() {
        return "delete_company";
    }

    @Override
    public String description() {
        return "delete company in DB";
    }
}
