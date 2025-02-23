package com.dbserver.desafio_tecnico.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UrlsUtils {

    private final String TEST_URL = "/test";
    private final String USER_URL = "/users";
    private final String AUTH_URL = "/auth/login";
    private final String AUTH_PROD_URL = "/auth/products";
    private final String PROD_URL = "/products/add";
    private final String BUSCA_PROD_URL = "/products";
    private final String BUSCA_PROD_ID_URL = "/products/";

    private final String UNAUTHORIZED_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3NDAzMjczNzQsImV4cCI6MTc0MDMzMDk3NH0.Hb9Cb_TJLRQB_RDuZnQuuTQ_cVW2D-meDRp0ASgehpw";

    public static String baseUrl(){
        return "https://dummyjson.com";
    }
}
