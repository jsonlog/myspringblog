
class game{
    constructor(){
        this.sence=document.querySelector('.sence');
        this.obj={};    //保存当前字母以及字母的详细信息
//            {A:{left:10,top:10px,ele:eleobj},B:{left:10,top:10px,ele:eleobj}}
        this.speed=3;
        this.num=3;
        this.h=window.innerHeight;
        this.code=document.querySelector('.code');
        this.codeobj=0;
        this.guanqia=document.querySelector('.guanqia');
        this.pass=1;
        this.life=document.querySelector('.life');
        this.lifeNum=5;
        this.time=0;
//            当前setInterval的ID
        this.flag=true;     //当前能不能开始
    }
    star(){
        flag=true;
//            根据i的大小来创建几个字母
        for(var i=0;i<this.num;i++){
            this.create();
        }
        this.move();
        this.keydown();
    }
//        创建字母（随机数和随机位置）
    create(){
        var newdiv=document.createElement('div');
        newdiv.className='letter';
//            解决字母重复的问题
        do{
            var randomNum=Math.floor(Math.random()*26+65);
            var randomLetter=String.fromCharCode(randomNum);
        }while (this.obj[randomLetter]);
        newdiv.style.backgroundImage="url(./images/"+randomLetter+".png)";

//            判断当前位置是否和其他任意一个位置重复的方法
        do{
            var randomleft=Math.floor(Math.random()*900);
        }while(this.check(randomleft));
        newdiv.style.left=randomleft+"px";
        var randomtop=-Math.floor(Math.random()*200);
        newdiv.style.top=randomtop+"px";
        this.sence.appendChild(newdiv);
        this.obj[randomLetter]={left:randomleft,top:randomtop,ele:newdiv};
    }
//        解决位置叠加问题
    check(newleft){
        for(var i in this.obj){
            if(newleft>this.obj[i].left-100 && newleft<this.obj[i].left+100){
                return true;
            }
        }
    }
    move(){
        this.time=setInterval(function () {
            for(var i in this.obj){
                var top=this.obj[i].top;
                top+=this.speed;
                this.obj[i].ele.style.top=top+'px';
                this.obj[i].top=top;
                if(this.obj[i].top>this.h){
                    this.lifeNum--;
                    this.life.innerHTML=this.lifeNum;
                    this.sence.removeChild(this.obj[i].ele);
                    delete this.obj[i];
                    this.create();
                    if(this.lifeNum===0){
                        if(confirm("游戏结束，得分为"+this.codeobj+"是否继续")){
                            history.go(0);
                        }
                    }
                }

            }
        }.bind(this),50)
    }
    keydown(){
        document.onkeydown=function (e) {
            var kc=e.keyCode;
            var letter=String.fromCharCode(kc);
            if(this.obj[letter]){
                this.sence.removeChild(this.obj[letter].ele);
                delete this.obj[letter];
                this.create();
//                    分数
                this.codeobj++;
                console.log( this.codeobj);
                this.code.innerHTML=this.codeobj;
                if( this.codeobj%10===0){
                    this.nextstar();
                }

            }
        }.bind(this);
    }
//        关卡
    nextstar(){
        this.pass++;
        this.guanqia.innerHTML=this.pass;
        if(this.pass<=3){
            this.create();
        }else{
            this.speed+=2;
        }
    }
//        结束动画
    pause(){
        clearInterval(this.time);
    }
//        动画运行
    running(){
        this.move();
    }
    gameover(){
        clearInterval(this.time);
        this.obj={};
        
        this.speed=3;
        this.num=3;
        this.codeobj=0;
        this.code.innerHTML=0;
        this.pass=1;
        this.guanqia.innerHTML=1;
        this.lifeNum=5;
        this.life.innerHTML=5;
        this.sence.innerHTML="";

    }
}
var games=new game();
//    调用
var startBtn=document.querySelector(".star");
startBtn.onclick=function(){

    if(games.flag){
        games.star();
        games.flag=false;

    }

};
var stopBtn=document.querySelector(".stop");
var flag=true;
stopBtn.onclick=function(){
    if(flag) {
        games.pause();
//            stopBtn.innerHTML="继续";
    }else{
        games.running();
//            stopBtn.innerHTML="暂停";
    }
    flag=!flag;
};
var over=document.querySelector(".over");
over.onclick=function(){
        games.gameover();
        games.flag=true;
    };


    //音乐
var kaiguan=true;
var music=document.querySelector(".music");
var audio=document.querySelector("audio");
    music.onclick=function () {
        if(kaiguan){
            music.style.animationPlayState="paused";
            audio.pause();
        }else{
            music.style.animationPlayState="running";
            audio.play();
        }
        kaiguan=!kaiguan;
    };


