package com.project.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.domains.dtos.QuartoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_quarto")
    private Integer idQuarto;

    @NotNull
    private int capacidadeMaxima;

    @NotNull
    @NotBlank
    private String andar;

    @NotNull
    @NotBlank
    private String bloco;

    @NotNull
    @NotBlank
    private String quantidadeComodos;

    @JsonIgnore
    @OneToMany(mappedBy = "quarto")
    private List<Reserva> reservas = new ArrayList<>();

    public Quarto() {
    }

    public Quarto(Integer idQuarto, int capacidadeMaxima, String andar, String bloco, String quantidadeComodos) {
        this.idQuarto = idQuarto;
        this.capacidadeMaxima = capacidadeMaxima;
        this.andar = andar;
        this.bloco = bloco;
        this.quantidadeComodos = quantidadeComodos;
    }

    public Quarto(QuartoDTO dto) {
        this.idQuarto = dto.getIdQuarto();
        this.capacidadeMaxima = dto.getCapacidadeMaxima();
        this.andar = dto.getAndar();
        this.bloco = dto.getBloco();
        this.quantidadeComodos = dto.getQuantidadeComodos();
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
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

    public String getQuantidadeComodos() {
        return quantidadeComodos;
    }

    public void setQuantidadeComodos(String quantidadeComodos) {
        this.quantidadeComodos = quantidadeComodos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return Objects.equals(idQuarto, quarto.idQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idQuarto);
    }
}
