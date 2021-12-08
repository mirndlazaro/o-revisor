package com.example.orevisor.classes;

import java.util.Date;

public class RevisaoValue implements java.io.Serializable{

    private long id;
    private long idDisciplina;
    private long idAssunto;
    private String status;
    private Date dataCadastro;
    private Date ultimaRevisao;
    private int frequencia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDisciplina() {
        return id;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setIdAssunto(long idAssunto) {
        this.idAssunto = idAssunto;
    }

    public long getIdAssunto() {
        return idAssunto;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getUltimaRevisao() {
        return ultimaRevisao;
    }

    public void setUltimaRevisao(Date ultimaRevisao) {
        this.ultimaRevisao = ultimaRevisao;
    }
}