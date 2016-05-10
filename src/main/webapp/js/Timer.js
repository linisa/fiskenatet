$(document).ready(function(){
  var timeLeft = 150;
  console.log("hej");

  setInterval(function () {
    timeLeft = timeLeft - 1;
    if (timeLeft >= 0) {
      document.getElementById("remainingTime").innerHTML = timeLeft + " sek";
    }else {
      document.getElementById("submit").click();
    }
  }, 1000);

});
