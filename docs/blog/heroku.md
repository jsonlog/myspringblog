<!--{
    "news_title" : "heroku", 
    "timer" : "2019-05-18", 
    "tagslist" : "heroku,tool"
}-->
# heroku
Heroku平台与其他部署平台不同之处在于它在虚拟化平台上运行的文件系统是临时的
```
heroku command
heroku login
heroku create //app
heroku apps:rename newname ( --app oldname)
git push heroku master
heroku open //com
heroku logs --tail
heroku ps
heroku domains:add www.example.com
heroku run bash
```

```
server

 Starting process with command `java -Dserver.port=9676 $JAVA_OPTS -jar target/myspringblog-0.0.1-SNAPSHOT.jar`
  Create a Procfile to customize the command used to run this process: https://devcenter.heroku.com/articles/procfile
  no main manifest attribute, in target/myspringblog-0.0.1-SNAPSHOT.jar

```
