package com.litongjava.ai.kbase;

import com.litongjava.ai.kbase.config.InitConfig;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.tio.boot.TioApplication;
import com.litongjava.tio.boot.annotation.ComponentScan;
import org.tio.utils.jfinal.P;

@ComponentScan
public class AiKbaseApp {

  public static void main(String[] args) throws Exception {
    InitConfig initConfig = Aop.get(InitConfig.class);
    initConfig.init();
    long start = System.currentTimeMillis();
    P.use("app.properties");
    TioApplication.run(AiKbaseApp.class, args);
    long end = System.currentTimeMillis();

    System.out.println("started:" + (end - start) + "(ms)");
  }
}