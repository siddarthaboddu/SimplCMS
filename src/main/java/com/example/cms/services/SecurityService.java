package com.example.cms.services;

public interface SecurityService {

    String findLoggedInUsername();

    boolean autoLogin(String username, String password);

}
