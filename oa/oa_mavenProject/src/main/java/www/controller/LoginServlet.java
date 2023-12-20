package www.controller;



import com.alibaba.fastjson2.JSON;
import www.dao.AdminDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        String flag = request.getParameter("flag");
//        System.out.println(username);
//        System.out.println(password);

        //验证身份
        if ("adminlogin".equals(flag)){
            AdminDao adminDao = new AdminDaoImp();
            boolean b = adminDao.checkAdmin(username,password);
            if (b){
                System.out.println("ok");
                System.out.println(username);
                String str = JSON.toJSONString(b);
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
                System.out.println(cookie);
//                System.out.println(username);
                response.setHeader("context-type","text/plain,charset=utf-8");
//                response.setContentType("text/html;charset=utf-8");
                PrintWriter pw = response.getWriter();
                pw.print(str);
//                pw.flush();
                pw.close();
            }else {
                System.out.println("ng");
                request.getRequestDispatcher("err.html").forward(request,response);


            }
        }else if ("跳转".equals(flag)){
            //创建cookie

            request.getRequestDispatcher("index.html").forward(request,response);
        }
        else if ("mytrain.html".equals(flag)){
            request.getRequestDispatcher("mytrain.html").forward(request,response);

        }else if ("train.html".equals(flag)){
            request.getRequestDispatcher("train.html").forward(request,response);

        }else if ("http://192.168.10.242:8501".equals(flag)){
            response.sendRedirect("http://192.168.10.242:8501");
//            request.getRequestDispatcher("http://localhost:8501/").forward(request,response);

        }else if ("calcu.html".equals(flag)){
            request.getRequestDispatcher("calcu.html").forward(request,response);
        }else if ("index.html".equals(flag)){
            request.getRequestDispatcher("index.html").forward(request,response);
        }
        else if ("http://192.168.10.204/ui/sessions/signin/".equals(flag)){
            response.sendRedirect("http://192.168.10.204/ui/sessions/signin/");
//            LocalDateTime localDateTime = LocalDateTime.now();
            //转换为年月日时分秒
//            String str = JSON.toJSONString(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//            response.setHeader("context-type","text/plain,charset=utf-8");
//            PrintWriter pw = response.getWriter();
//            pw.print(str);
//            pw.close();
        }
//        else if ("数据转换".equals(flag)){
//            String str = JSON.toJSONString(username);
//            response.setHeader("context-type","text/plain,charset=utf-8");
//            PrintWriter pw = response.getWriter();
//            pw.print(str);
//            pw.close();
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}

