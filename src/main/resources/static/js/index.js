$(function githubblog() {
    var blog = [];
    $.ajax(
        {
            url: "https://api.github.com/repos/jsonlog/myspringblog/contents/src/main/resources/static/blog",
            // url: "https://api.github.com/users/jsonlog",
            async: false,//time
            data: {},
            type: "get",
            dataType: "json",
            success: function (data) {
                // console.log(JSON.stringify(data));
                // var obj = jQuery.parseJSON('{"name":"John"}');
                /*
[
  {
    "name": "hello.html",
    "path": "src/main/resources/static/blog/hello.html",
    "sha": "c417054af17ecdb99e00c8500de43ebc819427e0",
    "size": 548,
    "url": "https://api.github.com/repos/jsonlog/myspringblog/contents/src/main/resources/static/blog/hello.html?ref=master",
    "html_url": "https://github.com/jsonlog/myspringblog/blob/master/src/main/resources/static/blog/hello.html",
    "git_url": "https://api.github.com/repos/jsonlog/myspringblog/git/blobs/c417054af17ecdb99e00c8500de43ebc819427e0",
    "download_url": "https://raw.githubusercontent.com/jsonlog/myspringblog/master/src/main/resources/static/blog/hello.html",
    "type": "file",
    "_links": {
      "self": "https://api.github.com/repos/jsonlog/myspringblog/contents/src/main/resources/static/blog/hello.html?ref=master",
      "git": "https://api.github.com/repos/jsonlog/myspringblog/git/blobs/c417054af17ecdb99e00c8500de43ebc819427e0",
      "html": "https://github.com/jsonlog/myspringblog/blob/master/src/main/resources/static/blog/hello.html"
    }
  },
  ...]
                 */
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {
                        blog.push(data[i].path.toString().replace("src/main/resources/static/",""));
                    }
                }
                console.log(blog);
            },
            error: function () {
                alert("error");
            }
        });
    document.getElementById('main').innerText = blog;
    console.log(document.getElementById('main').innerText);
    alert(document.getElementById('main').innerText);
    return blog;
});