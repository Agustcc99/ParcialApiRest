package com.skp.parcial_agustin_tacconi.excepciones;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

    private int status;
    private String message;
    private Date timestamp;
    private String details;

}
