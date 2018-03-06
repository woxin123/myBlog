## Bean
### Spring Bean的属性
+ scope:用来配置Bean 的作用域。
+ singleton:表示Bean为单例。
+ abstract:设置为true，表示该Bean仅仅作为模板使用，应用上下文不会预先初始化它。
+ lazy-inint:设置为true，延迟加载，该Bean不会在ApllicationContext启动时提前被实例化，而是在第一次向容器通过getBean索取bean时实例化。
+ autowire: 自动装配。
+ dependecy-check:依赖检查。
+ dependes-on: 表示一个Bean的实例依靠另一个Bean先实例化。
+ autowire-candidate: 设置为false，容器在查找自动装配时，将不会被考虑考虑作为其他bean自动装配的的候选者，但是该Bean本身可以使用自动装配来注入其它Bean.
+ primary: 该bean会被优先注入。
+ destory-method: 容器销毁时调用的方法。
+ factory-method: 当调用factory-method所指向的方法时，才开始实例化bean。
+ factory-bean: 调用静态工厂方法创建bean.
### bean 的子元素
+ meta: 元数据，当需要里面的信息时可以通过key获取。
+ lookup-method: 获取器注入，是把一个方法成名为返回某种类型的bean，但实际返回的时bean 在配置文件中的配置。
+ replace-method: 可以在运行时调用新的方法替换现有的方法，还能动态的更新原有方法的逻辑。
+ constructor-arg: bean自动寻找对应的构造参数，并在初始化时将设置的参数传递进去。
+ property: 对bean中的数据赋值。
+ qualifier: 通过Qualifier指定注入bean的名称。
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