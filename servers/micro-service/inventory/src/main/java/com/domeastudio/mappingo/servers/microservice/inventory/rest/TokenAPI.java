package com.domeastudio.mappingo.servers.microservice.inventory.rest;

import com.domeastudio.mappingo.servers.microservice.inventory.config.Audience;
import com.domeastudio.mappingo.servers.microservice.inventory.dto.request.Login;
import com.domeastudio.mappingo.servers.microservice.inventory.dto.response.AccessToken;
import com.domeastudio.mappingo.servers.microservice.inventory.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.inventory.dto.response.ResultStatusCode;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.inventory.util.DateUtil;
import com.domeastudio.mappingo.servers.microservice.inventory.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@CrossOrigin
@RestController
@Api("用户登录服务")
@RequestMapping("/oauth")
public class TokenAPI {
    private static final Logger logger = LoggerFactory.getLogger(TokenAPI.class);

    /**
     * 用户输入密码，当客户端是非浏览器时，需要客户端ID，这个ID是用户注册时生成的（根据MAC或设备ID计算出来的）
     */
    @Autowired
    private TUserService tUserService;

    @Autowired
    private Audience audienceEntity;

    @ApiOperation(value = "用于测试服务是否正常", notes = "", httpMethod = "GET")
    @ApiResponse(code = 200, message = "String", response = Map.class)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, String> test() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("message", "hello world");
        return stringStringMap;
    }

    @RequestMapping(value = "/form/token", method = RequestMethod.POST)
    public ClientMessage getAccessToken4Form(Login loginPara, HttpServletRequest httpServletRequest) {
        return getAccessToken(loginPara, httpServletRequest);
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage getAccessToken(@RequestBody Login loginPara, HttpServletRequest httpServletRequest) {
        ClientMessage clientMessage;
        String browserDetails = httpServletRequest.getHeader("User-Agent").toLowerCase();
        try {
            //验证码校验在后面章节添加
            //验证用户名密码
            TuserEntity user = tUserService.login(loginPara.getUserName(), loginPara.getPassword());
            if (user == null) {
                clientMessage = new ClientMessage(ResultStatusCode.INVALID_USERNAME_OR_PASSWORD.getCode(),
                        ResultStatusCode.INVALID_USERNAME_OR_PASSWORD.getMsg(), null);
                return clientMessage;
            }
            if (!isBrowser(browserDetails)) {
                if (loginPara.getLicence() == null
                        || (loginPara.getLicence().compareTo(user.getToken()) != 0)) {
                    clientMessage = new ClientMessage(ResultStatusCode.INVALID_CLIENTID.getCode(),
                            ResultStatusCode.INVALID_CLIENTID.getMsg(), null);
                    return clientMessage;
                }
            }
            Integer sub = DateUtil.getDateSpace(user.getRegistTime(), DateUtil.dateToString("yyyy-MM-dd", new Date(), "MEDIUM"));
            if (sub > user.getAuthorTime()) {
                clientMessage = new ClientMessage(ResultStatusCode.INVALID_TIME.getCode(),
                        ResultStatusCode.INVALID_TIME.getMsg(), null);
                return clientMessage;
            }

            List<TroleEntity> troleEntities = tUserService.findRoleByUser(user);
            StringBuilder stringBuilder = new StringBuilder();
            if (troleEntities.size() > 0) {
                for (TroleEntity troleEntity : troleEntities) {
                    stringBuilder.append(troleEntity.getName());
                }
            }
            //拼装accessToken
            String accessToken = JwtUtil.createJWT(loginPara.getUserName(), user.getUid(),
                    stringBuilder.toString(), user.getToken(), audienceEntity.getName(),
                    audienceEntity.getExpiresSecond() * 1000, user.getToken());

            //返回accessToken
            AccessToken accessTokenEntity = new AccessToken();
            accessTokenEntity.setAccess_token(accessToken);
            accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
            accessTokenEntity.setToken_type("bearer");
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), accessTokenEntity);
            return clientMessage;

        } catch (Exception ex) {
            clientMessage = new ClientMessage(ResultStatusCode.SYSTEM_ERR.getCode(),
                    ResultStatusCode.SYSTEM_ERR.getMsg(), null);
            return clientMessage;
        }
    }

    private Boolean isBrowser(String browser) {
        if (browser != null) {
            if (browser.contains("edge") || browser.contains("msie") ||
                    (browser.contains("safari") && browser.contains("version")) ||
                    (browser.contains("opr") || browser.contains("opera")) ||
                    browser.contains("chrome") || browser.contains("firefox") ||
                    browser.contains("rv") || (browser.indexOf("mozilla/7.0") > -1 ||
                    browser.indexOf("netscape6") != -1 || browser.indexOf("mozilla/4.78") != -1 ||
                    browser.indexOf("mozilla/3") != -1 || browser.indexOf("mozilla/4.7") != -1 ||
                    browser.indexOf("mozilla/4.08") != -1)) {
                return true;
            }
        }
        return false;
    }
}
