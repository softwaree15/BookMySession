import { Component, OnInit } from '@angular/core';
declare var document, $;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(".bms-stories-slider").slick({
      infinite: !0,
      autoplay: !1,
      autoplaySpeed: 5e3,
      slidesToShow: 4,
      slidesToScroll: 1,
      centerMode: !0,
      centerPadding: "0",
      focusOnSelect: !0,
      arrows: !0,
      prevArrow: '<button class="bms-slider-arrow-prev"><i class="zmdi zmdi-long-arrow-left"></i></button>',
      nextArrow: '<button class="bms-slider-arrow-next"><i class="zmdi zmdi-long-arrow-right"></i></button>',
      dots: !1,
      responsive: [{
          breakpoint: 992,
          settings: {
              slidesToShow: 2,
              slidesToScroll: 1
          }
      }, {
          breakpoint: 768,
          settings: {
              slidesToShow: 1,
              slidesToScroll: 1,
              adaptiveHeight: !0
          }
      }]
  })
  }

}
