package com.project.resources;

import com.project.domains.dtos.QuartoDTO;
import com.project.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/quarto")
public class QuartoResource {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> findAll(){
        return ResponseEntity.ok().body(quartoService.findAll());
    }
}
