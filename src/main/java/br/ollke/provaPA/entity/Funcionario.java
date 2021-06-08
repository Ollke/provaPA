package br.ollke.provaPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
    
    @Id
    Long matricula;

    @Column
    String nome;
    
    @Column
    String email;
    
    @Column
    String dataDeCadatro;

    public String getDataDeCadatro() {
        return dataDeCadatro;
    }
    public String getEmail() {
        return email;
    }
    public Long getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setDataDeCadatro(String dataDeCadatro) {
        this.dataDeCadatro = dataDeCadatro;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
