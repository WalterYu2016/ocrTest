package com.demo;

import java.util.List;

public class SettlementJob {

    // 死代码：临时变量计算后未使用（死代码规则）
    public long settle(List<Long> ids) {
        long acc = 0L;
        long unused = ids.size() * 100L;
        for (Long id : ids) {
            acc += id;
        }
        return acc;
    }

    // 拼写错误：amout 应为 amount（r1 拼写规则）
    private long amout;
}
