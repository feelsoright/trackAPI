package com.loki.rfidtrack.apitrack.secondary.dao;

import com.loki.rfidtrack.apitrack.secondary.entity.MdRfidBikeTrack;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * @author: Loki.C
 * @date:Created in 2019/7/29 17:49
 * @description:
 * @modified by:
 * @version:
 */
@Component
public class MdRfidBikeTrackDao{
    /**
     * 注入的是实体管理器,执行持久化操作   unitName 使用指定的实体管理器
     */
    @PersistenceContext(unitName = "entityManagerFactorySecondary")
    EntityManager entityManager;

    public List<MdRfidBikeTrack> findBikeTrack(String cardNo, Date date) {
        String sql = "SELECT A.* ,B.device_name FROM md_rfid_bike_track_" +
                Integer.valueOf(String.format("%tj", date)) +
                " A inner join rfidbike.md_rfid_device B ON A.device_id=B.id and B.del_flag=0  WHERE A.card_no=" +
                cardNo + " order by device_utc_time";
        return entityManager.createNativeQuery(sql,MdRfidBikeTrack.class).getResultList();
    }

    public MdRfidBikeTrack findLastTrack(String cardNo) {
        String sql = "SELECT A.* ,B.device_name FROM md_rfid_bike_track_" +
                Integer.valueOf(String.format("%tj", System.currentTimeMillis())) +
                " A inner join rfidbike.md_rfid_device B ON A.device_id=B.id and B.del_flag=0  WHERE A.card_no=" +
                cardNo + " order by device_utc_time DESC LIMIT 1";
        List resultList = entityManager.createNativeQuery(sql, MdRfidBikeTrack.class).getResultList();
        return resultList.size()>0?(MdRfidBikeTrack) resultList.get(0):null;
    }
}

/*
// 表名会自动添加分号 弃用该方法
public interface MdRfidBikeTrackDao extends JpaRepository<MdRfidBikeTrack, Long>, JpaSpecificationExecutor<MdRfidBikeTrack> {

    */
/**
     * 获取某天的轨迹列表
     * @param cardNo
     * @param tableName
     * @return
     *//*

    @Query(value = "SELECT A.* ,B.device_name FROM :tableName" +
            " A inner join rfidbike.md_rfid_device B ON A.device_id=B.id and B.del_flag=0  WHERE A.card_no=:cardNo" +
            " order by device_utc_time", nativeQuery = true)
    List<MdRfidBikeTrack> findBikeTrack(@Param("cardNo")String cardNo, @Param("tableName")String tableName);
    */
/**
     * 获取最后一次地理位置
     * @param cardNo
     * @param tableName
     * @return
     *//*

    @Query(value = "SELECT A.* ,B.device_name FROM :tableName" +
            " A inner join rfidbike.md_rfid_device B ON A.device_id=B.id and B.del_flag=0  WHERE A.card_no=:cardNo" +
            " order by device_utc_time DESC LIMIT 1", nativeQuery = true)
    MdRfidBikeTrack findLastTrack(@Param("cardNo")String cardNo, @Param("tableName")String tableName);
}*/
