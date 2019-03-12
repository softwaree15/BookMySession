import { Component, AfterViewInit, OnInit, Injectable } from '@angular/core';
import '../assets/js/main.js';
declare var initz: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@Injectable()
export class AppComponent implements OnInit, AfterViewInit {

  title = 'BookMySession';

  ngAfterViewInit(): void {
    initz.init();
  }
  ngOnInit() {

  }

}
