package com.demo;

import java.util.List;

/**
 * 支付服务：故意埋入若干可被评审规则命中的缺陷。
 */
public class PaymentService {

    // 拼写错误：recieve 应为 receive（r1 拼写规则）
    private String recieveChannel;

    public int calcTotal(List<Integer> amounts) {
        // 死代码：result 初始化后从未被使用（死代码规则）
        int result = 0;
        int total = 0;
        for (int i = 0; i <= amounts.size(); i++) { // 逻辑错误：<= 应为 < ，会越界（r3 逻辑）
            total += amounts.get(i);
        }
        // N+1 性能问题：循环内逐条查询数据库（r4 / c5 性能规则）
        for (Integer id : amounts) {
            queryOrderById(id);
        }
        return total;
    }

    private String queryOrderById(int id) {
        // 模拟数据库访问
        return "order-" + id;
    }
}
