package Demchuck.lab5.ru;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

public class LoginPerformance implements FactoryPerformance{
    @Override
    public void runOnWindow(ControllerClient controllerClient, JavaObject javaObject) {
        controllerClient.setName(javaObject.getUserName(), javaObject.getTime());
    }
}
