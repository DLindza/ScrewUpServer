package lindsay.devon.screwup.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
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
    private String monthlyNet = "0";


    @OneToMany(targetEntity = Expense.class, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Expense> expenses;

    private double monthlyNetExpenses = 0;
    private double billtotal = 0;
    private double billgoal = 0;
    private double monthlyremainder = 0;
    private double funmoney = 0;
    private double nestegg = 0;

    public User() {fillBudget();}

    public User(String username, String password, String monthlyNet) {
        this.username = username;
        this.password = password;
        this.monthlyNet = monthlyNet;
        this.expenses = new ArrayList<>();
        fillBudget();

    }


     public void fillBudget() {
        setMonthlyNetExpenses();
        findBillGoal();
        findMonthlyRemainder();
        findNestEgg();
        findFunMoney();

    }


    public double addExpenseToBillTotal (String cost) {
        billtotal += Integer.parseInt(cost);
        fillBudget();
        return billtotal;
    }

    public double subtractExpenseFromBillTotal (String cost){
        billtotal -= Integer.parseInt(cost);
        fillBudget();
        return billtotal;
    }


    public double setMonthlyNetExpenses() {
        this.monthlyNetExpenses = Double.parseDouble(monthlyNet);
        return this.monthlyNetExpenses;
    }

    public double findBillGoal() {
        this.billgoal = monthlyNetExpenses / 2;
        return this.billgoal;
    }

    public double findMonthlyRemainder() {
        monthlyremainder = monthlyNetExpenses - billtotal;
        return monthlyremainder;
    }

    public double findFunMoney() {
        funmoney = monthlyremainder * .20;
        return funmoney;
    }

    public double findNestEgg() {
        nestegg = monthlyremainder * .30;
        return nestegg;

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

    public double getMonthlyNetExpenses() {
        return monthlyNetExpenses;
    }

    public double getBilltotal() {
        return billtotal;
    }

    public double getBillgoal() {
        return billgoal;
    }

    public double getMonthlyremainder() {
        return monthlyremainder;
    }

    public double getFunmoney() {
        return funmoney;
    }

    public double getNestegg() {
        return nestegg;
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
