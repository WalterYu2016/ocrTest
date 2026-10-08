package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** 审计查询：含真实缺陷（SQL 拼接注入 + 明文口令），供 commit/merge 走查造数。 */
public class AuditQuery {

    public ResultSet queryByUser(String user) throws Exception {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/audit", "root", "P@ssw0rd123");
        Statement st = conn.createStatement();
        // 缺陷：字符串拼接构造 SQL，存在注入风险
        String sql = "SELECT * FROM audit_log WHERE user_name = '" + user + "'";
        return st.executeQuery(sql);
    }
}
