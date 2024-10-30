package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.CadastroColetaService;

import java.util.List;
import java.util.Map;

public class CadastroColetaStep {

    CadastroColetaService cadastroColetaService = new CadastroColetaService();

    @Dado("que eu tenha os seguintes dados da coleta:")
    public void queEuTenhaOsSeguintesDadosDaColeta(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastroColetaService.setFieldsCadastroColeta(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao POST para o endpoint {string} para cadastro da coleta")
    public void euEnviarARequisicaoPOSTParaOEndpointParaCadastroDaColeta(String endpoint) {
        cadastroColetaService.createCadastroColeta(endpoint);
    }

    @Então("o status code deve retornar {int}")
    public void oStatusCodeDeveRetornar(int statusCode) {
        Assert.assertEquals(statusCode, cadastroColetaService.response.statusCode());
    }
}
