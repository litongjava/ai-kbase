package com.litongjava.ai.kbase.services;

import com.litongjava.ai.kbase.model.R;
import com.litongjava.ai.kbase.utils.OcrUtils;

/**
 * Created by litonglinux@qq.com on 10/15/2023_11:56 AM
 */
public class OcrService {
  public R<Object> index(byte[] data) {
    return new R(OcrUtils.index(data));
  }

  public R<Object> str(byte[] data) {
    return new R(OcrUtils.index(data).getStrRes());
  }
}