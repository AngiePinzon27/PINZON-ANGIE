package com.backend.clinicaOdontologica.dto.Entrada;

import com.google.gson.annotations.Since;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OdontologoEntradaDto {
    @NotNull (message = "La matricula no puede ser nulo")
    @NotBlank (message = "Debe especificarse la matricula del odontologo")
    @Size (min = 10, max = 50, message = "El campo debe tener minimo 10 caracteres")
    private String matricula;
    @NotNull (message = "El nombre del odontologo no puede ser nulo")
    @NotBlank (message = "Debe especificarse el nombre del odontologo")
    @Size (min = 2, max = 50, message = "El nombre del odontologo debe tener un maximo de 50 caracteres")
    private String nombre;
    @NotNull (message = "El apellido del odontologo no puede ser nulo")
    @NotBlank (message = "Dee especificarse el apellido del odontologo")
    @Size (min = 2, max = 50, message = "El apellido del odontologo debe tener un maximo de 50 caracteres")
    private String apellido;

    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
