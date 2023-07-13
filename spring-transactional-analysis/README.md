# Spring 事务分析

## 过程
* 解析事务配置
* 获取 TransactionManager
* 创建一个Transaction
  * 获取设置 ConnectionHolder
  * 获取数据库连接，设置隔离级别，设置事务手动提交
* 执行事务逻辑
* 提交事务

## 杂记
* 只有public方法才支持事务

## 参考链接
* https://www.tengjiang.site/spring/2022/03/23/Spring%E7%B3%BB%E5%88%97-Spring%E4%BA%8B%E5%8A%A1%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90.html#h-gettransactionattribute
* https://docs.spring.io/spring-framework/docs/5.2.25.RELEASE/spring-framework-reference/data-access.html#transaction-declarative
