# cart
基于servlet+jsp+mysql做的一个简易的购物车功能
## 特性
- 基于VSCode环境
## 使用/二次开发
- 导入并配置模板————[Crazyokd/JW_VSC-Template](##参考)
- 执行[cart.sql](cart.sql)文件
- 修改[JdbcUtils.java](pkg/ex11/utils/JdbcUtils.java)文件中有关数据库的配置
- 执行[startup_server.bat](startup_server.bat)脚本
## 使用到的lib
- c3p0-0.9.5.1.jar
- commons-dbutils-1.6.jar
- jstl.jar
- mchange-commons-java-0.2.10.jar
- mysql-connector-java-5.1.26-bin.jar
- standard.jar
## TODO
- [ ] 核查依赖倒转
- [ ] 客户端添加书籍
- [ ] filter
- [ ] 购买书籍采用Session而非数据库
- [ ] 清空购物车
- [ ] 注册检查
- [ ] 登录与注册操作后的反馈
## 参考
- [Crazyokd/JW_VSC-Template](https://github.com/Crazyokd/JW_VSC-Template)
- [eson15/Javaweb_bookstore](https://github.com/eson15/Javaweb_bookstore)