import {Notebook} from "./notebook";

export class Note {
  id:bigint;
  title:string;
  text:string;
  notebook:Notebook;
  modifiedOn:String;
}
