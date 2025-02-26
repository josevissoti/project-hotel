package com.project.domains.dtos;

import com.project.domains.Quarto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuartoDTO {

    private Integer idQuarto;

    private int capacidadeMaxima;

    @NotNull(message = "O campo andar não pode ser nulo")
    @NotBlank(message = "O campo andar não pode estar vazio")
    private String andar;

    @NotNull(message = "O campo bloco não pode ser nulo")
    @NotBlank(message = "O campo bloco não pode estar vazio")
    private String bloco;

    @NotNull(message = "O campo quantidadeComodos não pode ser nulo")
    @NotBlank(message = "O campo quantidadeComodos não pode estar vazio")
    private String quantidadeComodos;

    public QuartoDTO() {
    }

    public QuartoDTO(Quarto quarto) {
        this.idQuarto = quarto.getIdQuarto();
        this.capacidadeMaxima = quarto.getCapacidadeMaxima();
        this.andar = quarto.getAndar();
        this.bloco = quarto.getBloco();
        this.quantidadeComodos = quarto.getQuantidadeComodos();
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
}
