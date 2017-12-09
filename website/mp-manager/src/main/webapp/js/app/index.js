'use strict';
(function (root) {
    require(["./config"], function (config) {
        requirejs.config(config);
        require(["jquery18", "supersized", 'domReady!'], function () {
            var getRootPath_dc = function () {
                var pathName = window.location.pathname.substring(1);
                var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
                if (webName == "") {
                    return window.location.protocol + '//' + window.location.host;
                }
                else {
                    return window.location.protocol + '//' + window.location.host + '/' + webName;
                }
            };
            jQuery(function ($) {
                $.supersized({
                    // Functionality
                    slide_interval: 4000,    // Length between transitions
                    transition: 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
                    transition_speed: 1000,    // Speed of transition
                    performance: 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

                    // Size & Position
                    min_width: 0,    // Min width allowed (in pixels)
                    min_height: 0,    // Min height allowed (in pixels)
                    vertical_center: 1,    // Vertically center background
                    horizontal_center: 1,    // Horizontally center background
                    fit_always: 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
                    fit_portrait: 1,    // Portrait images will not exceed browser height
                    fit_landscape: 0,    // Landscape images will not exceed browser width

                    // Components
                    slide_links: 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
                    slides: [    // Slideshow Images
                        {image: 'img/index/backgrounds/1.jpg'},
                        {image: 'img/index/backgrounds/2.jpg'},
                        {image: 'img/index/backgrounds/3.jpg'}
                    ]
                });
            });
            jQuery(document).ready(function () {
                var hostServerUrl = "http://localhost:8050/oauth/token";
                $('.Bluebutton').click(function () {
                    window.location.href = "registor.html";
                    //self.location='jb51.htm';
                    //window.navigator="registor.html";
                });
                $('.Redbutton').click(function () {
                    var username = $(this).find('.username').val();
                    var password = $(this).find('.password').val();
                    if (username == '') {
                        $(this).find('.error').fadeOut('fast', function () {
                            $(this).css('top', '27px');
                        });
                        $(this).find('.error').fadeIn('fast', function () {
                            $(this).parent().find('.username').focus();
                        });
                        return false;
                    }
                    if (password == '') {
                        $(this).find('.error').fadeOut('fast', function () {
                            $(this).css('top', '96px');
                        });
                        $(this).find('.error').fadeIn('fast', function () {
                            $(this).parent().find('.password').focus();
                        });
                        return false;
                    }
                    $('.page-container form .username, .page-container form .password').keyup(function () {
                        $(this).parent().find('.error').fadeOut('fast');
                    });
                    $.ajax({
                        type: "POST",
                        url: hostServerUrl,
                        data: JSON.stringify({
                            "userName": $('.username').val(),
                            "password": $('.password').val()
                        }),
                        dataType: 'json',
                        contentType: 'application/json;charset=utf-8',
                        success: function (reslut) {
                            $.ajax({
                                type: "POST",
                                url: getRootPath_dc()+"/login.do",
                                beforeSend: function(request) {
                                    request.setRequestHeader("Authorization", reslut.data.token_type+" "+reslut.data.access_token);
                                },
                                success:function(data,status,xhr){
                                    var auth=xhr.getResponseHeader("Authorization");
                                    if(auth){
                                        window.location.href=getRootPath_dc()+data;
                                    }
                                },
                                contentType: 'application/json;charset=utf-8',
                            });
                            console.log(reslut);
                        }
                    });
                });
            });
        });
    });
})(this);