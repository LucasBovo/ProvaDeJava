package com.provaPratica.demo.repository;

import com.provaPratica.demo.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}
