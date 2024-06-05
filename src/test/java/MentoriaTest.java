import me.dio.desafio.poo.java.dominio.Mentoria;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MentoriaTest {

    @Test
    void testCalcularXp() {
        Mentoria mentoria = new Mentoria("Mentoria Java", "Descrição Mentoria Java", LocalDate.now());
        double expectedXp = 30; // XP_PADRAO (10) + 20
        assertEquals(expectedXp, mentoria.calcularXp());
    }
}
