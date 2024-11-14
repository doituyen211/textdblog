package thedtt.project.textdotblog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "dots")
public class Dot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dot_id", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "dot_type", nullable = false)
    private String dotType;

    @NotNull
    @Lob
    @Column(name = "input_text", nullable = false)
    private String inputText;

    @Lob
    @Column(name = "output_text")
    private String outputText;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "status")
    private String status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "completed_at")
    private Instant completedAt;

}