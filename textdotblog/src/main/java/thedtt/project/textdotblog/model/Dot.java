package thedtt.project.textdotblog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import thedtt.project.textdotblog.enums.DotStatus;
import thedtt.project.textdotblog.enums.DotType;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dots")
public class Dot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dot_id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dot_type")
    private DotType dotType;

    @NotNull
    @Lob
    @Column(name = "input_text", nullable = false)
    private String inputText;

    @Lob
    @Column(name = "output_text")
    private String outputText;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DotStatus status = DotStatus.PENDING;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "completed_at")
    private Instant completedAt;

    @OneToMany(mappedBy = "dot")
    private Set<DotUseHistory> dotUseHistories = new LinkedHashSet<>();

}