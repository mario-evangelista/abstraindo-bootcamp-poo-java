import me.dio.desafio.poo.java.dominio.Bootcamp;
import me.dio.desafio.poo.java.dominio.Curso;
import me.dio.desafio.poo.java.dominio.Mentoria;
import me.dio.desafio.poo.java.dominio.Dev;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BootcampTest {

    private Bootcamp bootcamp;
    private Curso curso;
    private Mentoria mentoria;

    @BeforeEach
    void setUp() {
        bootcamp = new Bootcamp("Bootcamp Java", "Descrição Bootcamp Java");
        curso = new Curso("Curso Java", "Descrição Curso Java", 8);
        mentoria = new Mentoria("Mentoria Java", "Descrição Mentoria Java", LocalDate.now());
    }

    @Test
    void testAdicionarConteudo() {
        bootcamp.adicionarConteudo(curso);
        bootcamp.adicionarConteudo(mentoria);

        assertEquals(2, bootcamp.getConteudos().size());
        assertTrue(bootcamp.getConteudos().contains(curso));
        assertTrue(bootcamp.getConteudos().contains(mentoria));
    }

    @Test
    void testDevsInscritos() {
        Dev dev = new Dev("Camila");
        dev.inscreverBootcamp(bootcamp);

        assertEquals(1, bootcamp.getDevsInscritos().size());
        assertTrue(bootcamp.getDevsInscritos().contains(dev));
    }
}
