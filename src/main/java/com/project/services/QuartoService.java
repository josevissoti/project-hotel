package com.project.services;

import com.project.domains.dtos.QuartoDTO;
import com.project.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<QuartoDTO> findAll(){
        return quartoRepository.findAll().stream()
                .map(obj -> new QuartoDTO(obj))
                .collect(Collectors.toList());
    }
}
