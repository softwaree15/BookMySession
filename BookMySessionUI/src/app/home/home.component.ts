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
    this.navigationScroll();
    this.scrollToSection();
    this.mobileHomeNavigationScroll();
    this.scrollSpyFun();
    this.storiesSlider();

    $(".Modern-Slider").slick({
      autoplay:true,
      autoplaySpeed:10000,
      arrows:false,
      speed:600,
      slidesToShow:1,
      slidesToScroll:1,
      pauseOnHover:false,
      dots:true,
      pauseOnDotsHover:true,
      cssEase:'linear'
     
    });
    
  }
  navigationScroll(){
    $(".bms-navigation li a").on("click", function (i) {
      i.preventDefault();
      var e = $(this);
      $("html, body").stop().animate({
        scrollTop: $(e.attr("href")).offset().top - 65
      }, 1e3)
    });
  }
  scrollToSection(){
    $(".bms-heroslider-scrolldown").on("click", function (i) {
      i.preventDefault();
      var e = $(this);
      $("html, body").stop().animate({
        scrollTop: $(e.attr("href")).offset().top - 65
      }, 1e3)
    });
  }
  mobileHomeNavigationScroll() {
    $("nav.bms-navigation").meanmenu({
      meanMenuContainer: ".bms-mobilenav",
      meanScreenWidth: "991",
      meanMenuOpen: '<i class="zmdi zmdi-menu"></i>',
      meanMenuClose: '<i class="zmdi zmdi-close"></i>'
    }), $(".bms-mobilenav nav.mean-nav li a").on("click", function (i) {
      i.preventDefault();
      var e = $(this);
      $("html, body").stop().animate({
        scrollTop: $(e.attr("href")).offset().top - 65
      }, 1e3)
    });
  }
  scrollSpyFun(){
    $(".bms-navigation").scrollspy({
      offset: -65,
      activeClass: "current",
      animate: "swing"
  });
  }
  storiesSlider(){
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
    });
  }

  swap_class(el, cls1, cls2) {
    console.log('swapping classes: ', cls1, cls2);
    $(el).addClass(cls1);
    $(el).removeClass(cls2);
  }
  
}
