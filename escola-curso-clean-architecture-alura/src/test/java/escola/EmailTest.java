package escola;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailComEnderecosInvalidos(){
        assertThrows(IllegalAccessException.class,()-> new Email(""));
    }
}