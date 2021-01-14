# Nacos 配置中心中敏感信息脱敏
    基于Nacos1.2.1版本的配置中心对敏感信息过敏组建，例如对数据库的url、用户名、密码进行脱敏
    
# 使用方法
    项目中直接集成此jar包，在Naocs的配置中心的属性配置加上d(数据库密码)
    原来的配置是：db.password=xxxx; 脱敏的配置 db.password=d(xxxxxx)
