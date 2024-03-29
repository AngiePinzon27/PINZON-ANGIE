package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.Entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.Entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource (locations = "classpath:application-test.properties")

class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;

    @Test
    void deberiaDevolverListaVaciaDeTurnos (){
        List<TurnoSalidaDto> turnos = turnoService.listarTurnos();

        assertTrue(turnos.isEmpty());

    }
    @Test
    public void testModificarTurno() throws ResourceNotFoundException {

        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L, 2L, LocalDateTime.of(2024,4,2, 12,30, 15));
        Turno turno = new Turno(1,1L LocalDateTime.of(2024, 4, 2, 12, 30,15));
        TurnoSalidaDto turnoSalidaDtoEsperado = new TurnoSalidaDto(2L, 1, 2, LocalDateTime.of(2024, 4, 2, 12,30, 15));





        TurnoSalidaDto turnoSalidaDto = turnoService.modificarTurno(turnoEntradaDto, 1L);


    }
}