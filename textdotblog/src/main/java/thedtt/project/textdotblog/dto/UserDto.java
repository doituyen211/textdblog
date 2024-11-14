package thedtt.project.textdotblog.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Value
public class UserDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 100)
    String username;
    @NotNull
    @Size(max = 100)
    String userEmail;
    @NotNull
    @Size(max = 255)
    String userPassword;
    Instant createdAt;
    Instant lastLogin;
}