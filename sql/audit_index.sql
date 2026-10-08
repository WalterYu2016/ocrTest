-- 审计报表查询：无 WHERE 无 LIMIT，audit_log 大表全表扫描（性能缺陷，供造数）
SELECT * FROM audit_log ORDER BY create_time DESC;
