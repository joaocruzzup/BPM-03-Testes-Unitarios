import org.example.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    public void config(){
        pessoa = new Pessoa(1, "Joao");
    }
    @Test
    @DisplayName("Teste do Metodo getId() da Classe Pessoa")
    public void getIdTest(){
        assertEquals(1, pessoa.getId());
    }

    @Test
    @DisplayName("Teste do Metodo setID() da Classe Pessoa")
    public void setIdTest(){
        pessoa.setId(2);
        assertEquals(2, pessoa.getId());
    }

    @Test
    @DisplayName("Teste do Metodo getNome() da Classe Pessoa")
    public void getNomeTest(){
        assertEquals("Joao", pessoa.getNome());
    }

    @Test
    @DisplayName("Teste do Metodo setNome() da Classe Pessoa")
    public void setNomeTest(){
        pessoa.setNome("Victor");
        assertEquals("Victor", pessoa.getNome());
    }

    @Test
    @DisplayName("Teste do Construtor Vazio da Classe Pessoa")
    public void construtorVazioTest(){
        Pessoa outraPessoa = new Pessoa();
        assertEquals(0, outraPessoa.getId());
        assertEquals(null, outraPessoa.getNome());
    }

    @Test
    @DisplayName("Teste do Construtor Completo da Classe Pessoa")
    public void construtorCompletoTest(){
        Pessoa outraPessoa = new Pessoa(2, "Joaozinho");
        assertEquals(2, outraPessoa.getId());
        assertEquals("Joaozinho", outraPessoa.getNome());
    }

    @Test
    @DisplayName("Teste do retorno Valido Metodo valido() da Classe Pessoa")
    public void validoTest(){
        assertTrue(pessoa.valido());
    }

    @Test
    @DisplayName("Teste do Id Invalido no Metodo valido() da Classe Pessoa")
    public void invalidoIdTest(){
        Pessoa pessoaInvalida = new Pessoa(-1, "Joao");
        assertFalse(pessoaInvalida.valido());
    }

    @Test
    @DisplayName("Teste do Nome Invalido no Metodo valido() da Classe Pessoa")
    public void invalidoNomeTest(){
        Pessoa pessoaInvalida = new Pessoa(1, "");
        assertFalse(pessoaInvalida.valido());
    }

}
