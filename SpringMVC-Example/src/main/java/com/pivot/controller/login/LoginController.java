package com.pivot.controller.login;

import com.pivot.pojo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/***************************************************************************
 * @className: LoginController
 * @date     : 2019/9/2 10:43
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (SecurityUtils.getSubject().getPrincipal() != null) {
            return "redirect:/success";
        }
        return "/login/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(UserVO userVO) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {
            return "redirect:/success";
        }
        AuthenticationToken token = new UsernamePasswordToken(userVO.getUsername(), DigestUtils.md5DigestAsHex(userVO.getPassword().getBytes()));
        HttpServletRequest httpRequest = WebUtils.getHttpRequest(subject);
        HttpSession session = httpRequest.getSession();
        try {
            subject.login(token);
            UserVO userVO1 = (UserVO) subject.getPrincipal();
            session.setAttribute("loginUser", userVO1);
            return "redirect:/success";
        } catch (UnknownAccountException e) {
            httpRequest.setAttribute("msg", "此用户不存在！");
        } catch (IncorrectCredentialsException e) {
            httpRequest.setAttribute("msg", "密码不正确！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/login/index";
    }
}
