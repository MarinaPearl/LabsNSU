package lab5.demchuk.client.clientjavafx.model.Factory;

import com.google.gson.Gson;

public class Login implements ActionInChat{
    @Override
    public String doAction(Object object) {
        Gson gson = new Gson();
        String str = gson.toJson(object);
        return str;
    }
}