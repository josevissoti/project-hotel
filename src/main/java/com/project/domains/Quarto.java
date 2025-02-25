package com.project.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_quarto")
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
