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
//    String baseUrl = "http://localhost:8080/api/coleta/5";
    String baseUrl = "http://localhost:8080";

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
}