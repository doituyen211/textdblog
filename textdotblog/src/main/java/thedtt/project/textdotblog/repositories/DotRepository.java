package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.Dot;

public interface DotRepository extends JpaRepository<Dot, Integer> {
}