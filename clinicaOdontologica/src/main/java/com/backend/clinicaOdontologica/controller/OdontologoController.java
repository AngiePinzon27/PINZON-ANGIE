package com.backend.clinicaOdontologica.controller;

import com.backend.clinicaOdontologica.dto.Entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.Salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @PostMapping("registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo){
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);

    }
    @PutMapping("actualizar/{id}")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo, @PathVariable long id){
        return new ResponseEntity<>(odontologoService.modificarOdontologo(odontologo, id), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id),HttpStatus.OK);
    }
    @GetMapping("listar")
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos(){
        return new ResponseEntity<>(odontologoService.listarOdontologos(),HttpStatus.OK);

    }
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo elimiinado correctamente", HttpStatus.NO_CONTENT);
    }

}
