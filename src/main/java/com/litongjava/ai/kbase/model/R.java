package com.litongjava.ai.kbase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by litonglinux@qq.com on 10/15/2023_11:51 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class R<T> {
  private int code;
  private String msg;
  private T data;


  public void setMsg(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public R(T data) {
    this.data = data;
  }
}
