package lindsay.devon.screwup.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;

/**
 * Created by devon on 11/3/16.
 */
@Entity
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String name = "empty";
    private String cost = "empty";

    public Expense() {}

    public Expense(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expense: ");
        sb.append(name);
        sb.append("Cost: ");
        sb.append(cost);

        return sb.toString();

    }
}
