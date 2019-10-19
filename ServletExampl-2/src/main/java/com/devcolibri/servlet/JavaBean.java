package com.devcolibri.servlet;

public class JavaBean {

    private int value = 0;
    private String[] x = new String[4];
    private String[] y = new String[4];
    private String[] r = new String[4];
    private String [] flag = new String[4];
    private String [] start = new String[4];
    private String [] timeWork = new String[4];
    private String lastres ="-1";
    private String lastx="0";
    private String lasty="0";
    private String lastr="1";

    public String getLastres() {
        return lastres;
    }


    public void setLastres(String lastres) {
        this.lastres = lastres;
        System.out.println("kekflag " +this.lastres);
    }


    public int getValue() {
        return value;
    }

    public void setValue(int i){
        value = i;
    }

    public String[] getY() {
        return y;
    }

    public String[] getFlag() {
        return flag;
    }

    public String[] getR() {
        return r;
    }

    public String[] getX() {
        return x;
    }

    public void setFlag(String[] flag) {
        this.flag = flag;
    }

    public void setR(String[] r) {
        this.r = r;
    }

    public void setX(String[] x) {
        this.x = x;
    }

    public void setY(String[] y) {
        this.y = y;
    }

    public String[] getStart() {
        return start;
    }

    public String[] getTimeWork() {
        return timeWork;
    }

    public void setStart(String[] start) {
        this.start = start;
    }

    public void setTimeWork(String[] timeWork) {
        this.timeWork = timeWork;
    }


    public void lastX() {
        lastx = x[value-1];
    }
    public void lastY() {
        lasty = y[value-1];
    }
    public void lastR() {
        lastr = r[value-1];
    }
    //Создание строчки jsp кода, содержащего таблицу
    public String makeTable(){
        System.out.println("kek\n\n");
        StringBuilder sb = new StringBuilder("<table><tr><th>X</th> <th>Y</th><th>R</th><th>Начало работы</th><th>Время работы</th><th>Реузльтат</th></tr>");
        for (int i=0; i<value; i++ ){

            sb.append("<tr>");
            sb.append("<th>").append(x[i]).append("</th>");
            sb.append("<th>").append(y[i]).append("</th>");
            sb.append("<th>").append(r[i]).append("</th>");
            sb.append("<th>").append(start[i]).append("</th>");
            sb.append("<th>").append(timeWork[i]).append("</th>");
            switch (flag[i]){
                case "-1": sb.append("<th>Введите корректные данные</th>");
                    break;
                case "0": sb.append("<th> Ваша заявка принята. Ожидайте. Бэтмен скоро будет. </th>");
                    break;
                case "1": sb.append("<th> Бэтмен вне зоны доступа, обратитесь к другому супергерою </th>");
                    break;
            }
            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }

    public String getVal(String val, int i){
        String m [] = new String[4];
        switch (val){
            case "x": m=x;
                break;
            case "y": m=y;
                break;
            case "r": m=r;
                break;
            case "t": m=timeWork;
                break;
            case "s": m=start;
                break;
            case "flag": m=flag;
                break;
        }
        return m[i];
}

    public String interp(String i){
        String l = "";
        switch (i){
            case "-1":l="<th>Введите корректные данные</th>";
                break;
            case "0": l="<th> Ваша заявка принята. Ожидайте. Бэтмен скоро будет. </th>";
                break;
            case "1": l="<th> Бэтмен вне зоны доступа, обратитесь к другому супергерою </th>";
                break;
        }
        return l;
    }

    public String getLastx() {
        return lastx;
    }

    public void setLastx(String lastx) {
        this.lastx = lastx;
    }

    public String getLasty() {
        return lasty;
    }

    public void setLasty(String lasty) {
        this.lasty = lasty;
    }

    public String getLastr() {
        return lastr;
    }

    public void setLastr(String lastr) {
        this.lastr = lastr;
    }
}
