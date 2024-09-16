package br.com.fiap.apiinsightwise.process;

import br.com.fiap.apiinsightwise.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_iw_processes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String process;
    LocalDateTime createdAt;

    @ManyToOne
    User user;
}