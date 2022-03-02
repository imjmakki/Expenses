package app.expense.v1.Repo;

import app.expense.v1.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repositor
public interface ExpensesDAO extends JpaRepository<Expense, Long> {
}
