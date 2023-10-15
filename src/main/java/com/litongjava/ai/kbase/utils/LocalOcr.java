package com.litongjava.ai.kbase.utils;


import com.benjaminwan.ocrlibrary.OcrEngine;
import com.litongjava.ai.kbase.config.ConfigKeys;
import com.litongjava.ai.kbase.config.ProjectConfig;
import com.litongjava.jfinal.aop.Aop;
import lombok.extern.slf4j.Slf4j;

public enum LocalOcr {
  INSTANCE;

  private final OcrEngine ocrEngine;

  LocalOcr() {
    ProjectConfig projectConfig = Aop.get(ProjectConfig.class);
    String libPath = projectConfig.getStr(ConfigKeys.libPath);

    String modelsDir = projectConfig.getStr(ConfigKeys.modelsDir);
    String detName = projectConfig.getStr(ConfigKeys.detName);
    String clsName = projectConfig.getStr(ConfigKeys.clsName);
    String recName = projectConfig.getStr(ConfigKeys.recName);
    String keysName = projectConfig.getStr(ConfigKeys.keysName);

    LibraryUtils.addLibary(libPath);

    this.ocrEngine = new OcrEngine();
    ocrEngine.setNumThread(4);
    //------- init Logger -------
    ocrEngine.initLogger(false, false, false);
    ocrEngine.setGpuIndex(0);
//    ocrEngine.enableResultText("");
    ocrEngine.setGpuIndex(-1);
    boolean initModelsRet = ocrEngine.initModels(modelsDir, detName, clsName, recName, keysName);
    if (!initModelsRet) {
      System.err.println("Error in models initialization, please check the models/keys path!");
      return;
    }
  }

  public OcrEngine getOcrEngine() {
    return ocrEngine;
  }

  public void useGpu(Boolean isUse) {
    this.ocrEngine.setGpuIndex(isUse ? 0 : -1);
  }
}