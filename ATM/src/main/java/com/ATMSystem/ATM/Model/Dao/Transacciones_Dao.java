package com.ATMSystem.ATM.Model.Dao;

import com.ATMSystem.ATM.Exception.FindException;
import com.ATMSystem.ATM.Model.Intarface.ITransacciones_Dao;
import com.ATMSystem.ATM.Model.Transacciones;
import com.ATMSystem.ATM.Repository.TransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Transacciones_Dao implements ITransacciones_Dao {
    private TransaccionesRepository transaccionesRepository;
    @Autowired


    //CREATE
    @Override
    public Transacciones saveTransacciones(Transacciones transacciones){
        return transaccionesRepository.save(transacciones);
    }
    //READ
    @Override
    public List<Transacciones> getAllTransacciones(){
        return transaccionesRepository.findAll();
    }
    //READ BY ID
    @Override
    public Transacciones getTransaccionesById(long id){
        return transaccionesRepository.findById(id).orElseThrow(()->
                new FindException("Transacciones", "id_Transacciones", id));
    }
    //UPDATE
    @Override
    public Transacciones updateTransacciones(Transacciones transacciones, long id){
        Transacciones existeTransacciones = transaccionesRepository.findById(id).orElseThrow(()->
                new FindException("Transacciones", "id_Transacciones", id));
        existeTransacciones.setDetalleTransaccion(existeTransacciones.getDetalleTransaccion());
        existeTransacciones.setFechaTransaccion(existeTransacciones.getFechaTransaccion());
        existeTransacciones.setMovimiento(existeTransacciones.getMovimiento());
        transaccionesRepository.save(existeTransacciones);
        return existeTransacciones;
    }
    //DELETE
    @Override
    public void deleteTransacciones(long id){
        transaccionesRepository.findById(id).orElseThrow(()->
                new FindException("Transacciones", "id_Transacciones", id));
        transaccionesRepository.deleteById(id);
    }

}
