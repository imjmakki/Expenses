import { Component, OnInit } from '@angular/core';
import {ExpenseService} from "../../services/expense.service";
import {Expense} from "../../models/expense";

@Component({
  selector: 'app-list-expense',
  templateUrl: './list-expense.component.html',
  styleUrls: ['./list-expense.component.css']
})
export class ListExpenseComponent implements OnInit {

  expenses: Expense[] = [];

  filters = {
    keyword: '',
    sortBy: 'Name'
  }

  constructor(private _expenseService: ExpenseService) { }

  ngOnInit(): void {
    this.listExpenses();
  }

  deleteExpense(id: number) {
    this._expenseService.deleteExpense(id).subscribe(
      data => {
        console.log('data deleted', data);
        this.listExpenses();
      }
    )
  }

  listExpenses() {
    this._expenseService.getExpenses().subscribe(
      data => this.expenses = this.filterExpenses(data)
    )
  }

  // @ts-ignore
  filterExpenses(expenses: Expense[]) {
    // @ts-ignore
    return expenses.filter((e) => {
      // @ts-ignore
      return e.expense.toLowerCase().includes(this.filters.keyword.toLowerCase());
      // @ts-ignore
    }).sort((a, b) => {
      if (this.filters.sortBy === 'Name') {
        // @ts-ignore
        return a.expense?.toLowerCase() < b.expense?.toLowerCase() ? -1: 1;
      }else if (this.filters.sortBy === 'Amount') {
        // @ts-ignore
        return a.amount > a.amount ? -1: 1;
      }
    })
  }

}
