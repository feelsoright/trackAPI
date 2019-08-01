package com.loki.rfidtrack.apitrack.secondary.controller;


import com.loki.rfidtrack.apitrack.common.entity.Result;
import com.loki.rfidtrack.apitrack.common.entity.StatusCode;
import com.loki.rfidtrack.apitrack.secondary.entity.MdRfidBikeTrack;
import com.loki.rfidtrack.apitrack.secondary.service.impl.MdRfidBikeTrackServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("轨迹接口")
@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private MdRfidBikeTrackServiceImpl mdRfidBikeTrackServiceImpl;

    @ApiOperation(value = "获取指定日期的轨迹列表", notes = "根据cardNo、selectedDate获取轨迹列表", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardNo", value = "RFID卡号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "selectedDate", value = "轨迹日期", required = true, dataType = "String")
    })
    @RequestMapping(value = "/getTrackByCardNo", method = RequestMethod.GET)
    public Result getTrackByCardNo(@RequestParam String cardNo, @RequestParam String selectedDate) {
        try {
            List<MdRfidBikeTrack> list = mdRfidBikeTrackServiceImpl.findBikeTrack(cardNo, DateUtils.parseDate(selectedDate, "yyyy-MM-dd"));
            return new Result(true, StatusCode.OK, "数据获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式错误");
        }
    }

    @ApiOperation(value = "获取当天最新的轨迹", notes = "根据cardNo获取轨迹当天最新的轨迹", httpMethod = "GET")
    @ApiImplicitParam(name = "cardNo", value = "RFID卡号", required = true, dataType = "String")
    @RequestMapping(value = "/findLastTrackByCardNo", method = RequestMethod.GET)
    public Result findLastTrack(String cardNo) {
        return new Result(true, StatusCode.OK, "数据获取成功", mdRfidBikeTrackServiceImpl.findLastTrack(cardNo));
    }
}
