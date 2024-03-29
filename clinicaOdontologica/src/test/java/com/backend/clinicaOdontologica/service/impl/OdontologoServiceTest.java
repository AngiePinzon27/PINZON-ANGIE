package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.Entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.Entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.Entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.Salida.PacienteSalidaDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties" )

class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    @Test
    @Order(1)
    void deberiaRegistrarseUnOdontologoDeNombreSantiago_yRetornarSuId() {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("123489", "Santiago", "Lopez");


        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);


        assertNotNull(odontologoSalidaDto);
        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("Santiago", odontologoSalidaDto.getNombre());

    }
    @Test
    @Order(2)
    void deberiaEliminarseElOdontologoConId1() {


        assertDoesNotThrow(() -> odontologoService.eliminarOdontologo(1L));
    }
    @Test
    @Order(3)
    void deberiaDevolverUnaListaVaciaDeOdontologos() {
        List<OdontologoSalidaDto> odontologos = odontologoService.listarOdontologos();

        assertTrue(odontologos.isEmpty());
    }



}