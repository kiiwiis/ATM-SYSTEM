package com.ATMSystem.ATM.Model.Intarface;

import com.ATMSystem.ATM.Model.Transacciones;

import java.util.List;

public interface ITransacciones_Dao {
    Transacciones saveTransacciones(Transacciones transacciones);
    List<Transacciones> getAllTransacciones();
    Transacciones getTransaccionesById(long id);
    Transacciones updateTransacciones(Transacciones transacciones, long id);
    void deleteTransacciones(long id);
}
