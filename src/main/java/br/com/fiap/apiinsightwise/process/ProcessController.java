package br.com.fiap.apiinsightwise.process;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("process")
public class ProcessController {

        private final ProcessService processService;

        public ProcessController(ProcessService processService) {
            this.processService = processService;
        }

        @GetMapping
        public Page<Process> findAll(@PageableDefault(size = 5) Pageable pageable){
            return processService.findAll(pageable);
        }

        @PostMapping
        public Process create(@RequestBody Process process) {
            return processService.create(process);
        }
}
