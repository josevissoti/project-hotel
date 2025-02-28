package com.project.resources;

import com.project.domains.Quarto;
import com.project.domains.dtos.QuartoDTO;
import com.project.services.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/quarto")
public class QuartoResource {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> findAll() {
        return ResponseEntity.ok().body(quartoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuartoDTO> findById(@PathVariable Integer id) {
        Quarto obj = this.quartoService.findById(id);
        return ResponseEntity.ok().body(new QuartoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> create(@Valid @RequestBody QuartoDTO dto) {
        Quarto quarto = quartoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(quarto.getIdQuarto()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<QuartoDTO> update(@PathVariable Integer id, @Valid @RequestBody QuartoDTO objDto) {
        Quarto obj = quartoService.update(id, objDto);
        return ResponseEntity.ok().body(new QuartoDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<QuartoDTO> delete(@PathVariable Integer id) {
        quartoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
