package www.controller;



import www.model.Dept;
import www.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpServlet", value = "/EmpServlet")
public class EmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String flag = request.getParameter("flag");
        int eid = 0;
        String no = request.getParameter("eid");
        if (no != null && !"".equals(no)) {
            eid = Integer.parseInt(no);
        }
        String ename = request.getParameter("ename");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String bir = request.getParameter("bir");
        String phone = request.getParameter("phone");
        String rzdate = request.getParameter("rzdate");
        String job = request.getParameter("job");
        double bsal = 0;
        double fsal = 0;
        String b = request.getParameter("bsal");
        String f = request.getParameter("fsal");
        if (b != null && !"".equals(b)) {
            bsal = Double.parseDouble(b);
        }
        if (f != null && !"".equals(f)) {
            fsal = Double.parseDouble(f);
        }
        String dno = request.getParameter("deptno");
        int deptno = 0;
        if (dno != null && !"".equals(dno)) {
            deptno = Integer.parseInt(dno);
        }
        Emp emp = new Emp();
        emp.setEid(eid);
        emp.setEname(ename);
        emp.setPwd(pwd);
        emp.setSex(sex);
        emp.setBir(bir);
        emp.setPhone(phone);
        emp.setRzdate(rzdate);
        emp.setJob(job);
        emp.setBsal(bsal);
        emp.setFsal(fsal);
        emp.setDeptno(deptno);
        //  查询下拉框的内容
        //  查询下拉框的内容
        EmpDaoImp empDao = new EmpDaoImp();
        DeptDaoImp deptDaoImp = new DeptDaoImp();
        List<Dept> listDept = deptDaoImp.selectAll();
        request.setAttribute("listDept", listDept);
        if ("selectAll".equals(flag)) {
            List<Emp> list = empDao.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("emp.jsp").forward(request, response);
        } else if ("select".equals(flag)) {
            List<Emp> list = empDao.selectMore(ename, deptno);
            request.setAttribute("list", list);
            request.getRequestDispatcher("emp.jsp").forward(request, response);
        } else if ("insert".equals(flag)) {
            System.out.println(emp);
            if (empDao.insert(emp) == 1) {
                request.setAttribute("msg", "新建成功");
                request.getRequestDispatcher("EmpServlet?flag=selectAll").forward(request, response);
            } else {
                request.setAttribute("msg", "新建失败");
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
        } else if ("delete".equals(flag)) {
            if (empDao.delete(eid) == 1) {
                request.setAttribute("msg", "删除成功");
            } else {
                request.setAttribute("msg", "删除失败");
            }
            request.getRequestDispatcher("EmpServlet?flag=selectAll").forward(request, response);
        } else if ("updateSelect".equals(flag)) {
            // 通过员工号查询员工详细信息
            Emp emps = empDao.selectByEmpno(eid);
            System.out.println(emps);

            request.setAttribute("emps",emps);
            request.getRequestDispatcher("update.jsp").forward(request, response);


        }else if ("update".equals(flag)) {
            System.out.println(emp);
            if (empDao.update(emp) == 1) {
                response.sendRedirect("EmpServlet?flag=selectAll");
            }else{
                request.setAttribute("msg","修改失败");
                request.getRequestDispatcher("update.jsp").forward(request,response);
            }
        }else if ("emp.jsp".equals(flag)){   //员工一览
            System.out.println("\"emp.jsp\"");
            request.getRequestDispatcher("emp.jsp").forward(request,response);
        }
        else if ("empar.html".equals(flag)){
            System.out.println("跳转到empar.html");
            request.getRequestDispatcher("empar.html").forward(request,response);
        }
        else if ("empleaverecords.html".equals(flag)){
            System.out.println("跳转到empleaverecords.html");
            request.getRequestDispatcher("empleaverecords.html").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
