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
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="fechaNacimiento")
    private String fechaNacimiento;

    @Column(name="dui")
    private int dui;

    @Column(name="correo")
    private String correo;

    @Column(name="telefono")
    private int telefono;
}
