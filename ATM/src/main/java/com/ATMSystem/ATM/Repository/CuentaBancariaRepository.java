package com.ATMSystem.ATM.Repository;

import com.ATMSystem.ATM.Model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
}
