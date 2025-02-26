package com.project.services;

import com.project.domains.Quarto;
import com.project.domains.Reserva;
import com.project.domains.enums.StatusPagamento;
import com.project.repositories.QuartoRepository;
import com.project.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public void initiDB(){

        Quarto quarto01 = new Quarto(null, 8, "5", "3", "10");
        Quarto quarto02 = new Quarto(null, 4, "3", "1", "6");
        Quarto quarto03 = new Quarto(null, 12, "8", "4", "16");

        Reserva reserva01 = new Reserva(null, 3, new BigDecimal("500.00"), 6, LocalDate.of(2025, 02, 28), LocalDate.of(2025, 03, 05), quarto02, StatusPagamento.PAGANDO);
        Reserva reserva02 = new Reserva(null, 12, new BigDecimal("2000.00"), 12, LocalDate.of(2025, 03, 01), LocalDate.of(2025, 03, 30), quarto03, StatusPagamento.PAGANDO);
        Reserva reserva03 = new Reserva(null, 6, new BigDecimal("1000.00"), 8, LocalDate.of(2024, 06, 15), LocalDate.of(2024, 06, 22), quarto01, StatusPagamento.ATRASADO);

        quartoRepository.save(quarto01);
        quartoRepository.save(quarto02);
        quartoRepository.save(quarto03);

        reservaRepository.save(reserva01);
        reservaRepository.save(reserva02);
        reservaRepository.save(reserva03);


    }
}
