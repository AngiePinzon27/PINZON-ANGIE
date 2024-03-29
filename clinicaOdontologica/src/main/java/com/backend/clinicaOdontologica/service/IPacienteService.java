package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.Entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.Entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.Salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id) throws ResourceNotFoundException;
}

