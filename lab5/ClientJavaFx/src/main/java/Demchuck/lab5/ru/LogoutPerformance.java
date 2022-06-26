package Demchuck.lab5.ru;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

public class LogoutPerformance implements FactoryPerformance{
    @Override
    public void runOnWindow(ControllerClient controllerClient, JavaObject javaObject) {
        if (javaObject.getUserName().equals(controllerClient.getClientSomthing().getNickname())) {
            controllerClient.getClientSomthing().downService();
        }
        controllerClient.deleted(javaObject.getUserName(), javaObject.getTime());
    }
}
