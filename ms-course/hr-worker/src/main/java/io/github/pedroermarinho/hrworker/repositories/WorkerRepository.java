package io.github.pedroermarinho.hrworker.repositories;

import io.github.pedroermarinho.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
