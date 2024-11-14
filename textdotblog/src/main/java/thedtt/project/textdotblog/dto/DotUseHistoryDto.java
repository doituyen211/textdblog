package thedtt.project.textdotblog.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Value
public class DotUseHistoryDto implements Serializable {
    Integer id;
    Instant timestamp;
}