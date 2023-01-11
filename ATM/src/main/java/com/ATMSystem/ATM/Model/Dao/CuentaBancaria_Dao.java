package com.ATMSystem.ATM.Model.Dao;

import com.ATMSystem.ATM.Exception.FindException;
import com.ATMSystem.ATM.Model.CuentaBancaria;
import com.ATMSystem.ATM.Model.Intarface.ICuentaBancaria_Dao;
import com.ATMSystem.ATM.Repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaBancaria_Dao implements ICuentaBancaria_Dao {
    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    //CREATE
    @Override
    public CuentaBancaria saveCuentaBancaria(CuentaBancaria cuentaBancaria){
        return cuentaBancariaRepository.save(cuentaBancaria);
    }
    //READ
    @Override
    public List<CuentaBancaria> getAllCuentaBancaria(){
        return cuentaBancariaRepository.findAll();
    }
    //READ BY ID
    @Override
    public CuentaBancaria getCuentaBancariaById(long id){
        return cuentaBancariaRepository.findById(id).orElseThrow(()->
                new FindException("CuentaBancaria", "id_CuentaBancaria", id));
    }

    @Override
    public CuentaBancaria updateCuentaBancaria(CuentaBancaria cuentaBancaria, long id){
        CuentaBancaria existeCuentaBancaria = cuentaBancariaRepository.findById(id).orElseThrow(()->
                new FindException("CuentaBancaria", "id_CuentaBancaria", id));
        existeCuentaBancaria.setN_CuentaBancaria(existeCuentaBancaria.getN_CuentaBancaria());
        existeCuentaBancaria.setPin(existeCuentaBancaria.getPin());
        existeCuentaBancaria.setUsuario(existeCuentaBancaria.getUsuario());
        existeCuentaBancaria.setSaldo(existeCuentaBancaria.getSaldo());
        cuentaBancariaRepository.save(existeCuentaBancaria);
        return existeCuentaBancaria;
    }
    //DELETE
    @Override
    public void deleteCuentaBancaria(long id){
        cuentaBancariaRepository.findById(id).orElseThrow(()->
                new FindException("CuentaBancaria", "id_CuentaBancaria", id));
    cuentaBancariaRepository.deleteById(id);
    }
}
