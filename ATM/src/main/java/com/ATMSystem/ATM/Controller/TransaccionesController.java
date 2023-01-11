package com.ATMSystem.ATM.Controller;

import com.ATMSystem.ATM.Model.Intarface.ITransacciones_Dao;
import com.ATMSystem.ATM.Model.Transacciones;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Transacciones")
public class TransaccionesController {
    private ITransacciones_Dao itransacciones_Dao;

    public TransaccionesController(ITransacciones_Dao itransacciones_Dao) {
        super();
        this.itransacciones_Dao = itransacciones_Dao;
    }

    //CREATE TRANSACCIONES REST API
    @PostMapping
    public ResponseEntity<Transacciones> saveTransacciones(@RequestBody Transacciones transacciones) {
        return new ResponseEntity<Transacciones>(itransacciones_Dao.saveTransacciones(transacciones), HttpStatus.CREATED);
    }

    //READ TODA TRANSACCIONES REST API
    @GetMapping
    public List<Transacciones> getAllTransacciones() {
        return itransacciones_Dao.getAllTransacciones();
    }

    //READ BY ID TRANSACCIONES REST API
    //http://localhost:8080/api/Transacciones/id_Transacciones
    @GetMapping("{id_Transacciones}")
    public ResponseEntity<Transacciones> getTransaccionesById(@PathVariable("id_Transacciones") long idTransacciones) {
        return new ResponseEntity<Transacciones>(itransacciones_Dao.getTransaccionesById(idTransacciones), HttpStatus.OK);
    }

    //UPDATE TRANSACCIONES REST API
    //http://localhost:8080/api/Transacciones/id_Transacciones
    @PutMapping("{id_Transacciones}")
    public ResponseEntity<Transacciones> updateTransacciones(@PathVariable("id_Transacciones") long idTransacciones, @RequestBody Transacciones transacciones) {
        return new ResponseEntity<Transacciones>(itransacciones_Dao.updateTransacciones(transacciones, idTransacciones), HttpStatus.OK);
    }

    //DELETE TRANSACCIONES REST API
    //http://localhost:8080/api/Transacciones/id_Transacciones
    @DeleteMapping("{id_Transacciones}")
    public ResponseEntity<String> deleteTransacciones(@PathVariable("id_Transacciones")long idTransacciones){
        return new ResponseEntity<String>("Transaccion deleted successfully!", HttpStatus.OK);
    }
}