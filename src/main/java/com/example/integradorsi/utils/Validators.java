package com.example.integradorsi.utils;

import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.EmailValidator;

public class Validators {
    
    
    public boolean emails(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
    
    public boolean tarjeta(String numeros, long tipo) {
        //CreditCardValidator.VISA
        CreditCardValidator validator = new CreditCardValidator(tipo);
        return validator.isValid(numeros);
    }
}
