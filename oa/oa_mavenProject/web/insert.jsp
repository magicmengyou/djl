<%@ page import="java.util.List" %>
<%@ page import="com.oa.www.model.Dept" %><%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2023/12/12
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="color: red"><%=request.getAttribute("msg")%></div>
<form action="EmpServlet?flag=insert" method="post">
    <p>员工工号:<input type="text" name="eid"> </p>
    <p>员工姓名:<input type="text" name="ename"> </p>
    <p>密码:<input type="text" name="pwd"> </p>
    <p>性别:<input type="text" name="sex"> </p>
    <p>生日:<input type="text" name="bir"> </p>
    <p>电话:<input type="text" name="phone"> </p>
    <p>入职日期:<input type="date" name="rzdate"> </p>
    <p>基本工资:<input type="text" name="bsal"> </p>
    <p>工资:<input type="text" name="fsal"> </p>

    <select name="deptno">
        <option value="0">请选择部门名字</option>
        <%--        根据后台查询到的下拉框内容  循环生成--%>
        <%List<Dept> listDept = (List<Dept>) request.getAttribute("listDept");%>
        <%if(listDept!=null){%>
        <%for(Dept d:listDept){%>
        <option value="<%=d.getDeptno()%>"><%=d.getDname()%></option>
        <%}%>
        <%}%>
    </select>
    <p><input type="submit" value="新建"> </p>
</form>
</body>
</html>
