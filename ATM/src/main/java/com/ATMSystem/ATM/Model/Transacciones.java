package com.ATMSystem.ATM.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="Transacciones")
public class Transacciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "detalleTransaccion", nullable = false)
    private String detalleTransaccion;

    @Column(name="fechaTransaccion")
    private String fechaTransaccion;

    @Column(name="movimiento")
    private Double movimiento;
}
