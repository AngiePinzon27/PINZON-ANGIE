package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.Entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException, ResourceNotFoundException;

    List<TurnoSalidaDto> listarTurnos();

    TurnoSalidaDto buscarTurnoPorId(Long id);

    void eliminarTurno(Long id);

    TurnoSalidaDto modificarTurno(TurnoEntradaDto turnoEntradaDto, Long id);
}
