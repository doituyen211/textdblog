package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.DotUseHistory;

public interface DotUseHistoryRepository extends JpaRepository<DotUseHistory, Integer> {
}