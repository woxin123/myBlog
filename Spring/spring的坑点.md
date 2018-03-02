1. 一个单独的`<mvc:default-servlet-handler />`会导致controller，后面必须加一句`<mvc:annotation-driven />`
2. 在配置国际化信息时，如下：
```xml
<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource"
          p:basename="message" />
```
如果**不配置这个Bean的id**就会找不到那个文件。
3. Spring 中使用JSR 303校验是的参数顺序问题
Errors必须在Model之前。
下面的程序会出现问题：
```
@RequestMapping(value = "/register", method = POST)
public String register(@ModelAttribute @Validated User user, Model model, Errors errors) {
    if (errors.hasErrors()) {
        return "registerForm";
    }
    model.addAttribute("user", user);
    return "success";
}
```
结果会出现400，改成如下，就好了。
```
@RequestMapping(value = "/register", method = POST)
public String register(@ModelAttribute @Validated User user, Errors errors, Model model) {
    if (errors.hasErrors()) {
        return "registerForm";
    }
    model.addAttribute("user", user);
    return "success";
}
```
4. spring坑点之jdbc的连接
如下的这种连接方式会出现Access denied for user 'root'@'localhost' (using password: YES)
```
driverClssName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/sampledb?useSSL=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8
username=root
password=xxxxxx
```
但是在username，password等之前加上jdbc或者dataSource以及其它前缀就行了，如下：
```
dataSource.driverClssName=com.mysql.cj.jdbc.Driver
dataSource.url=jdbc:mysql://localhost:3306/sampledb?useSSL=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8
dataSource.username=root
dataSource.password=xxxxxx
```