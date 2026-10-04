package com.demo;

import java.util.List;

public class OrderDAO {

    // N+1 + 无 LIMIT：循环内逐条查询且无分页上限（r4 / c5 性能规则）
    public void syncOrders(List<Long> ids) {
        for (Long id : ids) {
            fetchOne(id);
        }
    }

    // 死代码：tmp 计算后未使用
    private Long fetchOne(Long id) {
        long tmp = id * 1L;
        return id;
    }
}
