package com.ATMSystem.ATM.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FindException extends RuntimeException{

    private static final long serialID = 1l;

    private String  Tablaname;

    private String id;
    private Object value;

    public FindException(String Tablaname, String id, Object value){
        super(String.format("%s not found with %s : '%s'", Tablaname, id, value));
        this.Tablaname = Tablaname;
        this.id = id;
        this.value = value;
    }
    public String getNombre() {
        return Tablaname;
    }

    public String getCuentaBancaria() {
        return id;
    }

    public Object getValue() {
        return value;
    }
}
