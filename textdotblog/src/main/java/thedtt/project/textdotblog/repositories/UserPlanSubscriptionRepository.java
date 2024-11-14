package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.UserPlanSubscription;

public interface UserPlanSubscriptionRepository extends JpaRepository<UserPlanSubscription, Integer> {
}