<%@ page import="java.util.List" %>
<%@ page import="com.oa.www.model.Emp" %><%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2023/12/11
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("./images/bg0.jpg");
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
<a href="EmpServlet?flag=selectAll">查询所有数据</a><br>
<form action="EmpServlet?flag=select" method="post" >
    <input type="search" name="ename" placeholder="请输入要查询的员工名字" value=<%=request.getParameter("ename")%>>
    <select name="deptno">
        <option value="0">请选择部门名字</option>
        <option value="1">销售部</option>
        <option value="2">研发部</option>
        <option value="3">投资部</option>
        <option value="4">市场部</option>
    </select>
    <input type="submit" value="查询">
</form>
<div style="color: red"><%=request.getAttribute("msg")%></div>
<form action="" name="myform" method="post">
<table border="1px" width="800px" >
    <tr>
        <th>
            <input type="checkbox" name="">
        </th>
        <th>员工号</th>
        <th>员工名字</th>
        <th>密码</th>
        <th>性别</th>
        <th>生日</th>
        <th>电话</th>
        <th>入职日期</th>
        <th>工作</th>
        <th>基本工资</th>
        <th>实际工资</th>
        <th>部门名字</th>
        <th>操作</th>
    </tr>
    <% List<Emp> list = (List<Emp>)(request.getAttribute("list"));%>
    <%--        循环集合 生成行--%>
    <%if(list!=null){%>
    <% for(Emp e:list){%>
    <tr>
        <th>
            <input type="checkbox" name="">
        </th>
        <th><%=e.getEid()%></th>
        <th><%=e.getEname()%></th>
        <th><%=e.getPwd()%></th>
        <th><%=e.getSex()%></th>
        <th><%=e.getBir()%></th>
        <th><%=e.getPhone()%></th>
        <th><%=e.getRzdate()%></th>
        <th><%=e.getJob()%></th>
        <th><%=e.getBsal()%></th>
        <th><%=e.getFsal()%></th>
        <th><%=e.getDept().getDname()%></th>
        <th>
            <a href="javascript:selectByEid(<%=e.getEid()%>)">修改</a>&nbsp;&nbsp;
            <a href="javascript:deleteByEid(<%=e.getEid()%>)">删除</a>
        </th>
    </tr>
    <%}%>
    <%}%>
</table>
</form>
</body>
<script>
    function selectByEid(eid){
        document.myform.action="EmpServlet?flag=updateSelect&eid="+eid;
        document.myform.submit();
    }
    function deleteByEid(eid){
        if (confirm("是否删除该数据")){
            // 提交到后台
            document.myform.action="EmpServlet?flag=delete&eid="+eid;
            document.myform.submit();
        }
    }
</script>
</html>
