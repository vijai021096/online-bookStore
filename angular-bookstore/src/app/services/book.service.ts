import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Book } from '../common/book';
import { BookCategory } from '../common/book-category';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1/books";

  private categoryUrl = "http://localhost:8080/api/v1/book-category"

  constructor(private httpClient:HttpClient) { }
   
  
  getBooks(theCategroyId:number):Observable<Book[]>{
    const searchUrl=`${this.baseUrl}/search/categoryid?id=${theCategroyId}`;
    return this.newMethod(searchUrl);

  }
  private newMethod(searchUrl: string): Observable<Book[]> {
    return this.httpClient.get<GetResponseBooks>(searchUrl).pipe(map(response => response._embedded.books));
  }

  getBookCategories():Observable<BookCategory[]>{
    return this.httpClient.get<GetResponseBookCategory>(this.categoryUrl).pipe(map(response =>response._embedded.bookCategory));
  }
  searchBooks(keyword:string):Observable<Book[]>{
    const searchUrl=`${this.baseUrl}/search/searchByKeyword?name=${keyword}`;
    return this.newMethod(searchUrl);
  }
    getBookDetails(bookid:number):Observable<Book>{

    const bookDetailsUrl=`${this.baseUrl}/${bookid}`;
    return this.httpClient.get<Book>(bookDetailsUrl);
  
  }
}



  interface GetResponseBooks{
    _embedded : {
      books : Book[];

  }
}

  interface GetResponseBookCategory{
    _embedded : {
      bookCategory : BookCategory[];

  }
}