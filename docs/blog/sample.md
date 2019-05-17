<!--markdownstart{
    "news_title" : "标题", 
    "timer" : "2017-12-05", 
    "news_con" : "正文",
    "tagslist" : "sample,示例,samplemd"
}markdownend-->
# 博客系统
同时支持静态网站和动态网站,两开花才是好花~_~

# 初衷
想靠springboot学习搭建自用的博客系统,又不想一直开着服务器,2333没钱就是我开发的动力;
这套代码可以同时在github pages和服务器部署,github pages上只有静态的内容才有效,但是不影响基本功能的使用,以下表格展示的是它们的区别:

# 特点
该博客不同于其它博客直接在线上写博客并且存入数据库的方式,当然也没博客引擎那种腻害,本项目目前做到了:
- 支持文章标签,文章时间排序,支持html和markdown文件
- 如果部署成功,那么以后每次新增博客文章只需要操作如下即可更新网站文章列表:
- push一个博客文件到docs/blog目录即可,格式参照[sample.md](docs/blog/sample.md)或者[sample.html](docs/blog/sample.html),甚至不需要本地repo
- 每篇文章需要在其底部点初始化才能开启gitment评论功能,等同于新开一个Github issues

# 部署
- 动态版:修改自己的数据库用户名密码,参考mybatis/import.sql生成你的数据库
- [index](docs/jsonlog/index.html)里面这个[地址](https://api.github.com/repos/jsonlog/myspringblog/contents/docs/blog)替换你的id/你的repo
- 新文章列表是从github网站读取的哦,所以要push到github才能看到新文章,或者可以自己修改上一步涉及的函数进行测试
- 请参照[gitment说明](https://github.com/imsun/gitment)把代码中client_secret等多个参数修改为自己的,如果还是有问题,可以考虑gitalk
- [settings](https://github.com/jsonlog/myspringblog/settings) -> master banch /docs folder for Github pages

# 感谢
- 感谢基于GitHub [issues](https://github.com/jsonlog/myspringblog/issues)的gitment
- 感谢在线markdown转html工具[editor.md](https://github.com/pandao/editor.md/)
- 项目部分js,模板等来自互联网免费资源,在此一并感谢

# 日历
- 功能:展示时间 **抢票**+_休假放假_+单双周+**生日**+节日+父亲节+母亲节 
- 原理:每年的各种节日,生日 时间都是固定的,都可以通过农历国历计算得到
- 比如:10月1号是国庆,那么9月3号就是抢票日
- 不同:每年调休日期不同,动态版本通过服务器获取展示,静态版本通过套路计算
- 规律:如果端午节是周一,那么周六日放假;如果端午节是周四,那么四五六放假,周日补班
- 隐私:涉及生日这种,可以放到服务器数据库来读取,也支持本地自己看
- 静态版本计算规则固定,不一定每次都符合国情,请谨慎使用

# 2
|博客|动态|静态|
|---|---|---|
|我的博客|[heroku](https://myspringblog.herokuapp.com/)|[Github Pages](https://jsonlog.github.io/myspringblog)|
|数据|json,ajax|x|
|数据库|mysql,mybatis|x|
|抢票日历|blog.fest|根据放假规律自动计算抢票日期|
|节假日|blog.fest|根据放假规律自动计算放假日期|
|生日|blog.foreveryear|农历[gregorianFestival](docs/js/calendar.js) 国历[lunarFestival](docs/js/calendar.js)|
|节日|blog.foreveryear|同上|
|单双周|[week,week_walue](docs/js/calendar.js)|同左|
|博客文件|html,markdown|同左|
|时间排序|支持|同左|
|文章标签|支持|同左|
|评论系统|gitment|同左|
|other|天气,音乐|同左|
|todo|倒序,heroku|同左|
|缺点|模板扒过来时觉得还可以,现在觉得难看,对前端也不熟||


## 请我喝一杯奶茶吧!
|\>|_|<|
|---|---|---|
|![image](docs/images/payali.jpg)|![image](docs/images/paywechat.jpg)|![image](docs/images/payredpacket.jpg)|
