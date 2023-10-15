package com.litongjava.ai.kbase.utils;

import cn.hutool.core.io.FileUtil;
import com.benjaminwan.ocrlibrary.OcrEngine;
import com.benjaminwan.ocrlibrary.OcrResult;

import java.io.File;
import java.util.Arrays;

/**
 * tools-ocr
 * Created by 何志龙 on 2019-03-22.
 */
public class OcrUtils {

  public static OcrResult index(byte[] imgData) {
    String path = "tmp_" + Math.abs(Arrays.hashCode(imgData)) + ".png";
    File file = FileUtil.writeBytes(imgData, path);
    if (file.exists()) {
      OcrEngine ocrEngine = LocalOcr.INSTANCE.getOcrEngine();
      OcrResult ocrResult = ocrEngine.detect(file.getAbsolutePath());
      return ocrResult;
      //return extractLocalResult(ocrResult);
    }
    return null;
  }
}
