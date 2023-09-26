import org.example.Pessoa;
import org.example.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TurmaTest {

    private Turma turma;

    @Mock
    private Pessoa pessoaMock;

    @Mock
    private Pessoa outraPessoaMock;

    @BeforeEach
    public void config(){
        turma = new Turma();
    }

    @Test
    @DisplayName("Metodo adicionarPessoa()")
    public void adicionarPessoaTest() throws Exception {
        when(pessoaMock.valido()).thenReturn(true);

        turma.adicionarPessoa(pessoaMock);
        assertEquals(1, turma.getPessoas().size());
        assertTrue(turma.getPessoas().contains(pessoaMock));

        verify(pessoaMock, times(1)).valido();

    }

    @Test
    @DisplayName("Adicionar Pessoa invalida na classe Turma")
    public void adicionarPessoaInvalidaTest() {
        when(pessoaMock.valido()).thenReturn(false);

        Exception exception = assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoaMock));

        String mensagemEsperada = "Objeto pessoa inválido";
        assertEquals(mensagemEsperada, exception.getMessage());

        assertEquals(0, turma.getPessoas().size());
    }


    @Test
    @DisplayName("Adicionar pessoa com mesmo Id na classe Turma")
    public void testAdicionarPessoaComMesmoId() throws Exception {
        when(pessoaMock.valido()).thenReturn(true);
        when(pessoaMock.getId()).thenReturn(1);

        turma.adicionarPessoa(pessoaMock);

        when(outraPessoaMock.valido()).thenReturn(true);
        when(outraPessoaMock.getId()).thenReturn(1);

        Exception exception = assertThrows(Exception.class, () -> turma.adicionarPessoa(outraPessoaMock));
        String mensagemEsperada = "Objeto pessoa já está atribuido a turma";
        assertEquals(mensagemEsperada, exception.getMessage());

        assertEquals(1, turma.getPessoas().size());

        verify(outraPessoaMock, times(1)).valido();
        verify(outraPessoaMock, times(1)).getId();
        verify(pessoaMock, times(1)).valido();
        verify(pessoaMock, times(1)).getId(); // Nesse método consegui testar se está sendo chamado
    }

    @Test
    @DisplayName("Remover todas as pessoas")
    public void removerTodasPessoasTest() throws Exception {
        when(pessoaMock.valido()).thenReturn(true);
        turma.adicionarPessoa(pessoaMock);

        assertEquals(1, turma.getPessoas().size());

        turma.removerTodasPessoas();

        assertEquals(0, turma.getPessoas().size());
    }

    @Test
    @DisplayName("Metodo getPessoas()")
    public void getPessoasTest() throws Exception {
        when(pessoaMock.valido()).thenReturn(true);
        when(pessoaMock.getId()).thenReturn(1);

        when(outraPessoaMock.valido()).thenReturn(true);
        when(outraPessoaMock.getId()).thenReturn(2);

        turma.adicionarPessoa(pessoaMock);
        turma.adicionarPessoa(outraPessoaMock);

        List<Pessoa> pessoas = turma.getPessoas();

        assertEquals(2, pessoas.size());
        assertEquals(pessoaMock, pessoas.get(0));
        assertEquals(outraPessoaMock, pessoas.get(1));
    }







}
