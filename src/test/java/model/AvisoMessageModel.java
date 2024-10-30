package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class AvisoMessageModel {
    @Expose
    private String message;
}
