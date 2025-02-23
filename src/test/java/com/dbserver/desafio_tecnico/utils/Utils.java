package com.dbserver.desafio_tecnico.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Utils {

    private final String TEST_URL = "/test";
    private final String USER_URL = "/users";
    private final String AUTH_URL = "/auth/login";
    private final String AUTH_PROD_URL = "/auth/products";
    private final String PROD_URL = "/products/add";
    private final String BUSCA_PROD_URL = "/products";
    private final String BUSCA_PROD_ID_URL = "/products/1";

    public static String baseUrl(){
        return "https://dummyjson.com";
    }
}
