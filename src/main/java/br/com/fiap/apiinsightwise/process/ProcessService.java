package br.com.fiap.apiinsightwise.process;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;
    private final ChatClient chatClient;

    public ProcessService(ProcessRepository processRepository, ChatClient.Builder chatClientBuilder) {
        this.processRepository = processRepository;
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Você vai receber desrições de processos (i.e. processo de cadastro de usuário,
                        processo de modificação de dados de usuário, etc) e deverá melhorar essas descrições
                        escrevendo-as de forma mais clara e objetiva e não podendo passar de 255 caracteres.
                        """)
                .build();
    }

    public Process create(Process process) {
        try {
            // Send the process description to the AI and get the modified response
            String modifiedDescription = sentToAi(process.getProcess());
            process.setProcess(modifiedDescription);
        } catch (Exception e) {
            // Log the error and save the original process description
            System.err.println("Error generating process with AI: " + e.getMessage());
        }
        return processRepository.save(process);
    }

    public Page<Process> findAllByUserEmail(String email, Pageable pageable) {
        return processRepository.findAllByUserEmail(email, pageable);
    }

    public String sentToAi(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}