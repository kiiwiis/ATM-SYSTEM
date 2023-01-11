package com.ATMSystem.ATM.Controller;

import java.util.List;

import com.ATMSystem.ATM.Model.CuentaBancaria;
import com.ATMSystem.ATM.Model.Intarface.ICuentaBancaria_Dao;
import com.ATMSystem.ATM.Repository.CuentaBancariaRepository;
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

@RestController
@RequestMapping("/api/CuentaBancaria")
public class CuentaBancariaController {
    private ICuentaBancaria_Dao iCuentaBancaria_Dao;
    public CuentaBancariaController(ICuentaBancaria_Dao iCuentaBancaria_Dao){
        super();
        this.iCuentaBancaria_Dao = iCuentaBancaria_Dao;
    }

    //CREATE CUENTABANCARIA REST API
    @PostMapping
    public ResponseEntity<CuentaBancaria> saveCuentaBancaria(@RequestBody CuentaBancaria cuentaBancaria){
        return new ResponseEntity<CuentaBancaria>(iCuentaBancaria_Dao.saveCuentaBancaria(cuentaBancaria), HttpStatus.CREATED);
    }
    //READ TODA CUENTABANCARIA REST API
    @GetMapping
    public List<CuentaBancaria> getAllCuentaBancaria(){
        return iCuentaBancaria_Dao.getAllCuentaBancaria();
    }
    //READ BY ID CUENTABANCARIA REST API
    //http://localhost:8080/api/CuentaBancaria/id_CuentaBancaria
    @GetMapping("{id_CuentaBancaria}")
    public ResponseEntity<CuentaBancaria> getCuentaBancariaById(@PathVariable("id_CuentaBancaria") long idCuentaBancaria){
        return new ResponseEntity<CuentaBancaria>(iCuentaBancaria_Dao.getCuentaBancariaById(idCuentaBancaria), HttpStatus.OK);
    }
    //UPDATE CUENTABANCARIA REST API
    //http://localhost:8080/api/CuentaBancaria/id_CuentaBancaria
    @PutMapping("{id_CuentaBancaria}")
    public ResponseEntity<CuentaBancaria> updateCuentaBancaria(@PathVariable("id_CuentaBancaria") long idCuentaBancaria, @RequestBody CuentaBancaria cuentaBancaria){
        return new ResponseEntity<CuentaBancaria>(iCuentaBancaria_Dao.updateCuentaBancaria(cuentaBancaria, idCuentaBancaria), HttpStatus.OK);
    }
    //DELETE PERSONA REST API
    //http://localhost:8080/api/CuentaBancaria/id_CuentaBancaria
    @DeleteMapping("{id_CuentaBancaria}")
    public ResponseEntity<String> deleteCuentaBancaria(@PathVariable("id_CuentaBancaria") long idCuentaBancaria){
        iCuentaBancaria_Dao.deleteCuentaBancaria(idCuentaBancaria);
        return new ResponseEntity<String>("Cuenta Bancaria deleted successfully!",HttpStatus.OK);
    }
}
