package tech.zectrosan.xtendsearch.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.zectrosan.xtendsearch.server.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
