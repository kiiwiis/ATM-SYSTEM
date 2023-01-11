package com.ATMSystem.ATM.Model.Intarface;

import com.ATMSystem.ATM.Model.CuentaBancaria;

import java.util.List;

public interface ICuentaBancaria_Dao {
    CuentaBancaria saveCuentaBancaria(CuentaBancaria cuentaBancaria);
    List<CuentaBancaria> getAllCuentaBancaria();
    CuentaBancaria getCuentaBancariaById(long id);
    CuentaBancaria updateCuentaBancaria(CuentaBancaria cuentaBancaria, long id);
    void deleteCuentaBancaria(long id);
}
