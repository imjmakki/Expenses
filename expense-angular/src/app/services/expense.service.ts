import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Expense} from "../models/expense";

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private getUrl: string = "http://localhost:8080/api/expenses";

  constructor(private _httpClient: HttpClient) { }

  getExpenses(): Observable<Expense[]> {
    return this._httpClient.get<Expense[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

  saveExpense(expense: Expense): Observable<Expense> {
    return this._httpClient.post<Expense>(this.getUrl, expense);
  }
}
