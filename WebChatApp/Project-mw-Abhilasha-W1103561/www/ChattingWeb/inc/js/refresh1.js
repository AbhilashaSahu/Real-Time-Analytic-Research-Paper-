$.ajaxSetup ({
	cache: false	//use for i.e browser to clean cache
});
$(setInterval(function(){
	$('.refresh1').load('view1.php'); //this means that the items loaded by display.php will be prompted into the class refresh 
	$('.refresh1').attr({ scrollTop: $('.refresh1').attr('scrollHeight') }) //if the messages overflowed this line tells the textarea to focus the latest message	
}, 3000));