package br.com.fiap.apiinsightwise.process;

import br.com.fiap.apiinsightwise.process.dto.ProcessFormRequest;
import br.com.fiap.apiinsightwise.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("process")
public class ProcessController {

        private final ProcessService processService;
    private final UserRepository userRepository;

    public ProcessController(ProcessService processService, UserRepository userRepository) {
            this.processService = processService;
        this.userRepository = userRepository;
    }

        @GetMapping
        public Page<Process> findAll(@PageableDefault(size = 5) Pageable pageable){
            var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            return processService.findAllByUserEmail(email, pageable);
        }


//        @GetMapping
//        public Page<Process> findAll(@PageableDefault(size = 5) Pageable pageable){
//            return processService.findAll(pageable);
//        }


        @PostMapping
        public Process create(@RequestBody ProcessFormRequest processFormRequest){
            var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            var user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));;
            var process = processFormRequest.toModel(user);
            return processService.create(process);
        }
}
