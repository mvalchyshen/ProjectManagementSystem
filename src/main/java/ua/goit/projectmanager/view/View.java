package ua.goit.projectmanager.view;

public interface View {
    String read();
    void write(String message);
    static View of(){
        return ViewImpl.of();
    }
}
