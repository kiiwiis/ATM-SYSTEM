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
@Table(name="CuentaBancaria")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="n_CuentaBancaria", nullable = false)
    private int n_CuentaBancaria;

    @Column(name="saldo")
    private int saldo;

    @Column(name="usuario")
    private String usuario;

    @Column(name="pin")
    private int pin;
}
