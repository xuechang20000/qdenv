package com.xuechen.web.contrallor;

import com.alibaba.fastjson.JSONObject;
import com.xuechen.core.utils.Md5Utils;
import com.xuechen.core.utils.dto.MiniMenuDTO;
import com.xuechen.web.bo.AppLogLogin;
import com.xuechen.web.bo.AppMenu;
import com.xuechen.web.bo.AppUser;
import com.xuechen.web.dto.AppMenuDTO;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.service.UserService;
import com.xuechen.web.utils.MenuUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class LoginContrallor {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(String loginname,String password,HttpServletRequest request){
        Subject subject= SecurityUtils.getSubject();
        if (subject.isAuthenticated())
            return  "/WEB-INF/page/index";
        if(loginname==null||password==null)
            return "login";
        String pass= Md5Utils.MD5Code(password);
        UsernamePasswordToken token = new UsernamePasswordToken(loginname,pass);

        String ip=request.getRemoteHost();
        String errorMsg="";
        AppUserDTO appUserDTO=null;
        try {
            subject.login(token);
            logger.info("用户名为:【" + token.getUsername() + "】登陆成功！");
            //写日志
            AppUser appUser=new AppUser();
            appUser.setLoginname(loginname);
            appUserDTO=this.userService.queryUserByUser(appUser).get(0);
            setSession(appUserDTO);
            saveLogLogin(appUserDTO.getUserId(),loginname,password,ip,"1","用户名为:【" + loginname + "】登陆成功！");
            return  "/WEB-INF/page/index";
        } catch (UnknownAccountException uae) {
            errorMsg="用户名为【" + loginname + "】不存在";
        } catch (IncorrectCredentialsException ice) {
            errorMsg="用户名为【 " + loginname + " 】密码错误！";
        } catch (LockedAccountException lae) {
            errorMsg="用户名为【" + loginname + " 】的账户锁定，请联系管理员。";
        } catch (DisabledAccountException dax) {
            errorMsg="用户名为:【" + loginname + "】用户已经被禁用.";
        } catch (ExcessiveAttemptsException eae) {
            errorMsg="用户名为:【" + loginname + "】的用户登录次数过多，有暴力破解的嫌疑.";
        } catch (ExpiredCredentialsException eca) {
            errorMsg="用户名为:【" + loginname + "】用户凭证过期.";
        } catch (AuthenticationException ae) {
            errorMsg="用户名为:【" + loginname + "】用户验证失败.";
        } catch (Exception e) {
           e.printStackTrace();
            errorMsg="登陆异常";
        }
        request.setAttribute("errorMsg",errorMsg);
        return  "login";
    }
    @RequestMapping("logout")
    public ModelAndView logout(){
        SecurityUtils.getSubject().logout();
        return new ModelAndView("redirect:login");
    }
    public void saveLogLogin(Integer userid,String loginname,String password,String ip,String issuccess,String message){
        //记录登陆日志
        AppLogLogin appLogLogin=new AppLogLogin();
        appLogLogin.setCtime(new Date());
        appLogLogin.setIssuccess(issuccess);
        appLogLogin.setLoginname(loginname);
        appLogLogin.setPassword(password);
        appLogLogin.setRemoteip(ip);
        appLogLogin.setMessage(message);
        appLogLogin.setUserId(userid);
        this.userService.saveAppLogLogin(appLogLogin);
    }
    public  void setSession(AppUserDTO appUserDTO){
        Subject subject=SecurityUtils.getSubject();
        subject.getSession().setAttribute("user",appUserDTO);
        List<AppMenu> menus=appUserDTO.getAppMenus();
        if(menus!=null&&menus.size()>0){
            List<AppMenuDTO> appMenuList= MenuUtils.menuToLevel(menus);
            String menusJson= JSONObject.toJSONString(appMenuList);
            subject.getSession().setAttribute("menusJson",menusJson);
        }

    }
    @RequestMapping(value = "/loadMenus",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String loadMenus(){
        String menusJson=(String)SecurityUtils.getSubject().getSession().getAttribute("menusJson");
        return  menusJson;
    }
    public Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }
}
