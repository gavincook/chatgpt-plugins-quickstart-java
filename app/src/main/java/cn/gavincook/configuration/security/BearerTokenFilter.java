package cn.gavincook.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class BearerTokenFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer";
    private final String serviceToken;

    public BearerTokenFilter(String serviceToken) {
        this.serviceToken = serviceToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = attemptAuthentication(request, response);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String token = request.getHeader(AUTHORIZATION_HEADER);
        if (token != null && token.startsWith(BEARER_PREFIX)) {
            token = token.replaceFirst(BEARER_PREFIX, "").trim();
            if (StringUtils.equals(token, serviceToken)) {
                return new UsernamePasswordAuthenticationToken(token, null, List.of(() -> "ROLE_USER"));
            }
            return null;
        }
        return null;
    }
}
