package com.dbserver.desafio_tecnico.apitests.payloads.dependecy;

public interface IUrlsUtils {
    String getTestUrl();
    String getUserUrl();
    String getAuthUrl();
    String getAuthProdUrl();
    String getProdUrl();
    String getBuscaProdUrl();
    String getBuscaProdIdUrl();
    String getUnauthorizedToken();
}
