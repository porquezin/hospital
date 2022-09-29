package com.hospital.Models;

public class Consulta {
    private int IdConsulta;
    private int IdMedico;
    private int IdPaciente;
    private String descricao;
    public Consulta(int idConsulta, int idMedico, int idPaciente, String descricao) {
        IdConsulta = idConsulta;
        IdMedico = idMedico;
        IdPaciente = idPaciente;
        this.descricao = descricao;
    }
    public int getIdConsulta() {
        return IdConsulta;
    }
    public void setIdConsulta(int idConsulta) {
        IdConsulta = idConsulta;
    }
    public int getIdMedico() {
        return IdMedico;
    }
    public void setIdMedico(int idMedico) {
        IdMedico = idMedico;
    }
    public int getIdPaciente() {
        return IdPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        IdPaciente = idPaciente;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
