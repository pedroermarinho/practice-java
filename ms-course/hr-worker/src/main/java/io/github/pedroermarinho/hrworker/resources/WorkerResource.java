package io.github.pedroermarinho.hrworker.resources;

import io.github.pedroermarinho.hrworker.entities.Worker;
import io.github.pedroermarinho.hrworker.repositories.WorkerRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private final WorkerRepository workerRepository;

    public WorkerResource(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Worker obj = workerRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
