package com.devcolibri.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;


public class AreaCheckServlet extends HttpServlet {

    //Массивы допустимых значений
    private Integer[] arrayValidX = {-5, -4, -3, -2, -1, 0, 1, 2, 3};
    private Integer[] arrayValidR = {1, 2, 3, 4, 5};


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.nanoTime(); // время начала работы скрипта
        String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpSession session = req.getSession();

        //Получение параметров типа String
        String xS = req.getParameter("x_field");
        String yS = req.getParameter("y_field").replace(",",".");
        String rS = req.getParameter("r_field");

        //Переменная для записи результата попадания
        String flag;

        try {

         //Преобразование параметров в числа
         int x = Integer.parseInt(xS);
         double y = Double.parseDouble(yS);
         int r = Integer.parseInt(rS);

         //Проверка попадания
         flag = String.valueOf(check(x,y,r));
            System.out.println("flag+ "+flag);
        } catch (Exception e){

            //Неверное значение
            flag = "-1";
        }

        //Запись значений в бин и отправление результата
        long finish = System.nanoTime();
        String timeWork = (finish - start) / 1000000 + "." + (finish - start) % 1000000 + " мс";
        JavaBean javaBean = makeBean(timeNow, timeWork, flag, xS, yS, rS, (JavaBean) session.getAttribute("jb") );
        session.setAttribute("jb", javaBean);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }



    private int check(int x, double y, int r) {

        if (Arrays.asList(arrayValidX).contains(x) && Arrays.asList(arrayValidR).contains(r) && (y > -3.0) && (y < 5.0)) {
            System.out.println(batman(x,y,r));
            if (batman(x,y,r))

                //Результат - попадание
                return 0;

            //Результат - промах
            return 1;
        }

        //Неверное значение
        return -1;
    }


    //Бомбическая формула
    private boolean batman (int xx, double y, int R){
//if ax == 4, Rx == 28 ==> 28/4


//if ay == 4, Ry == 12 => coef = 4/12 = 1/3
        double rx = R/7.0;
        double ry = R/6.0;
        double x = xx+0.0;
        boolean elipce = ( (pow(x,2))/(49*pow(rx,2)) + (pow(y,2))/(9*pow(ry,2)) -1.0 ) <= 0.00000000000001;
        final double x1 = pow(x, 2) / (49 * pow(rx, 2)) + pow(y, 2) / (9 * pow(ry, 2)) - 1.0;
        System.out.println(x1);
        boolean elipce_down_x = (abs(x/rx)) >= 4;
        boolean elipce_down_y = (y/ry >= -3*sqrt(33)/7.0) && (y/ry <= 0);
        boolean elipce_up_x = (abs(x/rx)) >= 3;
        boolean elipce_up_y = y>=0;
        System.out.println("Elipce "+elipce);
        System.out.println("Elipce elipce_down_x "+elipce_down_x);
        System.out.println("Elipce elipce_down_y "+elipce_down_y);
        System.out.println("Elipce elipce_up_x "+elipce_up_x);
        System.out.println("Elipce elipce_up_y "+elipce_up_y);
        boolean full_elipce = (elipce&elipce_down_x&elipce_down_y) || (elipce&elipce_up_x&elipce_up_y);
        //System.out.println("full elipce"+ full_elipce);

        boolean smile = ( ((3*sqrt(33)-7)*pow(x,2))/(-112.0*pow(rx,2)) + abs(x/rx)/2
                +sqrt(1-pow(abs((abs(x/rx))-2)-1,2)) - y/ry -3) <=0;
        boolean smile_y = (y/ry>=-3) && (y/ry<=0);
        boolean smile_x = (x/ry<=4) && (x/ry>=-4);

        boolean full_smile = smile&smile_x&smile_y;

        //System.out.println("full_smile "+full_smile);

        boolean ears_y = y>=0;
        boolean ears_x = abs(x/rx)<=1 && abs(x/rx)>=0.75;
        boolean ears = -8*abs(x/rx)-y/ry+9>=0;

        boolean full_ears = ears&ears_x&ears_y;
        //System.out.println("full_ears "+full_ears);

        boolean ears2_x = abs(x/rx)<=0.75 && abs(x/rx)>=0.5;
        boolean ears2 = 3*abs(x/rx)-y/ry+0.75>=0;

        boolean full_ears2 = ears2&ears2_x&ears_y;
        //System.out.println("full_ears2"+full_ears2);

        boolean chelka_y = y>=0;
        boolean chelka_x = abs(x/rx)<=0.5;
        boolean chelka=9.0/4.0 - y/ry >=0;

        boolean chelka_full = chelka_x&&chelka_y&&chelka;

        boolean wings_x = abs(x/rx)<=3 && abs(x/rx)>=1;
        boolean wings_y = y>=0;
        boolean wings = -abs(x/rx)/2 - (3.0/7.0)*sqrt(10)*sqrt(4-pow(abs(x/rx)-1,2)) - y/ry + (6*sqrt(10))/7.0 + 1.5 >=0;

        boolean full_wings = wings&&wings_y&&wings_x;
        //System.out.println("full_w"+full_wings);
        return full_elipce || full_smile || full_ears || full_ears2 || full_wings || chelka_full;
    }


    private JavaBean makeBean(String start, String timeWork, String flag, String x, String y, String r, JavaBean jb){
            int count = jb.getValue();

            //Удаление первого элемента в массивах значений и сдвиг на один вверх
            if (count>=4){
                jb.setFlag(removeFirst(count, jb.getFlag()));
                jb.setR(removeFirst(count, jb.getR()));
                jb.setX(removeFirst(count, jb.getX()));
                jb.setY(removeFirst(count, jb.getY()));
                jb.setStart(removeFirst(count, jb.getStart()));
                jb.setTimeWork(removeFirst(count, jb.getTimeWork()));
                jb.setValue(count-1);
                count=count-1;
            }

        //Запись значений в массив бина
            jb.getFlag()[count] = flag;
            jb.getX()[count] = x;
            jb.getY()[count] = y;
            jb.getR()[count] = r;
            jb.getStart()[count] = start;
            jb.getTimeWork()[count] = timeWork;
            jb.setValue(count+1);

        jb.lastX();
        jb.lastY();
        jb.lastR();
        jb.setLastres(flag);

        return jb;
    }


    private String[] removeFirst(int value, String[] z){
        for (int i=0; i<value-1; i++){
            z[i]=z[i+1];
        }
        z[value-1]=null;
        return z;
    }


}
