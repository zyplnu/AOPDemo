package com.edu.lnu.advice;

/**
 * 定义一个用于标识目标类是否支持性能监视的接口
 */
public interface Monitorable {

    void setMonitorActive(boolean active);

}
