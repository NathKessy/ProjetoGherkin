package hook;

import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Hook {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Simulação de configuração global antes de todos os testes
        System.out.println("Configuração global antes de todos os testes.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // Simulação de limpeza global após a execução de todos os testes
        System.out.println("Limpeza global após todos os testes.");
    }

    @Before
    public void setUp() {
        System.out.println("Iniciando um novo cenário de teste...");
    }

    @After
    public void tearDown() {
        System.out.println("Finalizando o cenário de teste...");
    }
}
