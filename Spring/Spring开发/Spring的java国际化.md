## 配置信息源
如下是添加一个名为message的信息源
```xml
<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource"
          p:basename="message" />
```
## 配置拦截器
```xml
<!-- 国际化操作拦截器 -->
<mvc:interceptors>
    <!-- 国际化操作拦截器，如果基于（Session和Cookie）则必须配置 -->
    <bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor" />
</mvc:interceptors>
```
如果是基于Header（请求头）的则不适用国际化拦截器。但是如果是Session，则需要进行如下的配置：
```xml
<mvc:interceptors>
    <!-- 如果采用（Session/Cookie）配置则必须配置 -->
    <bean  id="localeChangeInterceptor" class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor" />
</mvc:interceptors>
```
## 配置语言处理器
Header的处理器是默认的不用配置，下面的是它的Bean：
```
<!-- AcceptHeaederLocaleResolver配置，因为AcceptHeaederLocaleResolver是默认的语言区域解析器，所以不使用解析器也可以 -->
<bean id="localeResolver" class="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver" />
```
Session的语言处理器：
```
 <!-- SeesionLocaleResolve配置 -->
<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver" />
```
## Jsp页面的
Jsp页面的使用标签
```jsp
<!-- 所使用的标签 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="loginname" />
```
## 后台使用
```java
//从后台代码获取国际化信息username
RequestContext requestContext = new RequestContext(request);
String username = requestContext.getMessage("username");
```