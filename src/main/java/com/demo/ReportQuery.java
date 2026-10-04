package com.demo;

import java.util.List;

public class ReportQuery {

    // 全表扫描 + 无 LIMIT（c5/c6 性能规则）
    List<Long> topUsers() {
        return jdbc("SELECT user_id FROM t_order WHERE status = 1");
    }

    // 隐式类型转换导致索引失效（c5 性能规则）
    List<Long> byCode(long code) {
        return jdbc("SELECT id FROM t_order WHERE order_code = " + code);
    }

    // filesort：ORDER BY 非索引列且无 LIMIT（c5 性能规则）
    List<Long> recent() {
        return jdbc("SELECT id FROM t_order ORDER BY create_time DESC");
    }

    // N+1：循环内逐条查询（c5 性能规则）
    void loadAll(List<Long> ids) {
        for (Long id : ids) jdbc("SELECT * FROM t_order WHERE id = " + id);
    }

    private List<Long> jdbc(String sql) { return java.util.Collections.emptyList(); }
}
