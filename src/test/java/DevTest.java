import me.dio.desafio.poo.java.dominio.Bootcamp;
import me.dio.desafio.poo.java.dominio.Curso;
import me.dio.desafio.poo.java.dominio.Dev;
import me.dio.desafio.poo.java.dominio.Mentoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DevTest {

    private Dev dev;
    private Bootcamp bootcamp;
    private Curso curso;
    private Mentoria mentoria;

    @BeforeEach
    void setUp() {
        dev = new Dev("Camila");
        bootcamp = new Bootcamp("Bootcamp Java", "Descrição Bootcamp Java");

        curso = new Curso("Curso Java", "Descrição Curso Java", 8);
        mentoria = new Mentoria("Mentoria Java", "Descrição Mentoria Java", LocalDate.now());

        bootcamp.adicionarConteudo(curso);
        bootcamp.adicionarConteudo(mentoria);

        dev.inscreverBootcamp(bootcamp);
    }

    @Test
    void testInscreverBootcamp() {
        assertEquals(2, dev.getConteudosInscritos().size());
        assertTrue(dev.getConteudosInscritos().contains(curso));
        assertTrue(dev.getConteudosInscritos().contains(mentoria));
    }

    @Test
    void testProgredir() {
        dev.progredir();
        assertEquals(1, dev.getConteudosInscritos().size());
        assertEquals(1, dev.getConteudosConcluidos().size());
        assertTrue(dev.getConteudosConcluidos().contains(curso));
    }

    @Test
    void testCalcularTotalXp() {
        dev.progredir();
        dev.progredir();
        double expectedXp = curso.calcularXp() + mentoria.calcularXp();
        assertEquals(expectedXp, dev.calcularTotalXp());
    }
}
