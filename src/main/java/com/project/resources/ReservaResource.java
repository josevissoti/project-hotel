package com.project.resources;

import com.project.domains.Reserva;
import com.project.domains.dtos.ReservaDTO;
import com.project.services.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        return ResponseEntity.ok().body(reservaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        Reserva obj = reservaService.findById(id);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @GetMapping(value = "/codigobarras/{codigoBarras}")
    public ResponseEntity<ReservaDTO> findByCodigoBarras(@PathVariable String codigoBarras) {
        Reserva obj = reservaService.findByCodigoBarras(codigoBarras);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> create(@Valid @RequestBody ReservaDTO dto) {
        Reserva reserva = reservaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(reserva.getIdReserva()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO objDto) {
        Reserva obj = reservaService.update(id, objDto);
        return ResponseEntity.ok().body(new ReservaDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReservaDTO> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
