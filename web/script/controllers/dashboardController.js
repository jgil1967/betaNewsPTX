
app.controller('dashboardController',['$scope','noticiasService',
    
    function ($scope,noticiasService)
    {
       
$scope.hello = function(){
 noticiasService.getNoticias().then(function(d) {
                   $scope.noticias = noticiasService.getList();
              
                });
             
};
$scope.hello();
setInterval(function() {
  $scope.hello();
}, 60000);
        


var colors = new Array(
  [0 ,22, 106],
 [0 ,78 ,100],
  [1 ,111 ,185],
  [53, 144 ,243],
  [6 ,174 ,213],
  [53 ,144 ,243]
          );

var step = 0;
//color table indices for: 
// current color left
// next color left
// current color right
// next color right
var colorIndices = [0,1,2,3];

//transition speed
var gradientSpeed = 0.0009;

function updateGradient()
{
  
  if ( $===undefined ) return;
  
var c0_0 = colors[colorIndices[0]];
var c0_1 = colors[colorIndices[1]];
var c1_0 = colors[colorIndices[2]];
var c1_1 = colors[colorIndices[3]];

var istep = 1 - step;
var r1 = Math.round(istep * c0_0[0] + step * c0_1[0]);
var g1 = Math.round(istep * c0_0[1] + step * c0_1[1]);
var b1 = Math.round(istep * c0_0[2] + step * c0_1[2]);
var color1 = "rgb("+r1+","+g1+","+b1+")";

var r2 = Math.round(istep * c1_0[0] + step * c1_1[0]);
var g2 = Math.round(istep * c1_0[1] + step * c1_1[1]);
var b2 = Math.round(istep * c1_0[2] + step * c1_1[2]);
var color2 = "rgb("+r2+","+g2+","+b2+")";
//
//$("html, body").animate({ scrollTop: $(document).height() }, 4000);
//setTimeout(function() {
//   $('html, body').animate({scrollTop:0}, 4000); 
//},4000);
//setInterval(function(){
//     // 4000 - it will take 4 secound in total from the top of the page to the bottom
//$("html, body").animate({ scrollTop: $(document).height() }, 4000);
//setTimeout(function() {
//   $('html, body').animate({scrollTop:0}, 4000); 
//},4000);
//    
//},8000);


 $('#gradient').css({
   background: "-webkit-gradient(linear, left top, right top, from("+color1+"), to("+color2+"))"}).css({
    background: "-moz-linear-gradient(left, "+color1+" 0%, "+color2+" 100%)"});
  
  step += gradientSpeed;
  if ( step >= 1 )
  {
    step %= 1;
    colorIndices[0] = colorIndices[1];
    colorIndices[2] = colorIndices[3];
    
    //pick two new target color indices
    //do not pick the same as the current one
    colorIndices[1] = ( colorIndices[1] + Math.floor( 1 + Math.random() * (colors.length - 1))) % colors.length;
    colorIndices[3] = ( colorIndices[3] + Math.floor( 1 + Math.random() * (colors.length - 1))) % colors.length;
    
  }
}

setInterval(updateGradient,10);

        }

]);