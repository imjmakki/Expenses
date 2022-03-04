package app.expense.v1.Service.Impl;

import app.expense.v1.Model.Expense;
import app.expense.v1.Repo.ExpenseDAO;
import app.expense.v1.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDAO expenseDAO;

    @Autowired
    public ExpenseServiceImpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @Override
    public List<Expense> findAll() {
        return expenseDAO.findAll();
    }

    @Override
    public Expense save(Expense expense) {
        expenseDAO.save(expense);
        return expense;
    }

    @Override
    public Expense findById(Long id) {
        if(expenseDAO.findById(id).isPresent()) {
            expenseDAO.findById(id).get();
        }
        return null;
    }
}
