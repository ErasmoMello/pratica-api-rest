package com.example.demopraticarest.model;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;        
    private String responsavel;   
    private String dataEntrega;   

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    // hashCode e equals

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefa, responsavel, dataEntrega);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tarefas other = (Tarefas) obj;
        return Objects.equals(id, other.id) &&
               Objects.equals(tarefa, other.tarefa) &&
               Objects.equals(responsavel, other.responsavel) &&
               Objects.equals(dataEntrega, other.dataEntrega);
    }

    // toString

    @Override
    public String toString() {
        return "Tarefas [id=" + id + ", tarefa=" + tarefa + ", responsavel=" + responsavel + ", dataEntrega=" + dataEntrega + "]";
    }
}