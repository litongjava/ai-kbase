package com.litongjava.ai.kbase.config;

import com.litongjava.jfinal.aop.Aop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by litonglinux@qq.com on 10/11/2023_12:53 AM
 */
public class InitConfig {

  public void init() {
    ProjectConfig projectConfig = Aop.get(ProjectConfig.class);
    Map<String, Object> map = new HashMap<>();
    map.put(ConfigKeys.libPath, "D:\\lib\\ocr-lib\\win64\\bin");
    map.put(ConfigKeys.modelsDir, "D:\\model\\ppocr-v3-NCNN-models");
    map.put(ConfigKeys.detName, "ch_PP-OCRv3_det_infer");
    map.put(ConfigKeys.clsName, "ch_ppocr_mobile_v2.0_cls_infer");
    map.put(ConfigKeys.recName, "ch_PP-OCRv3_rec_infer");
    map.put(ConfigKeys.keysName, "ppocr_keys_v1.txt");
    projectConfig.batchPut(map);

  }
}
