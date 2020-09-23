<%@page pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<script src="js/jquery-3.5.1.js"></script>
<body>
<h2>Hello World!</h2>
<a href="WEB-INF/pages/success.jsp">hello</a>

<form action="user" method="post">
    <label>
    name:<input type="text" name="name">
    list[0].name<input type="text" name="list[0].name">
    list[0].age<input type="text" name="list[0].age">
    map['one'].name<input type="text" name="map['one'].name">
    map['one'].age<input type="text" name="map['one'].age">
    date<input type="text" name="date">
    </label>
    <button type="submit">submit</button>
</form>
<br>
<form action="body" method="post">
    <label>
        name:<input type="text" name="name">
    </label>
    <button type="submit">submit</button>
</form>
<br>
<form id="form" action="body" method="post">
    <label>
        name:<input type="text" name="name">
        id:<input id="id" type="text">
    </label>
    <button type="submit" onclick="geiId()">submit</button>
</form>
<br>
<form action="user" method="post">
    <label>
        name:<input type="text" name="name">
    </label>
    <button type="submit">submit</button>
</form>
<br>
<button id="btn">ajax</button>
<br>
<label id="success">
    return:
</label>
<br>
<hr>

<form action="upload" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="upload" /> <br>
    <input type="submit" value="upload">
</form>
<hr>
<form action="upload2" method="post" enctype="multipart/form-data">
    选择文件2: <input type="file" name="upload" /> <br>
    <input type="submit" value="upload">
</form>
<br>
${requestScope}
</body>

<script>
    
    $(function (){
        $("#btn").click(function () {
            $.ajax({
                url:"testAjax",
                contentType:"application/json;charset=UTF-8",
                data:'{"name":"hehe", "age":"30"}',
                dataType:"json",
                type:"post",
                success:function (data) {
                    $("#success").append(data.name + " ").append(data.age + " ").append(data.date)
                }
            })
        })
    })
    
    function geiId(){
        let form = document.getElementById("form");
        let s = form.attributes["action"].value
        let n = s + "/" + document.getElementById("id").value
        form.attributes["action"].value = n
        alert(n)
    }
</script>
</html>
