package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.PricePlan;

public interface PricePlanRepository extends JpaRepository<PricePlan, Integer> {
}