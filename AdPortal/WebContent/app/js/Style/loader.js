  $( document ).ready(function() {
        console.log( "document loaded" );
        $("#content").load("templates/blacklist.html");
    });
 
  
$( '.btn').click(function(){
    var page=$(this).attr("href");
            $("#content").load(page);

});