package app.expense.v1.Service;

import app.expense.v1.Model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {

    List<Expense> findAll();
    Expense save(Expense expense);
}
