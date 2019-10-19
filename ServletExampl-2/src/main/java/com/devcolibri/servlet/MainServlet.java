package com.devcolibri.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Создание бина, если его нет
        HttpSession session = req.getSession();
        if (session.getAttribute("jb")==null) {
            JavaBean javaBean = new JavaBean();
            session.setAttribute("jb",javaBean);
        }

        //Проверка наличия координат точек в запросе и перенаправление в другой сервлет
        if (req.getParameter("x_field")!=null && req.getParameter("y_field")!=null && req.getParameter("r_field")!=null){
            ServletContext context= getServletContext();
            RequestDispatcher rd= context.getRequestDispatcher("/checkServlet");
            rd.forward(req, resp);

        }
        else {
            //Возвращение главной страницей
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

}