package com.kindhope.web.filter;

import com.kindhope.web.filter.nocache.NocacheResponseWrapper;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * No cache filter.
 *
 * @author Yosin_Hasan
 */
public class NoCacheFilter implements Filter {
    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(NoCacheFilter.class);

    @Override
    public final void destroy() {
        LOG.debug("No cache filter destruction starts");
        // no op
        LOG.debug("No cache filter destruction finished");
    }

    @Override
    public final void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        LOG.debug("Filter starts");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        NocacheResponseWrapper wrappedResponse = new NocacheResponseWrapper(httpResponse);
        LOG.debug("Filter finished");
        chain.doFilter(request, wrappedResponse);
    }

    @Override
    public final void init(final FilterConfig fConfig) throws ServletException {
        LOG.debug("No cache filter initialization starts");
        LOG.debug("No cache Filter initialization finished");
    }

}