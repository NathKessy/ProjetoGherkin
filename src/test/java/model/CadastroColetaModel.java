package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CadastroColetaModel {

    @Expose
    private String tipoColeta;

    @Expose
    private String dataColeta;

    @Expose
    private String nomeContato;

    @Expose
    private String telefoneContato;

    @Expose
    private String emailContato;

    @Expose
    private String enderecoContato;

}
