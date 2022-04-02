package itcast.web.servlet;

import itcast.domain.User;
import itcast.service.UserService;
import itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet( value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String   checkcode_server =(String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.toString().equals(verifycode)){
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return ;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service=new UserServiceImpl();
        User loginUser=service.login(user);
        if(loginUser!=null){
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("login_msg","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
