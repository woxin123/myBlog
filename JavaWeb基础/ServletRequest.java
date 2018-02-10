
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public interface ServletRequest {
    Object getAttribute(String var1);

    // Enumeration, ��������nextElement��������һϵ������Ԫ��
    // �����е��������Ʒ�װ��һ��Enumeration����
    Enumeration getAttributeNames();

    // ���ظ�ServletRequest��ʹ�õı���
    String getCharacterEncoding();

    // ���ø�ServletRequest��ʹ�õı��룬��������õ��쳣��֧�֣����׳�UnsupportedEncodingException
    void setCharacterEncoding(String var1) throws UnsupportedEncodingException;

    // ������������ĳ��ȣ����ֽ�Ϊ��λ���������������ṩ;�������δ֪���򷵻�-1�� 
    // ����HTTP servlet����CGI����CONTENT_LENGTH��ֵ��ͬ��
    int getContentLength();
    // MIME (Multipurpose Internet Mail Extensions) ��������Ϣ�������͵���������׼
    //�������������MIME���ͣ��������δ֪���򷵻�null��
    // ����HTTP servlet����CGI����CONTENT_TYPE��ֵ��ͬ��
    String getContentType();

    // ����һ��InputStream��������������������ServletInputStream
    // �ṩһ�������������ڴӿͻ��������ж�ȡ���������ݣ�
    // ����һ�ζ�ȡһ�����ݵĸ�Ч��readLine������ ����ĳЩЭ�飬����HTTP POST��PUT������ʹ��ServletInputStream�����ȡ�ӿͻ��˷��͵����ݡ�
    // ServletInputStream����ͨ��ͨ��ServletRequest��getInputStream������ȡ��
    // ����һ��servlet����ʵ�ֵĳ����ࡣ �������������ʵ��java.io.InputStream.read����������
    ServletInputStream getInputStream() throws IOException;

    /**
     * ��String��ʽ�������������ֵ;������������ڣ��򷵻�null�� ���������������һ���͵Ķ�����Ϣ�� ����HTTP Servlet�����������ڲ�ѯ�ַ����򷢲��ı������С�
     * ֻ����ȷ������ֻ��һ��ֵʱ����Ӧʹ�ô˷����� ������������ж��ֵ����ʹ��getParameterValues��java.lang.String����
     * ����Զ�ֵ����ʹ�ô˷������򷵻ص�ֵ����getParameterValues���ص������еĵ�һ��ֵ��

     * ������������������������з��͵ģ����緢��HTTP POST������ͨ��getInputStream������getReader����ֱ�Ӷ�ȡ������ܻ���Ŵ˷�����ִ��
     */
    String getParameter(String var1);
    
    // ��ȡ���в���������
    Enumeration getParameterNames();
    // ��������ж��ֵ����ʹ�ô˷������������ֻ��һ��ֵ���������ĳ���Ϊһ
    String[] getParameterValues(String var1);
    
    // ��Map���󷵻ظò���
    Map getParameterMap();
    /**
     * ��protocol / majorVersion.minorVersion��ʽ��������ʹ�õ�Э������ƺͰ汾��
     * ����HTTP / 1.1�� 
     * ����HTTP Servlet�����ص�ֵ��CGI����SERVER_PROTOCOL��ֵ��ͬ��
     */
    String getProtocol();

    /**
     * �������ڷ���������ķ��������ƣ�����http��https��ftp�� 
     * ��ͬ�ķ����ڹ���URLʱ�в�ͬ�Ĺ�����RFC 1738������
     */
    String getScheme();
    /**
     * ���ط�������ķ��������������� ����Host��ͷֵ������еĻ����еġ�����֮ǰ�Ĳ��ֵ�ֵ��
     * ���߽����ķ��������ƻ������IP��ַ��
     */
    String getServerName();
    /**
     * ���ط�������Ķ˿ںš� 
     * ����Hostͷֵ������еĻ����еġ�����֮��Ĳ��ֵ�ֵ�����߿ͻ������ӱ����ܵķ������˿ڵ�ֵ
     */
    int getServerPort();
    /**
     * ʹ��BufferedReader��Ϊ�ַ����ݼ�����������塣 Reader����ServletRquest��ʹ�õ��ַ����뷭���ַ����ݡ� 
     * ���Ե������������getInputStream��������ȡ���ģ�������������
     */
    BufferedReader getReader() throws IOException;
    /**
     * ���ط�������Ŀͻ��˻����һ�������InternetЭ�飨IP����ַ�� 
     * ����HTTP servlet����CGI����REMOTE_ADDR��ֵ��ͬ��
     */
    String getRemoteAddr();
    /**
     * ���ؿͻ��˵���ȫ�޶���������������һ������ 
     * ������治�ܻ���ѡ�񲻽�����������Ϊ��������ܣ���
     * �����������IP��ַ��������ʽ�� ����HTTP servlet����CGI����REMOTE_HOST��ֵ��ͬ��
     */
    String getRemoteHost();
    /**
     * �ڴ������д洢���ԡ� ����������֮�����á� �˷���ͨ����RequestDispatcherһ��ʹ�á�
��������Ӧ����ѭ���������ͬ��Լ���� ��java��*��javax��*��com.sun��*��ͷ�����Ʊ�����Sun Microsystemsʹ�á�
�������Ķ���Ϊnull����Ч�������removeAttribute��java.lang.String����ͬ��
���˾���˵���������servlet�ɷ���RequestDispatcher�Ĳ�ͬWebӦ�ó�����ʱ�������޷��ڵ�����servlet����ȷ�����ɴ˷������õĶ���
     */
    void setAttribute(String var1, Object var2);
    /**
     * �Ӵ��������Ƴ�һ�����ԡ� �������ͨ���ǲ���Ҫ�ģ���ΪֻҪ���󱻴������Ծͻ�һֱ���ڡ�
��������Ӧ����ѭ���������ͬ��Լ���� ��java��*��javax��*��com.sun��*��ͷ�����Ʊ�����Sun Microsystemsʹ�á�
     */
    void removeAttribute(String var1);
    /**
     * ����Accept-Languageͷ���ؿͻ��˽��������ݵ���ѡLocale�� 
     * ����ͻ��������ṩAccept-Languageͷ����˷��������ط�������Ĭ���������á�
     */
    Locale getLocale();
    /**
     * ����Locale�����Enumeration��ָʾ����ѡ���Ի�����ʼ�ĵݼ�˳�򣬻���Accept-Language��ͷΪ�ͻ��˽��ܵ����Ի����� 
     * ����ͻ��������ṩAccept-Languageͷ����˷���������һ��Enumeration�����а���һ��Locale��
     * �÷�������Ĭ����������
     */
    Enumeration getLocales();
    /**
     * ����һ������ֵ��ָʾ�������Ƿ�ʹ�ð�ȫͨ������HTTPS�����С�
     */
    boolean isSecure();
    /**
     * ����һ��RequestDispatcher���󣬸ö���䵱λ�ڸ���·������Դ�İ�װ���� 
     * RequestDispatcher��������ڽ�����ת������Դ����Դ��������Ӧ�С� 
     * ��Դ�����Ƕ�̬��Ҳ�����Ǿ�̬�ġ�
     * ָ����·������������Եģ�������������չ����ǰ��servlet������֮�⡣ 
     * ���·���ԡ�/����ʼ���������Ϊ����ڵ�ǰ�����ĸ��� 
     * ���servlet�������ܷ���RequestDispatcher����˷�������null��
     * ���������ServletContext��getRequestDispatcher��������������������Բ������·����
     */
    RequestDispatcher getRequestDispatcher(String var1);

    /**
     * 
     */
    /** @deprecated */
    String getRealPath(String var1);

    /**
     * ���ط�������Ŀͻ��˻����һ�������InternetЭ�飨IP��Դ�˿�
     */
    int getRemotePort();

    /**
     * �����յ������InternetЭ�飨IP���ӿڵ���������
     */
    String getLocalName();

    // ����˼�壺get Local Address ��ñ��صĵ�ַ����ΪIP��ַ
    String getLocalAddr();
    /**
     * ��ñ����Ľӿ�
     */
    int getLocalPort();
}
