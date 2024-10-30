package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CadastroColetaModel;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public class CadastroColetaService {
    final CadastroColetaModel cadastroColetaModel = new CadastroColetaModel();
    public final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public Response response;
    String baseUrl = "http://localhost:8080";

    public void setFieldsCadastroColeta(String field, String value) {
        switch (field) {
            case "tipoColeta" -> cadastroColetaModel.setTipoColeta(value);
            case "dataColeta" -> cadastroColetaModel.setDataColeta(value);
            case "nomeContato" -> cadastroColetaModel.setNomeContato(value);
            case "telefoneContato" -> cadastroColetaModel.setTelefoneContato(value);
            case "emailContato" -> cadastroColetaModel.setEmailContato(value);
            case "enderecoContato" -> cadastroColetaModel.setEnderecoContato(value);
            default -> throw new IllegalStateException("Campo inválido: " + field);
        }
    }

    public void createCadastroColeta(String endPoint) {
        String url = baseUrl + endPoint;
        String bodySend = gson.toJson(cadastroColetaModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodySend)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
}
