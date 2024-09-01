package br.com.fiap.apiinsightwise.track;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_iw_tracks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int clickCount;  // Number of clicks
    private double scrollPosition;  // Scroll position (could be float/double to handle varying scroll values)
    private long screenTime;  // Screen time in milliseconds
    private String currentPage;  // The page URL or identifier
}
