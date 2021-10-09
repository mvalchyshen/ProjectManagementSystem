package ua.goit.projectmanager.view;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ViewImpl implements View{

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    @Override
    public String read() {
        return br.readLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
