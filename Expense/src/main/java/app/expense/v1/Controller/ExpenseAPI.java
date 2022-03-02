package app.expense.v1.Controller;

import app.expense.v1.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExpenseAPI {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseAPI(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
}
