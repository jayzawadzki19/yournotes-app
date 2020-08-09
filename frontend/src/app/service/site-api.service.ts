import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Notebook} from "../notes/model/notebook";
import {Note} from "../notes/model/note";

@Injectable({
  providedIn: 'root'
})
export class SiteApiService {
  private BASE_URL = "http://localhost:8080/api"
  private ALL_NOTEBOOKS_URL = `${this.BASE_URL}/notebooks/all`;
  private SAVE_UPDATE_NOTEBOOK = `${this.BASE_URL}/notebooks/addNotebook`;
  private DELETE_NOTEBOOK = `${this.BASE_URL}/notebooks/`;
  private DELETE_NOTE = `${this.BASE_URL}/notes/`;
  private ALL_NOTES_URL = `${this.BASE_URL}/notes/all`;
  private NOTES_BY_NOTEBOOK = `${this.BASE_URL}/notes/byNotebook/`;
  private SAVE_NOTE = `${this.BASE_URL}/notes/addNote`;

  constructor(private http: HttpClient) {

  }

  getAllNotebooks() : Observable<Notebook[]>{
    return this.http.get<Notebook[]>(this.ALL_NOTEBOOKS_URL);
  }

  saveNotebook(notebook: Notebook): Observable<Notebook>{
    return this.http.post<Notebook>(this.SAVE_UPDATE_NOTEBOOK, notebook);
  }

  deleteNotebook(id: number):Observable<any>{
    return  this.http.delete(this.DELETE_NOTEBOOK + id)
  }

  deleteNote(id: bigint):Observable<any>{
    return  this.http.delete(this.DELETE_NOTE + id)
  }

  getAllNotes() : Observable<Note[]>{
    return this.http.get<Note[]>(this.ALL_NOTES_URL);
  }

  getNotesByNotebook(notebookId: number): Observable<Note[]>{
    return this.http.get<Note[]>(this.NOTES_BY_NOTEBOOK + notebookId);
  }

  saveNote(note: Note): Observable<Note>{
    return this.http.post<Note>(this.SAVE_NOTE, note);
  }

}
