package lab5.demchuk.server.Factory;

public class FactoryUser implements FactoryServer{

    @Override
    public AnswerToClient create() {
        return new UserAnswer();
    }
}
