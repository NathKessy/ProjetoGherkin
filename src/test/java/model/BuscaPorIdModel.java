package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BuscaPorIdModel {
    @Expose(serialize = true)
    private Integer id;
    @Expose
    private String tipoColeta;
    @Expose
    private LocalDate dataColeta;
    @Expose
    private String nomeContato;
    @Expose
    private String telefoneContato;
    @Expose
    private String emailContato;
    @Expose
    private String enderecoContato;
}
