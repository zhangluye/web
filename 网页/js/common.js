//页面加载后触发
window.onload = function(){
    var obtn = document.getElementById("btn");
    var timer=null;

    obtn.onclick=function () {
        // 设置定时
        timer=setInterval(function () {
            //获取滚动至顶部距离
            var osTop=document.documentElement.scrollTop || document.body.scrollTop;
            //速度取整
            var speed=Math.ceil(osTop/7);
            //每30秒不断减整
            document.body.scrollTop = document.documentElement.scrollTop = osTop-speed;
            thisTop=true;
            if (osTop === 0) {
                clearInterval(timer);
            }
        },30);

    };
    //滚动条滚动时触发停止
    var thisTop=true;

    window.onscroll=function () {
        var osTop=document.documentElement.scrollTop || document.body.scrollTop;
        if(!thisTop){
            clearInterval(timer);
        }
        thisTop=false;

        //滚动到网页大于窗口可视区时显示按钮
        var clientHeight=window.innerHeight||document.documentElement.clientHeight ||document.body.clientHeight;
        if(osTop >= clientHeight){
            obtn.style.display='block';
        }
        else{
            obtn.style.display='none';
        }
    };
};