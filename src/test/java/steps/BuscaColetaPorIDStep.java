package steps;

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
        //statusCode = 403;
        Assert.assertEquals(statusCode, buscaPorIdService.response.statusCode());
    }
}
