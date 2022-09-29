package com.hospital.Models;

public class Medico {
    private int IdMedico;
    private String nome;
    private Long CRM;
    private String especialidade;
    public Medico(String nome, Long crm, String especialidade) {
        this.nome = nome;
        this.CRM = crm;
        this.especialidade = especialidade;
    }
    public int getIdMedico() {
        return IdMedico;
    }
    public void setIdMedico(int idMedico) {
        IdMedico = idMedico;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getCRM() {
        return CRM;
    }
    public void setCRM(Long CRM) {
        this.CRM = CRM;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
