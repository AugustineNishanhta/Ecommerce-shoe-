package shoeshop.Ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoeshop.Ecommerce.Model.AddProduct;
import shoeshop.Ecommerce.Model.Shoe;
import shoeshop.Ecommerce.Repository.CartRepository;
import shoeshop.Ecommerce.Repository.ShoeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@CrossOrigin
@RequestMapping("api")
public class ShoeController {

    @Autowired
    ShoeRepository Productshoe ;
    CartRepository addProductRepository;


 
     @GetMapping                        // to get entire list of shoe
     @Transactional
     public List<Shoe> getShoesWithSizes() {
         List<Shoe> shoes = Productshoe.findAll();
         shoes.forEach(shoe -> shoe.getSizes().size()); // Access sizes to initialize the proxy
         return shoes;
     }

    
     @Transactional
     @GetMapping("/{id}")
     public ResponseEntity<Shoe> getUserById(@PathVariable Long id) {
         @SuppressWarnings("null")
        Optional<Shoe> optionalShoe = Productshoe.findById(id);
         if (optionalShoe.isPresent()) {
             Shoe shoe = optionalShoe.get();
             // Access the sizes collection to ensure it's loaded eagerly
             shoe.getSizes().size();
             return ResponseEntity.ok(shoe);
         } else {
             return ResponseEntity.notFound().build();
         }
     };


     
     @PostMapping ("/addTocard")                                                // to add tocart
     public ResponseEntity<String> addToCart(@RequestBody AddProduct tocart) {
         if(tocart.getName () == null || tocart.getQuantity() == null 
            || tocart.getBrandName() == null  || tocart.getSize()== null ){
             AddProduct addProduct = new AddProduct();
             addProductRepository.save(addProduct);
             return ResponseEntity.badRequest().body("full details needed");
         } else {     
             return ResponseEntity.ok("Product added to cart");
         }
     }


    // @SuppressWarnings("null")                            /I have used to add all product using this method
    // @PostMapping("/newproduct")
    // public ResponseEntity<String> createNewUser(@RequestBody Shoe newshoe) {
    //     Productshoe .save(newshoe);  
    //     return ResponseEntity.ok("User saved successfully");
         
    // }


}
