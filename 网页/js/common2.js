window.onload = function () {
    function liebiao_fy() {
        /*信息列表翻页*/
        var i;
        var p_List = document.getElementById('liebiao').getElementsByTagName('p');
        var hr_List = document.getElementById('liebiao').getElementsByTagName('hr');
        var tiaoshu = document.getElementById("tiaoshu");
        tiaoshu.innerText = '共' + p_List.length + '条';
        var shouye = document.getElementById("shouye");
        var shangye = document.getElementById("shangye");
        var xiaye = document.getElementById("xiaye");
        var weiye = document.getElementById("weiye");
        var yeshu = document.getElementById("yeshu");
        var max_ts;
        var now_ys;
        function now() {
            return parseInt(yeshu.className);
        }
        now_ys=now();

        var sum_ys = Math.ceil(p_List.length/10);
//初始页面
        yeshu.innerText = now_ys + '/' + sum_ys;
        for(i=0;i<p_List.length;i++){
            p_List[i].style.display = 'none';
            hr_List[i].style.display = 'none';
        }
        if(10*now_ys>p_List.length){
            max_ts=p_List.length
        }else{
            max_ts=10*now_ys;
        }
        for(i=(now_ys-1)*10;i<max_ts;i++){
            p_List[i].style.display = 'block';
            hr_List[i].style.display = 'block';
        }
        shangye.onclick = function(){};
        shangye.style.color = 'rgb(200,200,200)';
        shouye.onclick = function(){};
        shouye.style.color = 'rgb(200,200,200)';
//上一页
        function shang(){
            shangye.onclick = function () {
                now_ys=now();
                console.log(now_ys);
                if(now_ys===1){
                    shangye.onclick = function(){};
                    shangye.style.color = 'rgb(200,200,200)';
                    shouye.onclick = function(){};
                    shouye.style.color = 'rgb(200,200,200)';
                }
                if(now_ys===sum_ys){
                    xiaye.style.color = '#333';
                    xia();
                    weiye.style.color = '#333';
                    wei();
                }
                now_ys = now_ys - 1;
                yeshu.className = now_ys;
                yeshu.innerText = now_ys + '/' + sum_ys;
                for (i = 0; i < p_List.length; i++) {
                    p_List[i].style.display = 'none';
                    hr_List[i].style.display = 'none';
                }
                for (i = (now_ys-1) * 10; i < 10*now_ys; i++) {
                    p_List[i].style.display = 'block';
                    hr_List[i].style.display = 'block';
                }
                if(now_ys===1){
                    shangye.onclick = function(){};
                    shangye.style.color = 'rgb(200,200,200)';
                    shouye.onclick = function(){};
                    shouye.style.color = 'rgb(200,200,200)';
                }
            };
        }

        function xia(){
            xiaye.onclick = function () {
                now_ys=now();
                if(now_ys===sum_ys){
                    xiaye.onclick = function(){};
                    xiaye.style.color = 'rgb(200,200,200)';
                    xiaye.onclick = function(){};
                    weiye.style.color = 'rgb(200,200,200)';
                }
                now_ys =now_ys+1;
                yeshu.className = now_ys ;
                yeshu.innerText = now_ys + '/' + sum_ys;

                for(i=0;i<p_List.length;i++){
                    p_List[i].style.display = 'none';
                    hr_List[i].style.display = 'none';
                }
                if(10*now_ys>p_List.length){
                    max_ts=p_List.length
                }else{
                    max_ts=10*now_ys;
                }
                for(i=(now_ys-1)*10;i<max_ts;i++){
                    p_List[i].style.display = 'block';
                    hr_List[i].style.display = 'block';
                }
                if(now_ys===sum_ys){
                    xiaye.onclick = function(){};
                    weiye.onclick = function(){};
                    xiaye.style.color = 'rgb(200,200,200)';
                    weiye.style.color = 'rgb(200,200,200)';
                }
                if(now_ys!==1){
                    shou();
                    shouye.style.color = '#333';
                    shang();
                    shangye.style.color = '#333';
                }
            };
        }
        function shou(){
            shouye.onclick = function(){
                now_ys=now();
                if(now_ys===1){
                    shouye.style.color = 'rgb(200,200,200)';
                    shangye.style.color = 'rgb(200,200,200)';
                }
                if(now_ys===sum_ys){
                    xiaye.style.color = '#333';
                    xia();
                    weiye.style.color = '#333';
                    wei();
                }
                now_ys=1;
                yeshu.className = 1 ;
                yeshu.innerText = 1 + '/' + sum_ys;
                for(i=0;i<p_List.length;i++){
                    p_List[i].style.display = 'none';
                    hr_List[i].style.display = 'none';
                }
                if(10*now_ys>p_List.length){
                    max_ts=p_List.length
                }else{
                    max_ts=10*now_ys;
                }
                for(i=(now_ys-1)*10;i<max_ts;i++){
                    p_List[i].style.display = 'block';
                    hr_List[i].style.display = 'block';
                }
                shouye.onclick = function(){};
                shouye.style.color = 'rgb(200,200,200)';
                shangye.onclick = function(){};
                shangye.style.color = 'rgb(200,200,200)';
            }
        }
        function wei(){
            weiye.onclick = function(){
                now_ys=now();
                if(now_ys===sum_ys){
                    weiye.style.color = 'rgb(200,200,200)';
                    xiaye.style.color = 'rgb(200,200,200)';
                }
                if(now_ys===1){
                    shangye.style.color = '#333';
                    shang();
                    shouye.style.color = '#333';
                    shou();
                }
                now_ys=sum_ys;
                yeshu.className = sum_ys ;
                yeshu.innerText = sum_ys + '/' + sum_ys;
                for(i=0;i<p_List.length;i++){
                    p_List[i].style.display = 'none';
                    hr_List[i].style.display = 'none';
                }
                if(10*now_ys>p_List.length){
                    max_ts=p_List.length
                }else{
                    max_ts=10*now_ys;
                }
                for(i=(now_ys-1)*10;i<max_ts;i++){
                    p_List[i].style.display = 'block';
                    hr_List[i].style.display = 'block';
                }
                weiye.onclick = function(){};
                weiye.style.color = 'rgb(200,200,200)';
                xiaye.onclick = function(){};
                xiaye.style.color = 'rgb(200,200,200)';
            }
        }
        shou();
        wei();
        xia();
        shang();
    }
    function zuodaohang() {
        var ul = document.getElementById("zj_ul");
        var liList = ul.getElementsByTagName("li");
        var cout = ul.className;
        for(var j=0;j<liList.length;j++) {
            liList[cout].style.backgroundColor='black';
            liList[cout].firstElementChild.style.color='#fff';
            if(cout !=j){
                (function () {
                    var li = liList[i];
                    li.onmouseover = function () {
                        li.style.backgroundColor='black';
                        li.firstElementChild.style.color='#fff';
                    };
                    li.onmouseleave = function(){
                        li.style.backgroundColor='white';
                        li.firstElementChild.style.color='black';
                    };
                })(j);
            }
        }
    }
    liebiao_fy();
    zuodaohang();
};