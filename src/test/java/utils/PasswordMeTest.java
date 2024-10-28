package utils;

import com.example.integradorsi.utils.PasswordMe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeTest {

    PasswordMe password;

    @BeforeEach
    void setup() {
        password = new PasswordMe("Hola");
    }

    @Test
    @DisplayName("Convetir la contraseña")
    public void testConvertirPassword() {
        String passC = "e633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f";
        Assertions.assertEquals(passC, password.convertir());
    }

    @Test
    @DisplayName("Validar la contraseña")
    public void testValidarPassword() {
        String passC = "e633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f";
        Assertions.assertEquals(true, password.validar(passC));
    }

    @Test
    @DisplayName("Simular el error en la contraseña")
    public void testErrorValidarPassword() {
        String passC = "e633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f1";
        Assertions.assertEquals(false, password.validar(passC));
    }
}
