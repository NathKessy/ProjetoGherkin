package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import model.AvisoMessageModel;
import org.junit.Assert;
import services.BuscaPorIdService;

import java.util.List;
import java.util.Map;

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
        // Não lançar PendingException aqui, apenas armazene a resposta
    }

    @io.cucumber.java.pt.Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, buscaPorIdService.response.statusCode());
    }

//    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
//    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
//        AvisoMessageModel avisoMessageModel = buscaPorIdService.gson.fromJson(
//                buscaPorIdService.response.jsonPath().prettify(), AvisoMessageModel.class);
//        Assert.assertEquals(message, avisoMessageModel.getMessage());
//    }
}
