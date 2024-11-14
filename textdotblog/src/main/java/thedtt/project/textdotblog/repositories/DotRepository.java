package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thedtt.project.textdotblog.model.Dot;


@Repository
public interface DotRepository extends JpaRepository<Dot, Integer> {

}