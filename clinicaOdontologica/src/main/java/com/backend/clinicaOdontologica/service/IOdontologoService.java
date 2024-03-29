package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.Entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id);

    OdontologoSalidaDto modificarOdontologo(OdontologoEntradaDto odontologoEntradaDto, Long id) throws ResourceNotFoundException;
}

