package shoeshop.Ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Userclass {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private String username;

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    @Column
    private String password;

    public String getpassword() {
        return password;
    }

    public void setpassword(String email) {
        this.password = email;
    }

    // Getters and setters 
}

  



