package lab5.demchuk.client.clientjavafx.model.Factory;

import com.google.gson.Gson;

public class ObjectWrapper {
    public static String getGson (TypeCommand object) {
        String str;
        Gson gson = new Gson();
        str = gson.toJson(object);
        return  str;
    }
}
