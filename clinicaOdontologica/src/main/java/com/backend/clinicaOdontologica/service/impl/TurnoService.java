package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.Entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.Salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.Salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;

    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }
    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        TurnoSalidaDto turnoSalidaDto;
        PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turnoEntradaDto.getPacienteId());
        OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turnoEntradaDto.getOdontologoId());

        String pacienteNoEnBdd = "El paciente no se encuentra en nuestra base de datos";
        String odontologoNoEnBdd = "El odontologo no se encuentra en nuestra base de datos";
        String ambosNulos = "El paciente y el odontologo no se encuentran en nuestra base de datos";

        if (paciente == null || odontologo == null) {
            if (paciente == null && odontologo == null) {
                LOGGER.error(ambosNulos);
                throw new BadRequestException(ambosNulos);
            } else if (paciente == null) {
                LOGGER.error(pacienteNoEnBdd);
                throw new BadRequestException(pacienteNoEnBdd);
            } else {
                LOGGER.error(odontologoNoEnBdd);
                throw new BadRequestException(odontologoNoEnBdd);
            }

        } else {
            Turno turnoNuevo = turnoRepository.save(modelMapper.map(turnoEntradaDto, Turno.class));
            turnoSalidaDto = entidadADtoSalida(turnoNuevo, paciente, odontologo);
            LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
        }


        return turnoSalidaDto;
    }
    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnoSalidaDto = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno,TurnoSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los turnos: {}", turnoSalidaDto);
        return turnoSalidaDto;
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {

        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;
        if (turnoBuscado != null) {
            turnoSalidaDto = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno encontrado: {}", turnoSalidaDto);
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return turnoSalidaDto;

    }
    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException{

        if (buscarTurnoPorId(id) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con id {}", id);

        } else {

            throw new ResourceNotFoundException("No existe registro de turno con id" + id);

        }

    }



        @Override
    public TurnoSalidaDto modificarTurno(TurnoEntradaDto turnoEntradaDto, Long id) throws ResourceNotFoundException {
        Turno turnoRecibido = modelMapper.map(turnoEntradaDto, Turno.class);
        Turno turnoAActualizar = turnoRepository.findById(id).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;

        if (turnoAActualizar != null) {
            turnoAActualizar.setFechaYHora(turnoRecibido.getFechaYHora());
            turnoAActualizar.getOdontologo().setNombre(turnoRecibido.getOdontologo().getNombre());
            turnoAActualizar.getOdontologo().setApellido(turnoRecibido.getOdontologo().getApellido());
            turnoAActualizar.getOdontologo().setMatricula(turnoRecibido.getOdontologo().getMatricula());
            turnoAActualizar.getPaciente().setNombre(turnoRecibido.getPaciente().getNombre());
            turnoAActualizar.getPaciente().setApellido(turnoRecibido.getPaciente().getApellido());
            turnoAActualizar.getPaciente().setDni(turnoRecibido.getPaciente().getDni());
            turnoAActualizar.getPaciente().setFechaIngreso(turnoRecibido.getPaciente().getFechaIngreso());

            turnoRepository.save(turnoAActualizar);

            turnoSalidaDto = modelMapper.map(turnoAActualizar, TurnoSalidaDto.class);
            LOGGER.warn("Turno actualizado: {}", JsonPrinter.toString(turnoSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el turno porque no se encuentra en nuestra base de datos");
            throw new ResourceNotFoundException("No es posible actualizar el turno con id" + id + "ya que no se encuentra en nuestra base de datos");
        }
        return turnoSalidaDto;

        }


        private TurnoSalidaDto entidadADtoSalida(Turno turno, PacienteSalidaDto pacienteSalidaDto, OdontologoSalidaDto odontologoSalidaDto) {
            TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
            turnoSalidaDto.setPacienteSalidaDto(pacienteSalidaDto);
            turnoSalidaDto.setOdontologoSalidaDto(odontologoSalidaDto);
            return turnoSalidaDto;
        }


    }







