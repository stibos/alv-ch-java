package ch.alv.components.web.endpoint.filter;

import javax.servlet.http.HttpServletRequest;

/**
 * Security Filter for requests.
 *
 * @since  1.0.0
 */
public interface SecurityFilter {

    SecurityFilterResult doFilter(HttpServletRequest request, String moduleName, String storeName) throws UnauthorizedException;

}
