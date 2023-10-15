package com.litongjava.ai.kbase.controller;

import lombok.extern.slf4j.Slf4j;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;

@Slf4j
@RequestPath(value = "/version")
public class VersionController {
  @RequestPath
  public HttpResponse respText(HttpRequest request) throws Exception {
    String version = "ai-kbase-v1.0.0-2023-10-15 11:18:01";
    log.info(version);
    HttpResponse ret = Resps.txt(request, version);
    return ret;
  }
}