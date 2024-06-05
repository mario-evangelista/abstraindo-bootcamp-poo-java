import me.dio.desafio.poo.java.dominio.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CursoTest {

    @Test
    void testCalcularXp() {
        Curso curso = new Curso("Curso Java", "Descrição Curso Java", 8);
        double expectedXp = 80; // XP_PADRAO (10) * cargaHoraria (8)
        assertEquals(expectedXp, curso.calcularXp());
    }
}