$(document).ready(function() {
  $(".nav li a").click(function() {
    $('.active').removeClass("active");
    $(this).parent().addClass("active");
  });
});