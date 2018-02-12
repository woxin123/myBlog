## Bean





### Spring中Bean的作用域
Spring中Bean的作用域有如下几种：singleton、prototype、request、session、gloablSession。
|类型|说明|
|:---|:---|
|singleton|在Spring的Ioc容器中仅存在一个Bean实例，即Bean以单例的形式存在|
|prototype|每次从容器中调用Bean时，都会返回一个新的Bean实例，也就是说每次调用Bean时都会new一个对象|
|request|每次HTTP请求都会创建一个新的Bean，该作用域仅适用于WebAppApplicationContext环境|
|session|同一个HttpSession共享同一个Bean，不同的HttpSession使用不同的Bean，该作用域仅适用于WebAppApplicationContext环境|
|gloablSession|同一个全局的Session共享一个Bean，一般用于Protlet应用环境，该作用域仅适用于WebAppApplicationContext环境|

对于前面的两个属性一般的环境都适用，所以可以使用singleton="true|false"这样配置，当然也可以使用scope="<作用域类型>"属性进行配置。