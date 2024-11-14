package thedtt.project.textdotblog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Value
public class DotDto implements Serializable {
    Integer id;
    @NotNull
    String dotType;
    @NotNull
    String inputText;
    String outputText;
    String status;
    Instant createdAt;
    Instant completedAt;
}