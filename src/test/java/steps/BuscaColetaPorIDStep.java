package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import model.AvisoMessageModel;
import org.junit.Assert;
import services.BuscaPorIdService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuscaColetaPorIDStep {

    BuscaPorIdService buscaPorIdService = new BuscaPorIdService();

    @io.cucumber.java.pt.Dado("que existe uma coleta com ID:$")
    public void queExisteUmaColetaComID(List<Map<String, String>> rows) {
        for (Map<String, String> column : rows) {
            buscaPorIdService.setFieldBuscaPorId(column.get("campo"), column.get("valor"));
        }
    }

    @io.cucumber.java.pt.Quando("eu faço uma requisição GET para {string} para procurar a coleta")
    public void euFaçoUmaRequisiçãoGETParaProcurarAColeta(String endpoint) throws Throwable {
        buscaPorIdService.createBuscaPorId(endpoint);
    }

    @io.cucumber.java.pt.Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, buscaPorIdService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        AvisoMessageModel avisoMessageModel = buscaPorIdService.gson.fromJson(
                buscaPorIdService.response.jsonPath().prettify(), AvisoMessageModel.class); // Remova o prettify() se ainda falhar
        Assert.assertEquals(message, avisoMessageModel.getMessage());
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contract) throws IOException {
        buscaPorIdService.setContract(contract);
    }

    @Então("a resposta da requisicao deve estar em comfirmidade com o contrato selecionado")
    public void aRespostaDaRequisicaoDeveEstarEmComfirmidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validationResponse = buscaPorIdService.validateResponseAgainstSchema();
        Assert.assertTrue("o contrato está invalido. Erros encontrados: " + validationResponse, validationResponse.isEmpty());
    }
}
