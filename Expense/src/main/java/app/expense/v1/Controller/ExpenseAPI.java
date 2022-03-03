package app.expense.v1.Controller;

import app.expense.v1.Model.Expense;
import app.expense.v1.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ExpenseAPI {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseAPI(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> get() {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
    }
}
