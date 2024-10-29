package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.BuscaPorIdModel;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public class BuscaPorIdService {

    final BuscaPorIdModel buscaPorIdModel = new BuscaPorIdModel();
    public final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    String baseUrl = "http://localhost:8080";

    // Adicione suas credenciais aqui
    private final String username = "user";
    private final String password = "password";

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
        String url = baseUrl + endPoint; // URL da API
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().preemptive().basic(username, password) // Autenticação básica
                .when()
                .get(url) // Alterado de post para get
                .then()
                .extract()
                .response();
    }



}
