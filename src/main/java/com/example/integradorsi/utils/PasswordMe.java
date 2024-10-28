package com.example.integradorsi.utils;

import com.google.common.hash.Hashing;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PasswordMe {

    private String password;
    private Charset charset;

    public PasswordMe(String password) {
        this.password = password;
        this.charset = StandardCharsets.UTF_8;
    }
    
    public String convertir() {
        return Hashing.sha256().hashString(password, charset).toString();
    }
    
    public boolean validar(String hash) {
        return convertir().equals(hash);
    }
    
}
