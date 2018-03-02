# BeanFactory源码分析
BeanFactory是一个接口，该接口提供了Ioc容器的规范。
[toc]
## BeanFactory接口中的方法
```java
public interface BeanFactory {
	String FACTORY_BEAN_PREFIX = "&";
	Object getBean(String name) throws BeansException;

	<T> T getBean(String name, @Nullable Class<T> requiredType) throws BeansException;

	Object getBean(String name, Object... args) throws BeansException;

	<T> T getBean(Class<T> requiredType) throws BeansException;
	<T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

	boolean containsBean(String name);
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
	boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;


	boolean isTypeMatch(String name, @Nullable Class<?> typeToMatch) throws NoSuchBeanDefinitionException;
	@Nullable
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
	String[] getAliases(String name);

}
```

### 1. 关于FACTORY_BEAN_PREFIX
```java
String FACTORY_BEAN_PREFIX = "&";
```

这里有两个重要的概念：FactoryBean和BeanFactory。
(1). FactoryBean是一个Bean，但这个Bean比较特殊是一个工厂类型的Bean。
(2). BeanFactory是一个Factory，是一个产生Bean的Factory。
### 2. BeanFactory中的方法。
1. `Object getBean(String name) throws BeansException;` 通过Bean的Name获取Bean。
2. `<T> T getBean(String name, @Nullable Class<T> requiredType) throws BeansException;`通过类型和名称获取Bean。
3. `Object getBean(String name, Object... args) throws BeansException;`如果获取的时prototype类型的Bean，那么后后面的args就是产生这个Bean所需要的参数。
4. `<T> T getBean(Class<T> requiredType) throws BeansException;` 返回一个与给定类型匹配的Bean，当然前提的是这个Bean存在。
5. `boolean containsBean(String name);`如果该BeanFactory中有指定Name的Bean返回true，否则返回false。
6. `boolean isSingleton(String name) throws NoSuchBeanDefinitionException;`在该BeanFactory中查询指定Name的Bean是否是singleton，如果是返回true，否则返回false。
7. `boolean isPrototype(String name) throws NoSuchBeanDefinitionException;`与上一个方法相似，这个方法是返回是否为prototype类型的Bean。
8. `boolean isTypeMatch(String name, @Nullable Class<?> typeToMatch) throws NoSuchBeanDefinitionException;` 这个方法是查询指定名称的Bean的Class类型是否是特定的Class类型。简单来说就是看指定名称的Bena的类型是不是指定的类型，或者指定类型的Bean的是不是叫这个名字。
9. `boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;`这个方法与上面的方法非常类似，只是上面的那个方法的第二个参数是Class类型的，而这个方法是ResolvableType类型，ResolvableType是Spring中的一个类，该类增强了泛型的获取。
10. `Class<?> getType(String name) throws NoSuchBeanDefinitionException;`该方法可以获取指定Name的Bean的类型。
11. `String[] getAliases(String name);`该方法是查询指定名称Bean的所有的别名。
