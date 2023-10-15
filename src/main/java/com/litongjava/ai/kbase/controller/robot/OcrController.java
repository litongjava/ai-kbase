package com.litongjava.ai.kbase.controller.robot;

import com.litongjava.ai.kbase.model.R;
import com.litongjava.ai.kbase.services.OcrService;
import com.litongjava.jfinal.aop.Aop;
import lombok.extern.slf4j.Slf4j;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.UploadFile;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;
import org.tio.utils.hutool.FileUtil;

import java.io.File;

/**
 * Created by litonglinux@qq.com on 10/15/2023_11:26 AM
 */
@RequestPath("/ocr")
@Slf4j
public class OcrController {
  private OcrService ocrService = Aop.get(OcrService.class);

  @RequestPath
  public HttpResponse index(UploadFile uploadFile, HttpRequest request) throws Exception {
    log.info("uploadfile:{}", uploadFile);
    R<Object> r = new R<>();
    if (uploadFile != null) {
      byte[] data = uploadFile.getData();
      r = ocrService.index(data);
    } else {
      r.setMsg(-1, "请上传文件");
    }
    return Resps.json(request, r);
  }

  @RequestPath("/str")
  public HttpResponse str(UploadFile uploadFile, HttpRequest request) throws Exception {
    log.info("uploadfile:{}", uploadFile);
    R<Object> r = new R<>();
    if (uploadFile != null) {
      byte[] data = uploadFile.getData();
      r = ocrService.str(data);
    } else {
      r.setMsg(-1, "请上传文件");
    }
    return Resps.json(request, r);
  }
}