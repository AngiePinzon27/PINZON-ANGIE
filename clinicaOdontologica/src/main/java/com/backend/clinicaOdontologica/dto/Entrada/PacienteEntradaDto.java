package com.backend.clinicaOdontologica.dto.Entrada;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class PacienteEntradaDto {
    @NotBlank (message = "Debe especificarse el nombre del paciente")
    @Size (min = 2, max = 50, message = "El nombre debe tener un maximo de 50 caracteres")
    private String nombre;
    @NotBlank (message = "Debe especificarse el apellido del paciente")
    @Size (min = 2, max = 50, message = "El apellido debe tener un maximo de 50 caracteres")
    private String apellido;
    @Positive (message = "El dni del pacente no puede ser nulo o menor a cero")
    private int dni;
    @FutureOrPresent (message = "La fecha no puede ser anterior al dia de hoy")
    @NotNull (message = "Debe especificarse la fecha de ingreso del paciente")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//debe tratar el campo como una cadena de caracteres (String) y no como un numero
    private LocalDate fechaIngreso;
    @NotNull (message = "El domicilio del paciente no puede ser nulo")
    @Valid//Se validan los datos que hay en DomicilioEntradaDto como los NotNull, NotBlank
    private DomicilioEntradaDto domicilioEntradaDto;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilioEntradaDto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioEntradaDto = domicilioEntradaDto;
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

    public DomicilioEntradaDto getDomicilioEntradaDto() {
        return domicilioEntradaDto;
    }

    public void setDomicilioEntradaDto(DomicilioEntradaDto domicilioEntradaDto) {
        this.domicilioEntradaDto = domicilioEntradaDto;
    }
}
