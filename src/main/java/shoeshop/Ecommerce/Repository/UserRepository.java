package shoeshop.Ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shoeshop.Ecommerce.Model.Userclass;

@Repository
public interface UserRepository extends JpaRepository<Userclass, Integer> {

    Optional<Userclass> findByUsername(String username);
    Optional <Userclass> findByPassword (String password);
}
