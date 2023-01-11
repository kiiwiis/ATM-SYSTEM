package com.ATMSystem.ATM.Model.Intarface;

import com.ATMSystem.ATM.Model.Persona;

import java.util.List;

public interface IPersona_Dao {
    Persona savePersona(Persona persona);
    List<Persona> getAllPersona();
    Persona getPersonaById(long id);
    Persona updatePersona(Persona persona, long id);
    void deletePersona(long id);
}
