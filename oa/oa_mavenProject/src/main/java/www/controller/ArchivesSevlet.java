package www.controller;
import com.alibaba.fastjson2.JSON;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static www.model.util.FileUtil.listFiles;


@WebServlet(name = "ArchivesSevlet", value = "/ArchivesSevlet")
public class ArchivesSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("adminName");
//        String password = request.getParameter("adminPassword");
        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        String flag = request.getParameter("flag");
        if ("selectAllFile".equals(flag)){
            System.out.println("ok");
//            String s = "../My_OaProject/web/file/myfile/" + username + "/";
            String s = "D:\\software\\allProject\\IdeaProjects\\javaeeworkspace\\oa-office-system\\My_OaProject\\web\\file\\myfile";
            File file = new File(s);
            //获取文件当前路径
            System.out.println(file.mkdirs());
            List<File> files = listFiles(file);
            System.out.println(files);
            for (File i : files) {
                System.out.println(i.getName());
            }
            if (!files.isEmpty()){
                String str = JSON.toJSONString(files);
                response.getWriter().write(str);
                response.setHeader("context-type","text/plain,charset=utf-8");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter printWriter = response.getWriter();
                printWriter.print(str);
                printWriter.close();
            }else {
                System.out.println("ng");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

