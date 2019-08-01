package com.loki.rfidtrack.apitrack.secondary.service;




import com.loki.rfidtrack.apitrack.secondary.entity.MdRfidBikeTrack;

import java.util.Date;
import java.util.List;

public interface MdRfidBikeTrackService {
    List<MdRfidBikeTrack> findBikeTrack(String cardNo, Date date);

    /**
     * 获取最后一次地理位置
     * @param cardNo
     * @return
     */
    MdRfidBikeTrack findLastTrack(String cardNo);
}
