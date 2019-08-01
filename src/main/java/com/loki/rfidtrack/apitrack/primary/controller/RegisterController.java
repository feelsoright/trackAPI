package com.loki.rfidtrack.apitrack.primary.controller;

import com.loki.rfidtrack.apitrack.common.entity.Result;
import com.loki.rfidtrack.apitrack.common.entity.StatusCode;
import com.loki.rfidtrack.apitrack.primary.service.MdRegisterCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("设备注册接口")
@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private MdRegisterCodeService mdRegisterCodeService;

    @ApiOperation(value = "注册设备", notes = "注册设备", httpMethod = "POST")
    @ApiImplicitParam(name = "registerCode", value = "设备识别码", required = true, dataType = "String")
    @RequestMapping(value = "/checkRegisterCode", method = RequestMethod.POST)
    public Result checkRegisterCode(@RequestParam String registerCode) {
        if (mdRegisterCodeService.checkRegisterCode(registerCode)) {
            return new Result(true, StatusCode.OK, "注册成功", "");
        } else {
            return new Result(true, StatusCode.ERROR, "注册失败", "");
        }
    }
}
