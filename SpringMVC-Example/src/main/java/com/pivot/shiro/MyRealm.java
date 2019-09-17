package com.pivot.shiro;

import com.pivot.pojo.UserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.DigestUtils;

/***************************************************************************
 * @className: MyRealm
 * @date     : 2019/8/30 18:19
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
public class MyRealm extends AuthorizingRealm {
    private static final String USERNAME = "pivot";
    private static final String PASSWORD = "123456";
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken) authenticationToken;
        String username = myToken.getUsername();
        if (!USERNAME.equals(username)) {
            throw new UnknownAccountException();
        }
        UserVO user = new UserVO();
        user.setUsername(USERNAME);
        user.setPassword(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
