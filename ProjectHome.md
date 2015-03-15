outletss
spring MVC3+hibernate+mysql
spring security
ehcache

目录 [隐藏]
1 安装Maven
2 配置Maven
2.1 配置本地Repository
2.2 配置代理
2.3 安全和部署配置
3 相关条目
4 参考来源

安装Maven

安装JDK

解压缩maven到你想安装的位置，如：D:/software/。

设置Maven系统环境变量，M2\_HOME=D:/software/maven。

添加Maven bin目录至系统环境变量PATH中， %M2\_HOME%\bin。

确认Maven的安装：

　cmd > mvn -version

提示Maven version 即安装成功。

配置Maven

Maven home directory在windows中是C:\Documents and Settings\username\.m2。

maven的配置可以分为三个级别：

.project

在pom.xml中配置。project configuration只针对当前project有效。

.installation

在maven安装时配置。

.user

对指定用户的配置。user configuration可以在${user.home}/.m2/settings.xml中指定。注：该文件不是必须的，当该文件找不到时，maven会使用默认的配置。

配置本地Repository

本地Repository的默认值是${user.home}/.m2/repository/。

可以在user configuration(即在${user.home}/.m2/setting.xml）中改变本地Repository。

配置如下：



&lt;settings&gt;



&lt;/settings&gt;




&lt;localRepository&gt;

/path/to/local/repo

&lt;/localRepository&gt;



注意：本地Repository 必须是绝对路径。

配置代理

在maven中，可以为http request配置代理。同样在user configuration中配置，配置如下：



&lt;settings&gt;



&lt;/settings&gt;

     

&lt;proxy&gt;


> 

&lt;id&gt;

optional

&lt;/id&gt;


> 

&lt;active&gt;

true

&lt;/active&gt;


> 

&lt;protocol&gt;

http

&lt;/protocol&gt;


> 

&lt;username&gt;

proxyuser

&lt;/username&gt;


> 

&lt;password&gt;

proxypass

&lt;/password&gt;


> 

&lt;host&gt;

www.hc360.com

&lt;/host&gt;


> 

&lt;port&gt;

80

&lt;/port&gt;


> 

&lt;nonProxyHosts&gt;

local.net,some.host.com

&lt;/nonProxyHosts&gt;


> 

&lt;/proxy&gt;



安全和部署配置

在一个project中，该项目将要使用哪个Repository，是在

&lt;distributionmanagement&gt;



&lt;/distributionmanagement&gt;

setting.xml中指定的。然而，你却不能将用户名和密码以及其它的安全设定也放在该project中。因此，你可能会在你自己的设定中定义一个server,给它指定一个id, 该id与project将要使用那个Repository相对应。

另外，有些repository在下载时可能需要用户名和密码，这些也可以在server element中以相同的方式指定。配置如下

> 

&lt;server&gt;


> > 

&lt;id&gt;

deploymentRepo

&lt;/id&gt;


> > 

&lt;username&gt;

repouser

&lt;/username&gt;


> > 

&lt;password&gt;

repopwd

&lt;/password&gt;



> 

&lt;/server&gt;

