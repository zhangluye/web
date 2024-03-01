// 轮播图
var count=0;
var mytime;
function showImg(id){
    count++;
    if(id>0){
        clearInterval(mytime);
        count=id;
    }
    if(count>3){
        count=1;
    }
    document.getElementById("pic").src="../images/banner"+count+".jpg";
    for(var i=1;i<=3;i++){
        if(i===count){
            document.getElementById("num"+i).style.backgroundColor="#1737c3";
        }
        else{
            document.getElementById("num"+i).style.backgroundColor="#fff";
        }
    }
}
function out(){
    mytime=setInterval("showImg(0)",4000);
}
mytime=setInterval("showImg(0)",4000);