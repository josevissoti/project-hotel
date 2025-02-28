package com.project.services;

import com.project.domains.Quarto;
import com.project.domains.dtos.QuartoDTO;
import com.project.repositories.QuartoRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<QuartoDTO> findAll() {
        return quartoRepository.findAll().stream()
                .map(obj -> new QuartoDTO(obj))
                .collect(Collectors.toList());
    }

    public Quarto findById(int id) {
        Optional<Quarto> obj = quartoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Quarto não encontrado. ID: " + id));
    }

    public Quarto create(QuartoDTO dto) {
        dto.setIdQuarto(null);
        Quarto obj = new Quarto(dto);
        return quartoRepository.save(obj);
    }

    public Quarto update(Integer id, QuartoDTO objDto) {
        objDto.setIdQuarto(id);
        Quarto oldObj = findById(id);
        oldObj = new Quarto(objDto);
        return quartoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Quarto obj = findById(id);
        if (obj.getReservas().size() > 0) {
            throw new DataIntegrityViolationException("Quarto não pode ser deletado pois possui reservas vinvuldas");
        }
        quartoRepository.deleteById(id);
    }
}
