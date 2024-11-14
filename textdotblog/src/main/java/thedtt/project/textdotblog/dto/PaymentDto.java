package thedtt.project.textdotblog.dto;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Value
public class PaymentDto implements Serializable {
    Integer id;
    BigDecimal amount;
    @Size(max = 255)
    String cardType;
    Instant paymentDate;
    String paymentStatus;
}