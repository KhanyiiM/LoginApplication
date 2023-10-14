package javaApi.LoginApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javaApi.LoginApplication.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
 User findByEmail(String email);
    
}
