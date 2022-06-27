package Demchuck.lab5.ru;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

public class MessagePerformance implements FactoryPerformance{
    @Override
    public void runOnWindow(ControllerClient controllerClient, JavaObject javaObject) {
        controllerClient.setMessageOnView(javaObject.getMessage(), javaObject.getUserName(), javaObject.getTime());
    }
}
