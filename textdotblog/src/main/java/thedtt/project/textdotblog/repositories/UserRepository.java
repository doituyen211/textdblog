package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}