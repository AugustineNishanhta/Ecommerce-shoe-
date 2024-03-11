package shoeshop.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shoeshop.Ecommerce.Model.AddProduct;

@Repository
public interface CartRepository extends JpaRepository <AddProduct , Long > {

}
