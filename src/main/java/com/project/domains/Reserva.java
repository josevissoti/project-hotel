package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.enums.StatusPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_reserva")
    private Long idReserva;

    @NotNull
    private int quantidadePessoas;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal custoDiaria;

    @NotNull
    private int parcelas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;

    @ManyToOne
    @JoinColumn(name = "idquarto")
    private Quarto quarto;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "statusPagamento")
    private StatusPagamento statusPagamento;

    public Reserva() {
        this.statusPagamento = StatusPagamento.PAGANDO;
    }

    public Reserva(Long idReserva, int quantidadePessoas, BigDecimal custoDiaria, int parcelas, LocalDate dataEntrada, LocalDate dataSaida, Quarto quarto, StatusPagamento statusPagamento) {
        this.idReserva = idReserva;
        this.quantidadePessoas = quantidadePessoas;
        this.custoDiaria = custoDiaria;
        this.parcelas = parcelas;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
        this.statusPagamento = statusPagamento;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public BigDecimal getCustoDiaria() {
        return custoDiaria;
    }

    public void setCustoDiaria(BigDecimal custoDiaria) {
        this.custoDiaria = custoDiaria;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(idReserva, reserva.idReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idReserva);
    }
}
