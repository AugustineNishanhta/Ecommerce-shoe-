package shoeshop.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shoeshop.Ecommerce.Model.Shoe;

@Repository
public interface ShoeRepository extends JpaRepository <Shoe, Long  > {

}
