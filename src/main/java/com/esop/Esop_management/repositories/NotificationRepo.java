package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {

    Optional<Notification> findById(Integer id);

}
