package kr.co.ch06.repository;

import kr.co.ch06.entity.User5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User5Repository extends JpaRepository<User5, String> {
}
