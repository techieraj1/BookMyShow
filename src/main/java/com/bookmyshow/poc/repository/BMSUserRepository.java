package com.bookmyshow.poc.repository;

import com.bookmyshow.poc.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMSUserRepository extends JpaRepository<UserDetails,Long> {
}
