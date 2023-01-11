package com.ATMSystem.ATM.Repository;

import com.ATMSystem.ATM.Model.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
}
