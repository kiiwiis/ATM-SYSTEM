package com.ATMSystem.ATM.Model.Dao;

import com.ATMSystem.ATM.Exception.FindException;
import com.ATMSystem.ATM.Model.Intarface.IPersona_Dao;
import com.ATMSystem.ATM.Model.Persona;
import com.ATMSystem.ATM.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Persona_Dao implements IPersona_Dao {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona_Dao(PersonaRepository personaRepository){
        super();
        this.personaRepository = personaRepository;
    }
    //CREATE
    @Override
    public Persona savePersona(Persona persona){
        return personaRepository.save(persona);
    }
    //READ
    @Override
    public List<Persona> getAllPersona(){
        return personaRepository.findAll();
    }
    //READ BY ID
    @Override
    public Persona getPersonaById(long id){
        return personaRepository.findById(id).orElseThrow(()->
                new FindException("Persona", "id_Persona", id));
    }
    //UPDATE
    @Override
    public Persona updatePersona(Persona persona, long id){
        Persona existePersona = personaRepository.findById(id).orElseThrow(() ->
                new FindException("Persona", "id_Persona", id));
        existePersona.setNombre(persona.getNombre());
        existePersona.setApellido(persona.getApellido());
        existePersona.setDui(persona.getDui());
        existePersona.setCorreo(persona.getCorreo());
        existePersona.setTelefono(persona.getTelefono());
        existePersona.setFechaNacimiento(persona.getCorreo());
        personaRepository.save(existePersona);
        return existePersona;
    }
    //DELETE
    @Override
    public void deletePersona(long id){
        personaRepository.findById(id).orElseThrow(() ->
                new FindException("Persona", "id_Persona", id));
        personaRepository.deleteById(id);
    }
}
