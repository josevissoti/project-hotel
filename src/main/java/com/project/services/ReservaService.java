package com.project.services;

import com.project.domains.Quarto;
import com.project.domains.Reserva;
import com.project.domains.dtos.ReservaDTO;
import com.project.repositories.QuartoRepository;
import com.project.repositories.ReservaRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public List<ReservaDTO> findAll() {
        return reservaRepository.findAll().stream()
                .map(obj -> new ReservaDTO(obj))
                .collect(Collectors.toList());
    }

    public Reserva findById(Long id) {
        Optional<Reserva> obj = reservaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada, ID: " + id));
    }

    public Reserva findByCodigoBarras(String codigoBarras) {
        Optional<Reserva> obj = reservaRepository.findByCodigoBarras(codigoBarras);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Reserva não encontrada. Código de Barras: " + codigoBarras));
    }

    public Reserva create(ReservaDTO dto) {
        dto.setIdReserva(null);
        validaReserva(dto);
        Reserva obj = new Reserva(dto);
        return reservaRepository.save(obj);
    }

    private void validaReserva(ReservaDTO dto) {
        Optional<Reserva> obj = reservaRepository.findByCodigoBarras(dto.getCodigoBarras());
        if (obj.isPresent() && obj.get().getIdReserva() != dto.getIdReserva()) {
            throw new DataIntegrityViolationException("Código de Barras já cadastrado");
        }

        Optional<Quarto> quarto = quartoRepository.findById(dto.getQuarto());
        if (!quarto.isPresent()) {
            throw new DataIntegrityViolationException("Quarto - " + dto.getQuarto() + " não está cadastrado");
        }
    }

    public Reserva update(Long id, ReservaDTO objDto) {
        objDto.setIdReserva(id);
        Reserva oldObj = findById(id);
        validaReserva(objDto);
        oldObj = new Reserva(objDto);
        return reservaRepository.save(oldObj);
    }

    public void delete(Long id) {
        Reserva obj = findById(id);
        reservaRepository.deleteById(id);
    }
}
