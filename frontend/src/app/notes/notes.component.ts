import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Notebook} from "./model/notebook";
import {SiteApiService} from "../service/site-api.service";
import {Note} from "./model/note";
import {log} from "util";
import {not} from "rxjs/internal-compatibility";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  notebooks: Notebook[] = [];
  notes: Note[] = [];
  selectedNotebook: Notebook;

  constructor(private apiService: SiteApiService) {
  }

  ngOnInit(): void {
    this.getAllNotebooks();
    this.getAllNotes();
  }

  public getAllNotebooks() {
    this.apiService.getAllNotebooks().subscribe(
      res => {
        this.notebooks = res
      },
      err => {
        alert("Error has occured")
      }
    );
  }

  getAllNotes(){
    this.selectedNotebook = null;
    this.apiService.getAllNotes().subscribe(
      res=>{
        this.notes = res;
      },
      err =>{
        alert("Error has occured");
      }
    )
  }

  createNotebook() {
    let newNotebook: Notebook = {
      name: "Template notebook",
      id: null
    };

    this.apiService.saveNotebook(newNotebook).subscribe(
      res => {
        newNotebook.id = res.id;
        this.notebooks.push(newNotebook)
      },
      err => {
        alert("Error has occured")
      }
    );

  }

  updateNotebook(notebook: Notebook) {
    this.apiService.saveNotebook(notebook).subscribe(
      res => {
      },
      err => {
        alert("Error has occured")
      }
    );
  }

  deleteNotebook(notebook: Notebook) {
    if (confirm("Do you want to delete this notebook")) {
      return this.apiService.deleteNotebook(notebook.id).subscribe(
        res=>{
          let indexOfNotebook = this.notebooks.indexOf(notebook);
          this.notebooks.splice(indexOfNotebook,1);
        },
        err =>{
          alert("Could not delete");
        }
      )
    }
  }

  deleteNote(note: Note) {
    if (confirm("Do you want to delete this note")) {
      return this.apiService.deleteNote(note.id).subscribe(
        res=>{
          let indexOfNote = this.notes.indexOf(note);
          this.notes.splice(indexOfNote,1);
        },
        err =>{
          alert("Could not delete");
        }
      )
    }
  }

  selectNotebook(notebook: Notebook) {
    this.selectedNotebook = notebook;
    this.apiService.getNotesByNotebook(notebook.id).subscribe(
      res=>{
        this.notes = res;
      },
      err =>{
        alert("Error");
      }
    );
  }

  createNote(notebook: Notebook) {
    let newNote:Note = {
      id: null,
      title: "Write title",
      text: "Write text",
      notebook: notebook,
      modifiedOn: null
    };

    this.apiService.saveNote(newNote).subscribe(
      res=>{
        newNote.id = res.id;
        this.notes.push(newNote);
      },
      err=>{
        alert("Error has occured")
      }
    );
  }

  updateNote(updadteNote: Note) {
    this.apiService.saveNote(updadteNote).subscribe(
      res=>{},
      err=>{
        alert("Error has occured")
      }
    );
  }
}

