package br.com.fiap.apiinsightwise.process;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

        private final ProcessRepository processRepository;

        public ProcessService(ProcessRepository processRepository) {
            this.processRepository = processRepository;
        }

        public Page<Process> findAll(Pageable pageable) {
            return processRepository.findAll(pageable);
        }

        public Process create(Process process) {
            return processRepository.save(process);
        }
}
