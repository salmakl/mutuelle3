package com.example.brief3.interfaces;

import java.io.IOException;

public interface LoginInterface {
    public void checkLogin() throws IOException;
    public boolean decryption(String password,String email) ;
}
