package com.project.services;

import com.project.domains.dtos.ReservaDTO;
import com.project.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaDTO> findAll(){
        return reservaRepository.findAll().stream()
                .map(obj -> new ReservaDTO(obj))
                .collect(Collectors.toList());
    }
}
