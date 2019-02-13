import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
 
/**
 * Created by artem on 4/22/2017.
 */
@WebServlet("/SampleServlet")
 
public class SampleServlet extends HttpServlet {
 
    /*
        Обработка GET запросов сервлетом
        HttpServletReuest req - запрос, который пришел к сервлету
        HttpServletResponse resp - ответ, который даст сервлет
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
 
        HttpSession session = req.getSession();
        /*
            Для того, чтобы передать данные на JSP, нужно в сервлете в request добавить атрибут
            Для этого необходимо вызвать метод setAttribute(String key, Object value), где:
            key - это ключ по которому можно получить доступ к данным на JSP.
            Например: ${header}
 
         */
         
        // Спустя 30 минут сессия обнулится
        session.setMaxInactiveInterval(30*60);
 
        req.setAttribute("header", "<h1>Главная страница VIRAND</h1>" );
 
        // Получение значения параметра из текущей сессии
        session.getAttribute("login");
 
        // Получение параметра, который пришел в запросе к сервлету
        String findText = req.getParameter("find");
 
        // Получение пути к файлу из сервлета
        // Директория files располагается в папке webapp
        String path=getServletContext().getRealPath( "files/sample.html" );
 
        // Обнуление сессии
        if (session != null) {
            session.invalidate();
        }
 
        // Вызов JSP страницы index.jsp
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
