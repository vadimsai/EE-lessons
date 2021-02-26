package jaxrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletFormParams")
public class ServletFormParams extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().write("<form method='post' action='http://localhost:8080/EEjms_war_exploded/Parametr/form'><input type='text' name='getformp'/></form>");
                                                                    // текст из формы по ссылке переходит в метод сервиса где получаем его
    }
}
