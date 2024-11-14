package thedtt.project.textdotblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thedtt.project.textdotblog.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}