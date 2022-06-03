package lab5.demchuk.client.clientjavafx.model.Factory;

public class CreateLogin implements FactoryChat{
    @Override
    public ActionInChat createAction() {
        return new Login();
    }
}