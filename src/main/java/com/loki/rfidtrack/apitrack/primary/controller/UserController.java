package com.loki.rfidtrack.apitrack.primary.controller;


import com.loki.rfidtrack.apitrack.common.entity.Result;
import com.loki.rfidtrack.apitrack.common.entity.StatusCode;

import com.loki.rfidtrack.apitrack.common.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.HashMap;
import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@Api("用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	@ApiOperation(value = "用户登录", notes = "根据username、password获取登录token", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
	})
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public Result login(@RequestParam String  username, @RequestParam String  password){

		if(username.equals("APIUSER")&&password.equals("APIPASSWORD")){
			//登录成功返回token，使用JWT
			String token = jwtUtil.createJWT(username, password, "user");
			Map<String,Object> param = new HashMap<>(2);
			param.put("role","user");
			param.put("token",token);
			return new Result(true, StatusCode.OK,"登录成功",param);
		}else
		{
			return new Result(false, StatusCode.LOGIN_ERROR,"用户名或密码错误");
		}
	}
}
