package lindsay.devon.screwup.web;

import lindsay.devon.screwup.Repository.ExpenseRepository;
import lindsay.devon.screwup.Repository.UserRepository;
import lindsay.devon.screwup.domain.Expense;
import lindsay.devon.screwup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by devon on 11/3/16.
 */
@RestController
@CrossOrigin
public class ExpenseController {

    private final String VIEW_EXPENSE = "expense";

    @Autowired
    ExpenseRepository expenseRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/expense", method = RequestMethod.GET)
    public Iterable<Expense> getAllExpenses() {
       return expenseRepo.findAll();
    }

    @RequestMapping(value = "/expense/{username}", method = RequestMethod.GET)
    public Iterable<Expense> getUserExpenses(@PathVariable String username) {
        User user = userRepo.findByUsername(username);
       return expenseRepo.findByUser(user);
    }

    @RequestMapping(value= "/expense/{username}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Expense addExpense(@PathVariable String username, @RequestBody Expense expense) {
        User user = userRepo.findByUsername(username);
        expense.setUser(user);
        expense.setCost(expense.getCost());
        expense.setName(expense.getName());
        user.addExpenseToBillTotal(expense.getCost());
        expenseRepo.saveAndFlush(expense);
        System.out.println(expense);
        return expense;
    }


    @RequestMapping(value ="/expense/{username}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Expense editExpense(@PathVariable String username,@RequestBody Expense expense) {
        User user = userRepo.findByUsername(username);
        expense.setUser(user);
        Expense temp = expenseRepo.findByName(expense.getName());
        user.subtractExpenseFromBillTotal(temp.getCost());
        temp.setCost(expense.getCost());
        user.addExpenseToBillTotal(expense.getCost());
        expenseRepo.saveAndFlush(temp);
        return temp;
    }

    @RequestMapping(value = "/expense/{username}", method = RequestMethod.DELETE)
    public @ResponseBody Expense deleteExpense(@PathVariable String username, @RequestBody Expense expense) {
        Expense temp = expenseRepo.findByName(expense.getName());
        expenseRepo.delete(temp);
        return  expense;
    }
}
