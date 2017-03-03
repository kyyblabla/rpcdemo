# 远程调用框架的基本实现

## 参考与学习链接
[Java利用Sping框架编写RPC远程过程调用服务的教程](http://www.jb51.net/article/87079.htm)

## 相关技术点
- Spring：boot 应用基本框架，本项目并未web项目，继承与 `CommandLineRunner` 作为启动函数
- Netty：NIO处理网络请求
- Protostuff：来至于Google的对象序列化框架
- ZooKeeper：服务注册与发现