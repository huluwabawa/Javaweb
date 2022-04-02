package itcast.web.servlet;

import itcast.domain.PageBean;
import itcast.domain.User;
import itcast.service.UserService;
import itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet( value = "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> condition = request.getParameterMap();
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }
        UserService service=new UserServiceImpl();
       PageBean<User> pb= service.findUserByPage(currentPage,rows,condition);
       request.setAttribute("pb",pb);
       request.setAttribute("condition",condition);
       request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
