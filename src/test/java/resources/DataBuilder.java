package resources;

import pojo.LoginTokenApi;

public class DataBuilder {

    public LoginTokenApi getLoginPayload(String ac, String dob){
        LoginTokenApi payload = new LoginTokenApi();
        payload.setAccessCode(ac);
        payload.setDob(dob);
        return payload;
    }
}
