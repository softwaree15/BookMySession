var initz = (function () {
    return {
        init: function (t) {
            "use strict";
            jQuery.fn.exists = function () {
                return this.length > 0
            }, t(window).on("load", function () {
                t(".bms-preloader").delay(150).fadeOut("slow")
            });
            var i = new ScrollMagic.Controller,
                e = {
                    preloaderCancellation: function () {
                        t(".bms-preloader").find(".bms-button").on("click", function () {
                            t(this).parent(".bms-preloader").fadeOut("slow")
                        })
                    },
                    dataBgImage: function () {
                        t("[data-bgimage]").each(function () {
                            var i = t(this).data("bgimage");
                            t(this).css({
                                "background-image": "url(" + i + ")"
                            })
                        })
                    },
                    sliderActivation: {
                        teamMemberSlider: function () {
                            t(".bms-team-slider").slick({
                                infinite: !0,
                                autoplay: !0,
                                autoplaySpeed: 5e3,
                                slidesToShow: 4,
                                slidesToScroll: 1,
                                arrows: !0,
                                prevArrow: '<button class="bms-slider-arrow-prev"><i class="zmdi zmdi-long-arrow-left"></i></button>',
                                nextArrow: '<button class="bms-slider-arrow-next"><i class="zmdi zmdi-long-arrow-right"></i></button>',
                                dots: !1,
                                responsive: [{
                                    breakpoint: 1200,
                                    settings: {
                                        slidesToShow: 3,
                                        slidesToScroll: 1
                                    }
                                }, {
                                    breakpoint: 992,
                                    settings: {
                                        slidesToShow: 2,
                                        slidesToScroll: 1
                                    }
                                }, {
                                    breakpoint: 768,
                                    settings: {
                                        slidesToShow: 1,
                                        slidesToScroll: 1
                                    }
                                }]
                            })
                        },
                        storiesSlider: function () {
                            t(".bms-stories-slider").slick({
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
                        },
                        testimonialSlider: function () {
                            t(".bms-testimonial-contents").slick({
                                slidesToShow: 1,
                                slidesToScroll: 1,
                                fade: !0,
                                asNavFor: ".bms-testimonial-authors",
                                autoplay: !0,
                                arrows: !0,
                                prevArrow: '<button class="bms-slider-arrow-prev"><i class="zmdi zmdi-long-arrow-left"></i></button>',
                                nextArrow: '<button class="bms-slider-arrow-next"><i class="zmdi zmdi-long-arrow-right"></i></button>'
                            }), t(".bms-testimonial-authors").slick({
                                slidesToShow: 3,
                                slidesToScroll: 1,
                                asNavFor: ".bms-testimonial-contents",
                                dots: !1,
                                centerMode: !0,
                                centerPadding: 0,
                                focusOnSelect: !0,
                                autoplay: !0
                            })
                        },
                        init: function () {
                             e.sliderActivation.teamMemberSlider(), e.sliderActivation.storiesSlider(), e.sliderActivation.testimonialSlider()
                        }
                    },
                    counterupActivation: function () {
                        t(".odometer").length && t(window).on("scroll", function () {
                            function i() {
                                var i = t(window).scrollTop(),
                                    e = t(window).height(),
                                    o = Math.round(i + e / 1.2);
                                return o
                            }
                            var e = t(".odometer").offset().top;
                            e < i() && t(".odometer").each(function () {
                                t(this).html(t(this).data("count-to"))
                            })
                        })
                    },
                    funfactMasonryActive: function () {
                        t(".bms-funfact-wrapper").masonry({
                            itemSelector: ".bms-funfact-masonryitem",
                            columnWidth: 1
                        })
                    },
                    dynamicPricebox: function () {
                        function i() {
                            return t(".bms-pricebox-switchbuttons").find("button").on("click", function () {
                                t(this).addClass("is-active").siblings("button").removeClass("is-active")
                            }), t(".bms-pricebox-switchbuttons").find("button.is-active").data("keyvalue")
                        }

                        function e() {
                            t(".bms-pricebox-price-digit").each(function () {
                                var e = t(this).data("pricebox-price-monthly"),
                                    o = t(this).data("pricebox-price-yearly");
                                "monthly" === i() ? t(this).text(e) : t(this).text(o)
                            })
                        }

                        function o() {
                            t(".bms-pricebox-price-time").each(function () {
                                var e = t(this).data("monthly-text"),
                                    o = t(this).data("yearly-text");
                                "monthly" === i() ? t(this).text(e) : t(this).text(o)
                            })
                        }
                        e(), o(), t(".bms-pricebox-switchbuttons").find("button").on("click", function () {
                            e(), o()
                        })
                    },
                    contactFormEffect: function () {
                        t(".bms-form-field").on("focus", "input, textarea", function () {
                            t(this).siblings(".bms-form-animatedline").css("width", "100%")
                        }), t(".bms-form-field").on("focusout", "input, textarea", function () {
                            t(this).siblings(".bms-form-animatedline").css("width", 0);
                            var i = t(this);
                            0 !== i.val().trim().length && t(this).siblings(".bms-form-animatedline").css("width", "100%")
                        })
                    },
                    scrollToSection: function () {
                        t(".bms-heroslider-scrolldown").on("click", function (i) {
                            i.preventDefault();
                            var e = t(this);
                            t("html, body").stop().animate({
                                scrollTop: t(e.attr("href")).offset().top - 65
                            }, 1e3)
                        })
                    },
                    stickyHeaderActive: function () {
                        t(window).on("scroll", function () {
                            t(this).scrollTop() >= 1 ? t(".bms-sticky-header").addClass("is-sticky") : t(".bms-sticky-header").removeClass("is-sticky")
                        })
                    },
                    meanmenuActive: function () {
                        t("nav.bms-navigation").meanmenu({
                            meanMenuContainer: ".bms-mobilenav",
                            meanScreenWidth: "991",
                            meanMenuOpen: '<i class="zmdi zmdi-menu"></i>',
                            meanMenuClose: '<i class="zmdi zmdi-close"></i>'
                        }), t(".bms-mobilenav nav.mean-nav li a").on("click", function (i) {
                            i.preventDefault();
                            var e = t(this);
                            t("html, body").stop().animate({
                                scrollTop: t(e.attr("href")).offset().top - 65
                            }, 1e3)
                        })
                    },
                    breadcrumbPadding: function () {
                        if (t(".bms-header-fixed").exists()) {
                            var i = t(".bms-header-fixed").innerHeight();
                            t(".bms-breadcrumb").css({
                                paddingTop: i + "px"
                            })
                        }
                    },
                    scrollSpyActive: function () {
                        t(".bms-navigation").scrollspy({
                            offset: -65,
                            activeClass: "current",
                            animate: "swing"
                        })
                    },
                    fancyboxInit: function () {
                        t("[data-fancybox]").fancybox()
                    },
                    ajaxMailchimp: function () {
                        function i(i) {
                            "success" === i.result ? (t(".bms-mailchimp-success").html("" + i.msg).fadeIn(900), t(".bms-mailchimp-error").fadeOut(400)) : "error" === i.result && t(".bms-mailchimp-error").html("" + i.msg).fadeIn(900)
                        }
                        t("#bms-mailchimp-form").ajaxChimp({
                            language: "en",
                            callback: i,
                            url: "YOUR_MAILCHIMP_URL_HERE"
                        })
                    },
                    scrollUpActive: function () {
                        t('<button id="scrollUp"><i class="zmdi zmdi-chevron-up"></i></button>').appendTo("body"), t(window).on("scroll", function () {
                            var i = t(this).height(),
                                e = t(this).scrollTop();
                            e > i + 100 ? t("#scrollUp").addClass("is-visible") : t("#scrollUp").removeClass("is-visible")
                        }), t("#scrollUp").on("click", function () {
                            return t("html, body").animate({
                                scrollTop: 0
                            }, "slow"), !1
                        })
                    },
                    easeScrollActive: function () {
                        t("html").easeScroll()
                    },
                    herosliderScrollMagic: function () {
                        var e = t(window).width();
                        e >= 992 && (new ScrollMagic.Scene({
                            duration: 0,
                            offset: 0
                        }).setPin(".bms-heroslider-inner", {
                            pushFollowers: !1
                        }).addTo(i), t(window).on("scroll", function () {
                            var i = t(this).scrollTop(),
                                e = 1 - i / 750;
                            t(".bms-heroslider-content, .bms-heroslider-mobileshow ").css({
                                opacity: e
                            })
                        }))
                    },
                    storiesMasonryActive: function () {
                        t(".stories-masonry-active").masonry({
                            itemSelector: ".stories-masonry-item"
                        })
                    },
                    ajaxMailer: function () {
                        var i = t("#bms-contactform"),
                            e = t(".form-messages");
                        t(i).submit(function (o) {
                            o.preventDefault();
                            var n = t(i).serialize();
                            t.ajax({
                                type: "POST",
                                url: t(i).attr("action"),
                                data: n
                            }).done(function (i) {
                                t(e).removeClass("error"), t(e).addClass("success"), t(e).text(i), t('#bms-contactform input:not([type="submit"]), #bms-contactform textarea').val("")
                            }).fail(function (i) {
                                t(e).removeClass("success"), t(e).addClass("error"), "" !== i.responseText ? t(e).text(i.responseText) : t(e).text("Oops! An error occured and your message could not be sent.")
                            })
                        })
                    },
                    serviceImageAnim: function () {
                        setInterval(function () {
                            t(".bms-service-image-1").toggleClass("is-visible"), t(".bms-service-image-2").toggleClass("is-visible")
                        }, 5e3)
                    },
                    init: function () {
                        e.preloaderCancellation(), e.dataBgImage(), e.sliderActivation.init(), e.counterupActivation(), e.funfactMasonryActive(), e.dynamicPricebox(), e.contactFormEffect(), e.scrollToSection(), e.stickyHeaderActive(), e.meanmenuActive(), e.breadcrumbPadding(), e.scrollSpyActive(), e.fancyboxInit(), e.ajaxMailchimp(), e.scrollUpActive(), e.easeScrollActive(), e.herosliderScrollMagic(), e.storiesMasonryActive(), e.ajaxMailer(), e.serviceImageAnim()
                    }
                };
            e.init()
        }(jQuery)
    }
})(initz || {});