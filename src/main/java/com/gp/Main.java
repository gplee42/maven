package com.gp;


public class Main {
    public  static  void  main(String[] args){
        //현재 DispatcherServlet구현과 HandlerMapping을 통해 알맞는 Controller를 찾는 과정이 생략되어있음
        printController pc = new printController();
        pc.typedQuery();
    }
}
