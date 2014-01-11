$(document).ready(function() {
    var navBarElements = $('#jonrah-main-nav li');
    navBarElements.each(function(index, navBarElement) {
        var linkElement = $(navBarElement).children("").get(0);
        var linkHrefIsPound = $(linkElement).attr("href") === "#";
        if (!linkHrefIsPound && window.location.pathname.indexOf($(linkElement).attr("href")) === 0) {
            $(navBarElement).addClass("active");
        }
    });
});