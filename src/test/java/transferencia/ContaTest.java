package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvioSantos;

    @BeforeEach
    void setUp(){

        xuxa = new Cliente("Xuxa","1234567890","1234432");
        silvioSantos = new Cliente("Silvio Santos","0987654321","1987654");

        contaXuxa = new Conta("1244","112255",5000.33,xuxa);
        contaSilvioSantos = new Conta("1256","113366",2000.99,silvioSantos);
    }

    @Test
    public void validarNome(){
        assertEquals(xuxa, xuxa.getNome());
    }

    @Test
    public void validarCpf(){
        assertEquals(xuxa, xuxa.getCpf());
    }

    @Test
    public void validarRg(){
        assertEquals(xuxa, xuxa.getRg());
    }

    @Test
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000.00, contaSilvioSantos);
        assertEquals(4000.33, contaXuxa.getSaldo());
        assertEquals(3000.99, contaSilvioSantos.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado = contaXuxa.realizarTransferencia(13000.00, contaSilvioSantos);
        assertFalse(resultado);
    }

    @Test
    public void validarSaqueInvalido(){
        boolean resultado = contaXuxa.realizarSaque(11000.99);
    }

    @Test
    public void validarProprietario(){
        assertEquals(xuxa, contaXuxa.getProprietario());
    }

    @Test
    public void validarAgencia(){
        assertEquals(contaXuxa, contaXuxa.getAgencia());
    }

    @Test
    public void validarConta(){
        assertEquals(contaXuxa, contaXuxa.getNumeroConta(112255));
    }
}