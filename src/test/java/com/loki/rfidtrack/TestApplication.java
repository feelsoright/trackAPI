package com.loki.rfidtrack;

import com.loki.rfidtrack.apitrack.primary.service.MdRegisterCodeService;
import com.loki.rfidtrack.apitrack.secondary.service.MdRfidBikeTrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

/**
 * @author: Loki.C
 * @date:Created in 2019/7/30 14:08
 * @description:
 * @modified by:
 * @version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {


    @Autowired
    MdRegisterCodeService mdRegisterCodeService;
    @Autowired
    MdRfidBikeTrackService rfidBikeTrackService;

    @Test
    public void test() throws Exception{
//        boolean registerCode = mdRegisterCodeService.checkRegisterCode("123456");
//        System.out.println(registerCode);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        rfidBikeTrackService.findBikeTrack("123",sdf.parse("2019-07-23"));
        System.out.println(System.currentTimeMillis());
    }
}
