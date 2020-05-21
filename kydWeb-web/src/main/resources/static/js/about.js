var left;
var imgLeft;
$("#gather div:eq(0) span").click(function () {
    left= parseInt($(this).offset().left);
    imgLeft= parseInt($(".tle-img").offset().left);

    // if(imgLeft<left){
    $(".tle-img").css("left",(left-10));
    // }
})
$("#gather-1 div:eq(0) span").click(function () {
    left= parseInt($(this).offset().left);
    imgLeft= parseInt($(".tle-img-1").offset().left);

    $(".tle-img-1").css("left",(left-10));
    // }
})
var startx,starty,movex,movey,endx,endy,nx,ny,angle;
var carousel=$('.carousel');
//开始触摸函数，event为触摸对象
// function touchs(event){
//     alert(1);
//阻止浏览器默认滚动事件
// event.preventDefault();
// event.stopPropagation();
// event.returnValue = true;
//获取DOM标签
//通过if语句判断event.type执行了哪个触摸事件
// if(event.type=="touchstart"){

function touchSatrt(event) {
    // alert(event.src);
    // event.preventDefault();
    //  console.log('开始');
    //获取开始的位置数组的第一个触摸位置originalEvent.targetTouches
    // alert(event.target.html());


    var touch = event.touches[0];
    //获取第一个坐标的X轴
    startx = Math.floor(touch.pageX);
    //获取第一个坐标的X轴
    starty = Math.floor(touch.pageY);
}
//触摸中的坐标获取
// }
// else if(event.type=="touchmove")
// {
function touchMove(event) {

    // event.preventDefault();
    //  console.log('滑动中');
    var touch = event.touches[0];
    movex = Math.floor(touch.pageX);
    movey = Math.floor(touch.pageY);
}
//当手指离开屏幕或系统取消触摸事件的时候
// }else if(event.type == "touchend" || event.type == "touchcancel"){
function touchEnd(event) {
    event.preventDefault();
    //获取最后的坐标位置
    var touch = event.changedTouches[0];
    endx =  Math.floor(touch.pageX) ;
    endy = parseInt(Math.floor(touch.pageX));

    // //获取开始位置和离开位置的距离
    nx = endx - startx;
    ny = endy - starty;
    if(nx==0){
        if(index==0){
            window.location.href="/static/page/join/campus.html";
        }else if(index==1){
            window.location.href="/static/page/product/familye.html?id=1";
        }else if(index==2){
            window.location.href="/static/page/product/familye.html?id=2";
        }

    }
    if(nx>0&&nx<50 || nx<0&&nx>-50){

    } else{
        if ( nx > 0 ) {
            carousel.carousel('prev');
        }
        //右滑
        else if ( nx < 0 ) {
            carousel.carousel('next');
        }
    }
    //通过坐标计算角度公式 Math.atan2(y,x)*180/Math.PI
    // angle = Math.atan2(ny, nx) * 180 /  parseInt(Math.floor(Math.PI));
    // alert(angle)
    // if (Math.abs(nx) <= 1 || Math.abs(ny) <= 1) {
    //     // alert('滑动距离太小');
    // }else
    // //通过滑动的角度判断触摸的方向
    // if (angle < 55 && angle >= -60) {
    //
    //     carousel.carousel('prev');
    // } else if (angle < 135 && angle >= 45) {
    //
    // } else if ((angle <= 190 && angle >= 135) || (angle >= -190 && angle < -130)) {
    //     carousel.carousel('next');
    //
    // } else if (angle <= -45 && angle >= -135) {
    //
    // }
    // }
}
document.getElementById("carousel-example-generic").addEventListener('touchstart', touchSatrt,false);
document.getElementById("carousel-example-generic").addEventListener('touchmove', touchMove,false);
document.getElementById("carousel-example-generic").addEventListener('touchend', touchEnd,false);

document.getElementById("carousel-example-generica").addEventListener('touchstart', touchSatrt,false);
document.getElementById("carousel-example-generica").addEventListener('touchmove', touchMove,false);
document.getElementById("carousel-example-generica").addEventListener('touchend', touchEnd,false);