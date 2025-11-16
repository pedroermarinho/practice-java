package org.example.rinhabackend2024q1springbootjpa.repositories;

import jakarta.persistence.LockModeType;
import org.example.rinhabackend2024q1springbootjpa.model.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaldoRepository  extends JpaRepository<Saldo, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Saldo s where s.id = :id")
    Optional<Saldo> findByIdForUpdate(Integer id);
}
