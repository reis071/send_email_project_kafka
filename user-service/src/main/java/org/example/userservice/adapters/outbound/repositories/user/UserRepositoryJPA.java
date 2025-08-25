package org.example.userservice.adapters.outbound.repositories.user;

import org.example.userservice.adapters.outbound.entities.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositoryJPA extends JpaRepository<UserModel, Long> {
}
