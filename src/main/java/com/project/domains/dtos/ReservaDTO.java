package com.project.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.Reserva;
import com.project.domains.enums.StatusPagamento;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaDTO {

    private Long idReserva;

    @NotNull(message = "O campo codigoBarras não pode ser nulo")
    @NotBlank(message = "O campo codigoBarras não pode ser vazio")
    private String codigoBarras;

    @NotNull(message = "O campo quantidadePessoas não pode ser nulo")
    private int quantidadePessoas;

    @NotNull(message = "O campo curtoDiaria não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal curtoDiaria;

    @NotNull(message = "O campo parcelas não pode ser nulo")
    private int parcelas;

    @NotNull(message = "O campo dataEntrada não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;

    @NotNull(message = "O campo dataSaida não pode ser nulo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;

    private int statusPagamento;

    @NotNull(message = "O campo quarto é requerido")
    private int quarto;
    private int capacidadeMaxima;
    private String andar;
    private String bloco;
    private String quantidadeBlocos;

    public ReservaDTO() {
    }

    public ReservaDTO(Reserva reserva) {
        this.idReserva = reserva.getIdReserva();
        this.codigoBarras = reserva.getCodigoBarras();
        this.quantidadePessoas = reserva.getQuantidadePessoas();
        this.curtoDiaria = reserva.getCustoDiaria();
        this.parcelas = reserva.getParcelas();
        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.statusPagamento = reserva.getStatusPagamento().getId();
        this.quarto = reserva.getQuarto().getIdQuarto();
        this.capacidadeMaxima = reserva.getQuarto().getCapacidadeMaxima();
        this.andar = reserva.getQuarto().getAndar();
        this.bloco = reserva.getQuarto().getBloco();
        this.quantidadeBlocos = reserva.getQuarto().getQuantidadeComodos();
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public BigDecimal getCurtoDiaria() {
        return curtoDiaria;
    }

    public void setCurtoDiaria(BigDecimal curtoDiaria) {
        this.curtoDiaria = curtoDiaria;
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

    public int getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(int statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getQuantidadeBlocos() {
        return quantidadeBlocos;
    }

    public void setQuantidadeBlocos(String quantidadeBlocos) {
        this.quantidadeBlocos = quantidadeBlocos;
    }
}
