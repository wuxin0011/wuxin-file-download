### 简要

简单来说下， 这个一个简单文件上传和下载项目，使用了ssm+jsp,权限拦截部分使用了拦截器实现，很简单。

虽然说jsp基本上已经过时了， 但是不能忘本，正是因为有了这些基础才有了后面的框架，才知道有了框架能够大大减少代码量， 提高代码效率。提高代码可读性。

界面很简单，使用了bootstrap框架，为了熟悉下原生js操作，因此使用了jquery，不过我这里基本上都是用来发送 ajax请求的，操作基本上使用的元素js操作。没有使用vue或者react，axios虽然发送请求很方便，
不过基于原生操作方式，使用了jquery。 刚开始我想连jquery都不使用，使用js原生操作方式发送请求，不过， 后面代码量有点多，偷了一点懒，还是用了。

目前邮件发送未实现

### 运行环境

- jdk1.8
- tomcat9
- mysql

### 文件路径配置

主要就是在windows上配置和Linux配置问题 ，由于使用文件上传和下载，如果将文件放到项目上，后期会导致项目过大。 因此，将项目路径映射到本地文件夹，主要就是修改下目录问题 在

**windows**
在 application-servlet.xml 的配置中

```xml

<mvc:resources mapping="/resource/**" location="file:///d://desktop//resource"/>

```

配置配置文件 location.properties

```properties
mapping=resource//
dir=d://desktop//
```

**Linux配置**

```xml

<mvc:resources mapping="/resource/**" location="file:///user/local/project/resource"/>

```

配置配置文件 location.properties

```properties
mapping=resource//
dir=/user/local/project/resource
```

> 注意:目录路径可以不和上面一样，但是一定要是
> mapping=文件夹名 dir=/xxxxx/文件夹名
> mapping=文件夹名 location=file///dir/mapping 这种形式


之所以没有在application-servlet.xml配置文件中使用配置文件引入方式,是因为我尝试过了 报错！启动失败！，因此没办法

**错误示例**

```xml
 <!-- 导入映射文件 -->
<context:property-placeholder location="classpath:location.properties"/>

<mvc:resources mapping="/${mapping}**" location="file:///${dir}${mapping}"/>

```

### 运行

windows上面就不多介绍了，主要就是导入sql文件。

重点就是Linux上面运行，这里使用docker运行

```shell
# 1、创建文件夹
mkdir -p /usr/local/project/tomcat/webapps /usr/local/project/tomcat/conf

# 2、将项目打包上传到服务器 文件夹

# 3、拉取镜像
docker pull tomcat:9.0.65-jdk8-openjdk-slim-buster

# 4、运行测试tomcat是否拉取成功，访问本机端口 8888
docker run -it --rm -p 8888:8080 tomcat:9.0.65-jdk8-openjdk-slim-buster
# 能够看到界面就运行成功了，接下来吧项目部署到镜像容器中
curl localhost:8888 

# 5、
docker run -d -p 8001:8080 --name=tomcat \
-v /usr/local/project/tomcat/webapps:/usr/local/tomcat/webapps \
tomcat:9.0.65-jdk8-openjdk-slim-buster

# 访问发现访问不到，需要加上项目名称 比如我这里是app.war 访问路径就是 192.168.233.50:8888/app/index
# 点击连接发现路径还是访问不到这里有两个办法
#    第一个是项目打包的时候添加访问前缀
#    第二个是修改tomcat配置文件
# 这里修改配置文件，上面运行的时候我测试了下如果将项目配置文件路径挂在到宿主机上面，会报错！也就是
# -v /usr/local/project/tomcat/conf:/usr/local/tomcat/conf 
# 因此将项目配置文件拷贝出来修改
cd /usr/local/project/tomcat/conf
docker cp tomcat:/usr/local/tomcat/conf/server.xml server.xml
vim server.xml

### 在<Host></Host> 标签中添加 app是项目名称
<Context path="" docBase="app" debug="0"/>
### 保存完毕之后 覆盖容器server.xml
docker cp server.xml tomcat:/usr/local/tomcat/conf/server.xml 
### 重新启动
docker restart tomcat

```

dockerfile

```dockerfile
FROM tomcat:9.0.65-jdk8-openjdk-slim-buster
COPY *.war /usr/local/tomcat/webapps
VOLUME /usr/local/project/tomcat/webapps /usr/local/tomcat/webapps
CMD ["catalina.sh","run"]
EXPOSE 8081
````


也可以直接从docker.hub中获取提交的镜像直接运行，我已经提交好了

```shell
docker run -d -p 8001:8080 --name=tomcat01 \
wuxin001/my-upload-download:v1.0
```



### 运行效果
![img_1.png](img_1.png)

账号:2191377759@qq.com

密码 admin

最后说一下，可以修改文件下载速度，😀，在 `com.wuxin.utils.FileUtil`中修改
```java
private static final int BUFFER_SIZE = 1024;
```

这个就是读取文件的速度，可以自己更改，我试过为1的时候，真的慢， 不知某会员是不是这个操作？