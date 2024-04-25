package secretproject.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import secretproject.user.vo.UserVO;

@Slf4j
public class AuthenticInterceptor extends HandlerInterceptorAdapter{
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	HttpSession session = request.getSession();
    	
    	UserVO sessionUserVO = (UserVO) session.getAttribute("sessionUserData");
    	log.debug("debug log={}", sessionUserVO);
//    	int auth = sessionUserVO.getUserAuthNum();
    	System.out.println("interceptor 실행 >>>");
    	
    	if (sessionUserVO.getUserAuthNum() != 1) {
    		return false;
    	}
        return true;
    }
}
