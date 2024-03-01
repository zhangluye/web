window.onload = function () {
    /*左边选项变化*/
    var ul = document.getElementById("zj_ul");
    var liList = ul.getElementsByTagName("li");
    var cout = ul.className;
    for(var j=0;j<liList.length;j++) {
        liList[cout].style.backgroundColor='black';
        liList[cout].firstElementChild.style.color='#fff';
        if(cout !==j){
            (function () {
                var li = liList[j];
                li.onmouseover = function () {
                    li.style.backgroundColor='black';
                    li.firstElementChild.style.color='#fff';
                };
                li.onmouseleave = function(){
                    li.style.backgroundColor='white';
                    li.firstElementChild.style.color='black';
                };
                liList[cout].style.backgroundColor='black';
                liList[cout].firstElementChild.style.color='#fff';
            })(j);
        }
    }
};