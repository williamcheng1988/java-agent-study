
AOP实现: 
	参考资料：http://www.importnew.com/24305.html
	1. 静态代理: AspectJ的编译时增强实现AOP   
	2. 动态代理: Spring AOP
		a. JDK动态代理：通过反射来接收被代理的类，并且要求被代理的类必须实现一个接口。JDK动态代理的核心是 InvocationHandler 接口和 Proxy 类。
		b. CGLIB动态代理：CGLIB（Code Generation Library），是一个代码生成的类库，可以在运行时动态的生成某个类的子类，注意，CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为final，那么它是无法使用CGLIB做动态代理的。
