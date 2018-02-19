1. 一个单独的`<mvc:default-servlet-handler />`会导致controller，后面必须加一句`<mvc:annotation-driven />`
2. 在配置国际化信息时，如下：
```xml
<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource"
          p:basename="message" />
```
如果**不配置这个Bean的id**就会找不到那个文件。