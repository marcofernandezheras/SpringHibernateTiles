package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoggedFilter
 */
@WebFilter( urlPatterns = {"/bill/*", "/book/create.form" , "/book/edit.form", "/book/delete.form", "/cart/buy.form"})
public class LoggedFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggedFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		Object oUser = session.getAttribute("actualUser");
		if(oUser != null){
			chain.doFilter(request, response);
		}
		else {
			request.getRequestDispatcher("/index.form").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
