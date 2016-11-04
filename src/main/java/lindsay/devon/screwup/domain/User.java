package lindsay.devon.screwup.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

/**
 * Created by devon on 11/2/16.
 */


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String monthlyNet;

    @OneToMany(targetEntity = Expense.class, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Expense> expenses;

    public User() {}



    public User(String username, String password, String monthlyNet) {
        this.username = username;
        this.password = password;
        this.monthlyNet = monthlyNet;
        this.expenses = new ArrayList<>();


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonthlyNet() {
        return monthlyNet;
    }

    public void setMonthlyNet(String monthlyNet) {
        this.monthlyNet = monthlyNet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ");
        sb.append(username);
        sb.append("Password: ");
        sb.append(password);
        return sb.toString();
    }

}
