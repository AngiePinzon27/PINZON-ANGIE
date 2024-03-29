package com.backend.clinicaOdontologica.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table (name = "PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 50)
    private String nombre;
    @Column (length = 50)
    private String apellido;
    @Column (length = 20)
    private int dni;
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilo;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilo = domicilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilo() {
        return domicilo;
    }

    public void setDomicilo(Domicilio domicilo) {
        this.domicilo = domicilo;
    }
}
