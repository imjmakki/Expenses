import { Component, OnInit } from '@angular/core';
import {Expense} from "../../models/expense";
import {ExpenseService} from "../../services/expense.service";

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  expense: Expense = new Expense();

  constructor(private _expenseService: ExpenseService) { }

  ngOnInit(): void {
  }

  saveExpense() {
    this._expenseService.saveExpense(this.expense).subscribe(

    )
  }

}
