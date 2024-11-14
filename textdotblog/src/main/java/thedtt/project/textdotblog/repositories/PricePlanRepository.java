package thedtt.project.textdotblog.repositories;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thedtt.project.textdotblog.model.PricePlan;

import java.util.Optional;

@Repository
public interface PricePlanRepository extends JpaRepository<PricePlan, Integer> {

    Optional<PricePlan> findPricePlanByPlanName(@Size(max = 50) @NotNull String planName);

}