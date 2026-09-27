package com.gustavo.sistemaFuncionario_estudo.validation;

public class ErroResponse {
    
    private int status;
    private String campo;
    private String mensagen;


    public ErroResponse(int status, String campo, String mensagen) {
        this.status = status;
        this.campo = campo;
        this.mensagen = mensagen;
    }

    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getCampo() {
        return campo;
    }
    public void setCampo(String campo) {
        this.campo = campo;
    }
    public String getMensagen() {
        return mensagen;
    }
    public void setMensagen(String mensagen) {
        this.mensagen = mensagen;
    }

    
}
