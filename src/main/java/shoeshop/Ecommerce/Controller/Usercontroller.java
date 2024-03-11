package shoeshop.Ecommerce.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import shoeshop.Ecommerce.Model.Userclass;
import shoeshop.Ecommerce.Repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("")
public class Usercontroller {

@Autowired(required = true)
    UserRepository Logincrud; 

    @GetMapping("/login")
    public String getMethodName(@RequestBody Userclass param) {
        Optional <Userclass> Username = Logincrud.findByUsername (param.getName());
        if (Username.isPresent()){
            Userclass object = Username.get();
            Optional <Userclass> Userpassword = Logincrud.findByPassword (param.getpassword());
            Userclass password = Userpassword.get();
            if(Userpassword.isPresent() && object.getId () == password.getId()){
                String output = "User is loggedin";
                return output; 
            }
            else {
              String output = "user password is incorrect";
              return output;
            }          
        }
        String output = "user name is incorrect";
        return output;
    }

    
}

