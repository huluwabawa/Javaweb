package itcast.web.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=150;
        int height=50;

        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(width, height,4,2);
       shearCaptcha.write(resp.getOutputStream());
        String code = shearCaptcha.getCode();
        req.getSession().setAttribute("CHECKCODE_SERVER",code);
        //  BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
//        Graphics g=image.getGraphics();
//        g.setColor(Color.pink);
//        g.fillRect(0,0,width,height);
//        g.setColor(Color.blue);
//        g.drawRect(0,0,width-1,height-1);
//        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder sb=new StringBuilder();
//        Random ran=new Random();
//        for (int i = 1; i <=4; i++) {
//            int index = ran.nextInt(str.length());
//            char ch=str.charAt(index);
//            sb.append(ch);
//            g.drawString(ch+"",width/5*i,height/2);
//        }
//        String checkCode_session=sb.toString();
//        req.getSession().setAttribute("checkCode_session",checkCode_session);
//            g.setColor(Color.green);
//        for (int i = 0; i < 1; i++) {
//            int x1 = ran.nextInt(width);
//            int x2 = ran.nextInt(width);
//            int y1=ran.nextInt(height);
//            int y2=ran.nextInt(height);
//            g.drawLine(x1,y1,x2,y2);
//        }

//        ImageIO.write(image,"jpg",resp.getOutputStream());
//        CaptchaUtil.createShearCaptcha()
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }
}
