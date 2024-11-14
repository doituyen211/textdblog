package thedtt.project.textdotblog.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Value
public class UserPlanSubscriptionDto implements Serializable {
    Integer id;
    Instant startDate;
    Instant endDate;
    Boolean isActive;
    Integer remainingPosts;
    Instant renewalDate;
}