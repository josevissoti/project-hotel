package com.project.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.domains.dtos.ReservaDTO;
import com.project.domains.enums.StatusPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    @Column(unique = true)
    private String codigoBarras;

    @NotNull
    private int quantidadePessoas;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal custoDiaria;

    @NotNull
    private int parcelas;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;

    @NotNull
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

    public Reserva(Long idReserva, String codigoBarras, int quantidadePessoas, BigDecimal custoDiaria, int parcelas, LocalDate dataEntrada, LocalDate dataSaida, Quarto quarto, StatusPagamento statusPagamento) {
        this.idReserva = idReserva;
        this.codigoBarras = codigoBarras;
        this.quantidadePessoas = quantidadePessoas;
        this.custoDiaria = custoDiaria;
        this.parcelas = parcelas;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
        this.statusPagamento = statusPagamento;
    }

    public Reserva(ReservaDTO dto) {
        this.idReserva = dto.getIdReserva();
        this.codigoBarras = dto.getCodigoBarras();
        this.quantidadePessoas = dto.getQuantidadePessoas();
        this.custoDiaria = dto.getCurtoDiaria();
        this.parcelas = dto.getParcelas();
        this.dataEntrada = dto.getDataEntrada();
        this.dataSaida = dto.getDataSaida();
        this.statusPagamento = StatusPagamento.toEnum(dto.getStatusPagamento());

        this.quarto = new Quarto();
        this.quarto.setIdQuarto(dto.getQuarto());
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
