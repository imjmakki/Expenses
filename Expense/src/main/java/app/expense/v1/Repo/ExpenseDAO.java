package app.expense.v1.Repo;

import app.expense.v1.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDAO extends JpaRepository<Expense, Long> {
}
