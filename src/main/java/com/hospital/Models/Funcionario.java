package com.hospital.Models;

public class Funcionario {
    private String nome;
    private String cargo;
    private String IdFuncionario;
    public Funcionario(String nome, String cargo, String idFuncionario) {
        this.nome = nome;
        this.cargo = cargo;
        IdFuncionario = idFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getIdFuncionario() {
        return IdFuncionario;
    }
    public void setIdFuncionario(String idFuncionario) {
        IdFuncionario = idFuncionario;
    }
}
