package com.dbserver.desafio_tecnico.apitests.payloads;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.ILoginCriacaoTokenPayload;
import com.dbserver.desafio_tecnico.apitests.payloads.model.LoginModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class LoginCriacaoTokenPayload implements ILoginCriacaoTokenPayload {

    @Override
    public String convertToJson(String username, String password){
        return new Gson().toJson(new LoginModel(username, password));
    }
}
