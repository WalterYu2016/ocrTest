-- 初始化脚本：故意保留若干 SQL 性能反模式，供 .sql 规则（r2 / c5）命中

-- 全表扫描：无 WHERE 的 SELECT *
SELECT * FROM t_order;

-- 缺少 LIMIT 的深度分页
SELECT id, amount FROM t_order ORDER BY create_time DESC;

-- 隐式类型转换：order_code 是字符串列，却用数字比较，索引失效
SELECT id FROM t_order WHERE order_code = 10086;

CREATE TABLE t_order (
    id          BIGINT PRIMARY KEY,
    order_code  VARCHAR(32),
    user_name   VARCHAR(64),
    amount      DECIMAL(12,2),
    create_time DATETIME
);
