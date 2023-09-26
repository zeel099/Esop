package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.payload.NotificationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {

    Optional<Notification> findById(Integer id);
    List<Notification> findByCompany(Company company);

    //Notification findByEmpId(Integer id);

}
