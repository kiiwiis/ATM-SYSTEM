package com.ATMSystem.ATM.Controller;

import java.util.List;

import com.ATMSystem.ATM.Model.Intarface.IPersona_Dao;
import com.ATMSystem.ATM.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/Persona")
public class PersonaController {
    @Autowired
    private IPersona_Dao iPersona_Dao;

    //CREATE PERSONA REST API
    @PostMapping("savePersona/{id_Persona}")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        return new ResponseEntity<Persona>(iPersona_Dao.savePersona(persona), HttpStatus.CREATED);
    }

    //READ TODA PERSONA REST API
    @GetMapping("readPersona/{id_Persona}")
    public List<Persona> getAllPersona(){
        return iPersona_Dao.getAllPersona();
    }

    //READ BY ID PERSONA REST API
    //http://localhost:8080/api/Persona/id_Persona
    @GetMapping("readByIbPersona/{id_Persona}")
    public ResponseEntity<Persona> getPersonaByID(@PathVariable("id_Persona") long idPersona){
        return new ResponseEntity<Persona>(iPersona_Dao.getPersonaById(idPersona), HttpStatus.OK);
    }

    //UPDATE PERSONA REST API
    //http://localhost:8080/api/Persona/id_Persona
    @PutMapping("updatePersona/{id_Persona}")
    public ResponseEntity<Persona> updatePersona(@PathVariable("id_Persona") long idPersona, @RequestBody Persona persona){
        return new ResponseEntity<Persona>(iPersona_Dao.updatePersona(persona, idPersona), HttpStatus.OK);
    }

    //DELETE PERSONA REST API
    //http://localhost:8080/api/Persona/id_Persona
    @DeleteMapping("deletePersona/{id_Persona}")
    public ResponseEntity<String> deletePersona(@PathVariable("id_Persona")long idPersona){
        iPersona_Dao.deletePersona(idPersona);
        return new ResponseEntity<String>("Persona deleted successfully!", HttpStatus.OK);
    }
}