package weather;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vad.ControllerWeather")
public class ControllerWeather extends HttpServlet {

    ModelWeather m=new ModelWeather();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


       String c= m.getW(request.getParameter("City"));
        request.setAttribute("C",c);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/Weather.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/Weather.jsp");
        requestDispatcher.forward(request, response);

    }
}
