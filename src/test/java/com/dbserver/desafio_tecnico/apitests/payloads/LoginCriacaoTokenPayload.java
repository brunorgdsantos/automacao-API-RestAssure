package com.dbserver.desafio_tecnico.apitests.payloads;

import com.dbserver.desafio_tecnico.apitests.payloads.model.LoginModel;
import com.google.gson.Gson;

public class LoginCriacaoTokenPayload {
    public static String convertToJson(String username, String password){
        return new Gson().toJson(new LoginModel(username, password));
    }
}
