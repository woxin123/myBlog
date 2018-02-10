
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public interface ServletRequest {
    Object getAttribute(String var1);

    // Enumeration, 连续调用nextElement方法返回一系列连续元素
    // 将所有的属性名称封装成一个Enumeration返回
    Enumeration getAttributeNames();

    // 返回该ServletRequest所使用的编码
    String getCharacterEncoding();

    // 设置该ServletRequest所使用的编码，如果所设置的异常不支持，则抛出UnsupportedEncodingException
    void setCharacterEncoding(String var1) throws UnsupportedEncodingException;

    // 返回请求主体的长度（以字节为单位），并由输入流提供;如果长度未知，则返回-1。 
    // 对于HTTP servlet，与CGI变量CONTENT_LENGTH的值相同。
    int getContentLength();
    // MIME (Multipurpose Internet Mail Extensions) 是描述消息内容类型的因特网标准
    //返回请求主体的MIME类型，如果类型未知，则返回null。
    // 对于HTTP servlet，与CGI变量CONTENT_TYPE的值相同。
    String getContentType();

    // 返回一个InputStream输入流，该流的类型是ServletInputStream
    // 提供一个输入流，用于从客户端请求中读取二进制数据，
    // 包括一次读取一行数据的高效的readLine方法。 对于某些协议，例如HTTP POST和PUT，可以使用ServletInputStream对象读取从客户端发送的数据。
    // ServletInputStream对象通常通过ServletRequest＃getInputStream方法获取。
    // 这是一个servlet容器实现的抽象类。 这个类的子类必须实现java.io.InputStream.read（）方法。
    ServletInputStream getInputStream() throws IOException;

    /**
     * 以String形式返回请求参数的值;如果参数不存在，则返回null。 请求参数是与请求一起发送的额外信息。 对于HTTP Servlet，参数包含在查询字符串或发布的表单数据中。
     * 只有在确定参数只有一个值时，才应使用此方法。 如果参数可能有多个值，请使用getParameterValues（java.lang.String）。
     * 如果对多值参数使用此方法，则返回的值等于getParameterValues返回的数组中的第一个值。

     * 如果参数数据是在请求主体中发送的，例如发生HTTP POST请求，则通过getInputStream（）或getReader（）直接读取主体可能会干扰此方法的执行
     */
    String getParameter(String var1);
    
    // 获取所有参数的名称
    Enumeration getParameterNames();
    // 如果参数有多个值，则使用此方法，如果参数只有一个值，则该数组的长度为一
    String[] getParameterValues(String var1);
    
    // 以Map对象返回该参数
    Map getParameterMap();
    /**
     * 以protocol / majorVersion.minorVersion格式返回请求使用的协议的名称和版本，
     * 例如HTTP / 1.1。 
     * 对于HTTP Servlet，返回的值与CGI变量SERVER_PROTOCOL的值相同。
     */
    String getProtocol();

    /**
     * 返回用于发出此请求的方案的名称，例如http，https或ftp。 
     * 不同的方案在构建URL时有不同的规则，如RFC 1738所述。
     */
    String getScheme();
    /**
     * 返回发送请求的服务器的主机名。 它是Host标头值（如果有的话）中的“：”之前的部分的值，
     * 或者解析的服务器名称或服务器IP地址。
     */
    String getServerName();
    /**
     * 返回发送请求的端口号。 
     * 它是Host头值（如果有的话）中的“：”之后的部分的值，或者客户端连接被接受的服务器端口的值
     */
    int getServerPort();
    /**
     * 使用BufferedReader作为字符数据检索请求的主体。 Reader根据ServletRquest上使用的字符编码翻译字符数据。 
     * 可以调用这个方法或getInputStream（）来读取正文，而不是两个。
     */
    BufferedReader getReader() throws IOException;
    /**
     * 返回发送请求的客户端或最后一个代理的Internet协议（IP）地址。 
     * 对于HTTP servlet，与CGI变量REMOTE_ADDR的值相同。
     */
    String getRemoteAddr();
    /**
     * 返回客户端的完全限定名或发送请求的最后一个代理。 
     * 如果引擎不能或者选择不解析主机名（为了提高性能），
     * 这个方法返回IP地址的虚线形式。 对于HTTP servlet，与CGI变量REMOTE_HOST的值相同。
     */
    String getRemoteHost();
    /**
     * 在此请求中存储属性。 属性在请求之间重置。 此方法通常与RequestDispatcher一起使用。
属性名称应该遵循与包名称相同的约定。 以java。*，javax。*和com.sun。*开头的名称保留供Sun Microsystems使用。
如果传入的对象为null，则效果与调用removeAttribute（java.lang.String）相同。
有人警告说，当请求从servlet派发到RequestDispatcher的不同Web应用程序中时，可能无法在调用者servlet中正确检索由此方法设置的对象。
     */
    void setAttribute(String var1, Object var2);
    /**
     * 从此请求中移除一个属性。 这个方法通常是不需要的，因为只要请求被处理，属性就会一直存在。
属性名称应该遵循与包名称相同的约定。 以java。*，javax。*和com.sun。*开头的名称保留供Sun Microsystems使用。
     */
    void removeAttribute(String var1);
    /**
     * 基于Accept-Language头返回客户端将接受内容的首选Locale。 
     * 如果客户端请求不提供Accept-Language头，则此方法将返回服务器的默认区域设置。
     */
    Locale getLocale();
    /**
     * 返回Locale对象的Enumeration，指示以首选语言环境开始的递减顺序，基于Accept-Language标头为客户端接受的语言环境。 
     * 如果客户端请求不提供Accept-Language头，则此方法将返回一个Enumeration，其中包含一个Locale，
     * 该服务器的默认区域设置
     */
    Enumeration getLocales();
    /**
     * 返回一个布尔值，指示此请求是否使用安全通道（如HTTPS）进行。
     */
    boolean isSecure();
    /**
     * 返回一个RequestDispatcher对象，该对象充当位于给定路径的资源的包装器。 
     * RequestDispatcher对象可用于将请求转发到资源或将资源包含在响应中。 
     * 资源可以是动态的也可以是静态的。
     * 指定的路径名可能是相对的，尽管它不能扩展到当前的servlet上下文之外。 
     * 如果路径以“/”开始，则将其解释为相对于当前上下文根。 
     * 如果servlet容器不能返回RequestDispatcher，则此方法返回null。
     * 这个方法和ServletContext＃getRequestDispatcher的区别在于这个方法可以采用相对路径。
     */
    RequestDispatcher getRequestDispatcher(String var1);

    /**
     * 
     */
    /** @deprecated */
    String getRealPath(String var1);

    /**
     * 返回发送请求的客户端或最后一个代理的Internet协议（IP）源端口
     */
    int getRemotePort();

    /**
     * 返回收到请求的Internet协议（IP）接口的主机名。
     */
    String getLocalName();

    // 顾名思义：get Local Address 获得本地的地址，即为IP地址
    String getLocalAddr();
    /**
     * 获得本机的接口
     */
    int getLocalPort();
}
