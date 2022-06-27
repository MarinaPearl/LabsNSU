package Demchuck.lab5.ru;

import com.google.gson.Gson;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import java.util.ArrayList;

public class ListOfClientsPerformance implements FactoryPerformance{
    @Override
    public void runOnWindow(ControllerClient controllerClient, JavaObject javaObject) {
        // Login login = new Login();
        ArrayList<String> str = new ArrayList<String>();
        for (JavaObject object : javaObject.getStringArrayList()) {

            str.add(object.getUserName());
        }
        //ControllerClient.setList(stringArrayList);
        controllerClient.setList(str);
    }
}
