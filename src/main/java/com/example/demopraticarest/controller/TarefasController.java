package com.example.demopraticarest.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demopraticarest.model.Tarefas;
import com.example.demopraticarest.repository.TarefasRepository;


@RestController
@RequestMapping({ "/tarefas" })
public class TarefasController {
    private final TarefasRepository repository;

    public TarefasController(TarefasRepository tarefasRepository) {
        this.repository = tarefasRepository;
    }

    @GetMapping
    public List<Tarefas> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Tarefas> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefas create(@RequestBody Tarefas tarefa) {
        return repository.save(tarefa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefas> update(@PathVariable("id") long id, @RequestBody Tarefas tarefa) {
        return repository.findById(id).map(record -> {
            record.setTarefa(tarefa.getTarefa());
            record.setResponsavel(tarefa.getResponsavel());
            record.setDataEntrega(tarefa.getDataEntrega());
            Tarefas updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
