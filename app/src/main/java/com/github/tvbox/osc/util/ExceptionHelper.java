package com.github.tvbox.osc.util;

import java.lang.Thread;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;


public class ExceptionHelper implements Thread.UncaughtExceptionHandler {

    private static volatile ExceptionHelper INSTANCE;

    private ExceptionHelper() {
    }

    public static ExceptionHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (ExceptionHelper.class) {
                if (INSTANCE == null) {
                    synchronized (ExceptionHelper.class) {
                        INSTANCE = new ExceptionHelper();
                    }
                }
            }
        }
        return INSTANCE;
    }

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    /**
     * 初始化默认异常捕获
     */
    public void init() {
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将当前类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (handleException(e)) {
            PushHelper.push(e.getMessage());
        } else {
            // 如果不处理,则调用系统默认处理异常,弹出系统强制关闭的对话框
            if (mDefaultHandler != null) {
                mDefaultHandler.uncaughtException(t, e);
            }
        }
    }

    private boolean handleException(Throwable e) {
        if (e == null) {
            return false;
        }

        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        e.printStackTrace(pw);
        pw.close();
        String result = writer.toString();
        // 打印出错误日志
        LOG.e( result);
        return true;
    }
}