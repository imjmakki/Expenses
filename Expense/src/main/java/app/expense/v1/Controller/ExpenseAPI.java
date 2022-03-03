package app.expense.v1.Controller;

import app.expense.v1.Model.Expense;
import app.expense.v1.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExpenseAPI {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseAPI(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<>(expenses, OK);
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> save(@RequestBody Expense expense) {
        Expense newExpense = expenseService.save(expense);
        return new ResponseEntity<>(newExpense, OK);
    }
}
