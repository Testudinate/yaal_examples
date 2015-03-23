package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Добавляет атрибут к запросу.
 */
@WebFilter(urlPatterns = "/el/read_request_attribute.jsp")
public class PutAttributeToRequestFilter implements Filter {
    public static final String ATTR_NAME = "puttedAttr";
    public static final Object ATTR_VALUE = 666;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute(ATTR_NAME, ATTR_VALUE);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}