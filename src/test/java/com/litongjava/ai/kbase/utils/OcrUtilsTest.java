package com.litongjava.ai.kbase.utils;

import com.benjaminwan.ocrlibrary.OcrResult;
import com.litongjava.ai.kbase.config.InitConfig;
import com.litongjava.jfinal.aop.Aop;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by litonglinux@qq.com on 10/15/2023_12:10 PM
 */
public class OcrUtilsTest {

  @Test
  public void index() throws IOException {
    InitConfig initConfig = new InitConfig();
    initConfig.init();

    String imagesPath = "images/Snipaste_2023-10-11_02-08-03.png";
    Path path = Paths.get(imagesPath);
    byte[] bytes = Files.readAllBytes(path);
    System.out.println(bytes);
    OcrResult ocrResult = OcrUtils.index(bytes);
    System.out.println(ocrResult);
  }
}