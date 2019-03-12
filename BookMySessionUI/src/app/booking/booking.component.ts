import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  constructor() { }  
  TotalRows:any=[];
  
  
  times:any=['12:00 AM','12:00 AM','12:00 AM','12:00 AM','12:00 AM','12:00 AM','12:00 AM','12:00 AM' ];
  ngOnInit() {
    this.TotalRows.length=20;
  }

}
