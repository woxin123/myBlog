
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public interface ServletRequest {
    Object getAttribute(String var1);

    Enumeration getAttributeNames();

    String getCharacterEncoding();

    void setCharacterEncoding(String var1) throws UnsupportedEncodingException;

    int getContentLength();

    String getContentType();

    ServletInputStream getInputStream() throws IOException;

    String getParameter(String var1);

    Enumeration getParameterNames();

    String[] getParameterValues(String var1);

    Map getParameterMap();

    String getProtocol();

    String getScheme();

    String getServerName();

    int getServerPort();

    BufferedReader getReader() throws IOException;

    String getRemoteAddr();

    String getRemoteHost();

    void setAttribute(String var1, Object var2);

    void removeAttribute(String var1);

    Locale getLocale();

    Enumeration getLocales();

    boolean isSecure();

    RequestDispatcher getRequestDispatcher(String var1);

    /** @deprecated */
    String getRealPath(String var1);

    int getRemotePort();

    String getLocalName();

    // 顾名思义：get Local Address 获得本地的地址，即为IP地址
    String getLocalAddr();

    int getLocalPort();
}
