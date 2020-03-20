# SSM-CRUD

## 1. 功能点

1.  分页

2.  数据校验

    jQuery前端校验 + JSR303后端校验

3.  ajax请求

4.  Restful风格URI：使用HTTP协议请求方式的动词，来表示对资源的操作（ GET->查询， POST -> 增加，    PUT -> 修改， DELETE -> 删除）

## 2. 技术点

*   基础框架-ssm （spring + springmvc + mybatis）
*   数据库-mysql
*   前端框架bootstrap   -   快速搭建
*   项目构建工具 - maven
*   分页 - pagehelper
*   逆向工程 - mybatis Generator

## 3. ssm框架整合

1.  在pom.xml文件中导入项目所需的依赖

2.  配置web.xml

    1.  配置spring容器
    2.  配置前端控制器DispatcherServlet
    3.  配置字符编码拦截器
    4.  配置resultful风格的HiddenHttpMethodFilter拦截器，将post请求转化为指定的请求

3.  配置springmvc.xml

    1.  配置包访问context:component-scan
    2.  配置视图解析器InternalResourceViewResolver
    3.  配置静态页面的处理mvc:default-servlet-handler
    4.  配置mvc注解支持 mvc:annotation-driven

4.  配置spring配置文件，applicationContext.xml

    1.  配置数据源
    2.  配置整和mybatis 和 spring
    3.  配置事务管理

5.  配置mybatis配置文件，SqlMapConfig.xml主配置文件，和/mapper下的映射配置文件

    sql文件

    ``` sql
    DROP TABLE IF EXISTS `department`;
    CREATE TABLE `department` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `departmentName` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
    
    DROP TABLE IF EXISTS `employee`;
    CREATE TABLE `employee` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `lastName` varchar(255) DEFAULT NULL,
      `email` varchar(255) DEFAULT NULL,
      `gender` int(2) DEFAULT NULL,
      `d_id` int(11) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `d-e` (`d_id`),
      CONSTRAINT `d-e` FOREIGN KEY (`d_id`) REFERENCES `department` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2003 DEFAULT CHARSET=utf8;
    
    ```

    

    此处使用mybatis 逆向工程自动生成配置文件

    [参考官方文档](http://mybatis.org/generator/index.html)

    在生成的配置文档中，完成自己的修改

    >   注意： 使用逆向工程，多次自动生成代码时，mapper映射配置文件中可能由重复代码，需要删除。

## 4. 测试Mapper

1.  spring整合junit

    导入依赖

    ```xml
    <!--spring整合junit-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.0.10.RELEASE</version>
    </dependency>
    ```

    ```java
    // 指定配置文件位置
    @ContextConfiguration(locations = "classpath:applicationContext.xml")
    // 指定junit以spring的单元测试运行
    @RunWith(SpringJUnit4ClassRunner.class)
    ```

## 5. 引入pageHelper

```xml
<!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.1.10</version>
</dependency>

```

在mybatis主配置文件中配置分页插件

