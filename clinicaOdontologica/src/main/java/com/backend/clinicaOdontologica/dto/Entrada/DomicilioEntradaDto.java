package com.backend.clinicaOdontologica.dto.Entrada;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DomicilioEntradaDto {
    @NotNull (message = "El campo calle no puede ser nulo")
    @NotBlank (message = "El campo calle no puede estar en blanco")
    private String calle;
    @Positive (message = "El numero no puede ser nulo o menor a cero")
    @Digits (integer = 8, fraction = 0,message = "El numero debe tener como maximo 8 digitos")
    private int numero;
    @NotNull (message = "El campo localidad no puede ser nulo")
    @NotBlank (message = "El campo localidad no puede estar en blanco")
    private String localidad;
    @NotNull (message = "El campo provincia no puede ser nulo")
    @NotBlank (message = "El campo provincia no puede estar en blanco")
    private String providencia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String providencia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.providencia = providencia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvidencia() {
        return providencia;
    }

    public void setProvidencia(String providencia) {
        this.providencia = providencia;
    }
}
