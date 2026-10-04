# ocrTest

代码评审工具 creview 的本地 + 远程全覆盖测试仓库。

覆盖场景：
- local：工作区未提交改动（含未跟踪文件）
- commit：两次提交之间的净变动
- branch：main..develop 分支净变动
- merge：main 合并 feature/merge1 的差异
- remote：裸仓库 ocrTest.git 克隆后评审

故意埋入的缺陷用于验证规则命中：
- 拼写错误（r1）
- 死代码 / 未使用变量（r2 命名 or 死代码类）
- 逻辑错误（r3）
- 性能问题（r4 / c5）
- SQL 注入（${}）与全表扫描（r6 / c6）
- MyBatis 参数一致性（XML-Java，r7/r9 类）
