package lab5.demchuk.server.Factory;

import com.google.gson.Gson;

public class UserAnswer implements AnswerToClient{
    private String str;
    @Override
    public String doActions(Object obj) {
        Gson gson = new Gson();
        String str = gson.toJson(obj);
        return str;
    }
}
