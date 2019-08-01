package com.loki.rfidtrack.apitrack.secondary.service.impl;

import com.loki.rfidtrack.apitrack.secondary.dao.MdRfidBikeTrackDao;
import com.loki.rfidtrack.apitrack.secondary.entity.MdRfidBikeTrack;
import com.loki.rfidtrack.apitrack.secondary.service.MdRfidBikeTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MdRfidBikeTrackServiceImpl implements MdRfidBikeTrackService {

    @Autowired
    private MdRfidBikeTrackDao dao;

    @Override
    public List<MdRfidBikeTrack> findBikeTrack(String cardNo, Date date) {
        //返回结果
        return dao.findBikeTrack(cardNo, date);
    }

    @Override
    public MdRfidBikeTrack findLastTrack(String cardNo) {
       return dao.findLastTrack(cardNo/*, "md_rfid_bike_track_"+Integer.valueOf(String.format("%tj", System.currentTimeMillis()))*/);
    }

    public static void main(String[] args) {
        //%tj表示一年中的第几天
        System.out.println(Integer.valueOf(String.format("%tj", System.currentTimeMillis())));
    }
}
