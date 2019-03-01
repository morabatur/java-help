package com.chernish;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/other/exampleInfo")
public class ServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();

        out.println("<style> span {color:blue;} </style>");

        String requestURL = request.getRequestURL().toString();
        out.println("<br><span>requestURL:</span>");
        out.println(requestURL);
        //requestURL: http://localhost:8080/other/exampleInfo

        String requestURI = request.getRequestURI();
        out.println("<br><span>requestURI:</span>");
        out.println(requestURI);
        //requestURI: /other/exampleInfo

        String contextPath = request.getContextPath();
        out.println("<br><span>contextPath:</span>");
        out.println(contextPath);

        out.println("<br><span>servletPath:</span>");
        String servletPath = request.getServletPath();
        out.println(servletPath);
        //servletPath: /other/exampleInfo

        String queryString = request.getQueryString();
        out.println("<br><span>queryString:</span>");
        out.println(queryString);
        //queryString: text1=Hello&text2=World

        String param1 = request.getParameter("text1");
        out.println("<br><span>getParameter text1:</span>");
        out.println(param1);
        //getParameter text1: Hello

        String param2 = request.getParameter("text2");
        out.println("<br><span>getParameter text2:</span>");
        out.println(param2);
        //getParameter text2: World 

        // Server Infos
        out.println("<br><br><b>Server info:</b>");

        out.println("<br><span>serverName:</span>");
        String serverName = request.getServerName();
        out.println(serverName);

        out.println("<br><span>serverPort:</span>");
        int serverPort = request.getServerPort();
        out.println(serverPort + "");

        // Client Infos
        out.println("<br><br><b>Client info:</b>");

        out.println("<br><span>remoteAddr:</span>");
        String remoteAddr = request.getRemoteAddr();
        out.println(remoteAddr);

        out.println("<br><span>remoteHost:</span>");
        String remoteHost = request.getRemoteHost();
        out.println(remoteHost);

        out.println("<br><span>remoteHost:</span>");
        int remotePort = request.getRemotePort();
        out.println(remotePort + "");

        out.println("<br><span>remoteUser:</span>");
        String remoteUser = request.getRemoteUser();
        out.println(remoteUser);

        // Header Infos
        out.println("<br><br><b>headers:</b>");


        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            out.println("<br><span>" + header + "</span>: " + request.getHeader(header));
        }

        // Servlet Context info:
        out.println("<br><br><b>Servlet Context info:</b>");
        ServletContext servletContext = request.getServletContext();

        // Местоположение веб приложения на жестком диске (hard disk).
        out.println("<br><span>realPath:</span>");
        String realPath = servletContext.getRealPath("");
        out.println(realPath);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(req.getParameter("user"));
    }

}
