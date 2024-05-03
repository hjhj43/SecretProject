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
    	System.out.println("AuthenticInterceptor 실행 >>>");
    	
    	String requestURI = request.getRequestURI();
    	
    	if (sessionUserVO.getUserAuthNum() != 1) { // admin이 아닌 유저는 유저리스트와 유저삭제 기능에 접근할 수 없음
    		if (requestURI.equals("/UserList.do") || requestURI.equals("/deleteUser.do")) {
    		return false;
    		}
    	}
        return true;
    }

}
