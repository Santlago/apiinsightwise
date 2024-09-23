package br.com.fiap.apiinsightwise.process;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, Long> {

    Page<Process> findAllByUserEmail(String email, Pageable pageable);
}
