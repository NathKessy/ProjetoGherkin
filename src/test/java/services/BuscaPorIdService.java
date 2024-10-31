package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.BuscaPorIdModel;
import net.minidev.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class BuscaPorIdService {

    final BuscaPorIdModel buscaPorIdModel = new BuscaPorIdModel();
    public final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    String baseUrl = "http://localhost:8080";
    JSONObject jsonSchema;
    String schemasPath = "src/test/resources/schemas/";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toString() {
        return super.toString();
    }

    public void setFieldBuscaPorId(String field, String value) {
        switch (field) {
            case "id" -> buscaPorIdModel.setId(Integer.valueOf(value));
            case "tipoColeta" -> buscaPorIdModel.setTipoColeta(value);
            case "dataColeta" -> buscaPorIdModel.setDataColeta(LocalDate.parse(value));
            case "nomeContato" -> buscaPorIdModel.setNomeContato(value);
            case "telefoneContato" -> buscaPorIdModel.setTelefoneContato(value);
            case "emailContato" -> buscaPorIdModel.setEmailContato(value);
            case "enderecoContato" -> buscaPorIdModel.setEnderecoContato(value);
            default -> throw new IllegalStateException("Campo inválido: " + field);
        }
    }

    public void createBuscaPorId(String endPoint) {
        String url = baseUrl + endPoint;
        String bodySend = gson.toJson(buscaPorIdModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodySend)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }
        public void setContract(String contract) throws IOException{
        switch (contract) {
            case "Busca coleta por ID com sucesso" -> jsonSchema = loaJsonFromFile(schemasPath + "busca-coleta-por-id-com-sucesso.json");
            default -> throw new IllegalStateException("Unexpected contract" + contract);
        }
    }

    private JSONObject loaJsonFromFile(String filePath) throws IOException {
        // Lê o conteúdo do arquivo em uma string
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        // Converte a string JSON em um Map
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(fileContent, Map.class);
        // Cria o JSONObject a partir do Map
        return new JSONObject(map);
    }

    public Set<ValidationMessage> validateResponseAgainstSchema() throws IOException {
        // Obter o corpo da resposta como String e converter diretamente para JsonNode
        JsonNode jsonResponseNode = mapper.readTree(response.getBody().asString());

        // Configurar o JsonSchemaFactory e criar o JsonSchema a partir do jsonSchema definido
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema schema = schemaFactory.getSchema(jsonSchema.toString());

        // Validar o JSON de resposta contra o esquema e coletar os erros de validação
        Set<ValidationMessage> schemaValidationErrors = schema.validate(jsonResponseNode);

        return schemaValidationErrors;
    }
}