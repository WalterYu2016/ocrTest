package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLog {
    // 并发场景使用非线程安全的 SimpleDateFormat（静态共享）（r4 / c5 性能与线程安全规则）
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String stamp() {
        return SDF.format(new Date());
    }
}
