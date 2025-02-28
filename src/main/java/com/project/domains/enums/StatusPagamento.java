package com.project.domains.enums;

public enum StatusPagamento {
    PAGO(0, "PAGO"), PAGANDO(1, "PAGANDO"), ATRASADO(2, "ATRASADO");

    private Integer id;
    private String status;

    StatusPagamento(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static StatusPagamento toEnum(Integer id){
        if(id==null) return null;
        for(StatusPagamento statusPagamento : StatusPagamento.values()){
            if(id.equals(statusPagamento.getId())){
                return statusPagamento;
            }
        }
        throw new IllegalArgumentException("Status de Pagamento inválido");
    }
}
