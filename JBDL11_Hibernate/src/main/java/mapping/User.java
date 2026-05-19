package mapping;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    int id;
    String name;
    String email;
  //  @OneToOne(cascade = CascadeType.ALL)
   // Laptop laptop;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lid")
    List<Laptop> laptop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }
}
