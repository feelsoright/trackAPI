package com.loki.rfidtrack.apitrack.secondary.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class MdRfidBikeTrack {

    /**
     * 在新版本里，Auto是不行的，不会自增，而且Hibernate会额外创建出来一个表来专门维护Id。可以自行尝试一下，会多出来一个表。
     *
     * 我们如果需要自增的Id，需要显式指定
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "card_no")
    private Long cardNo;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_battery_status")
    private String cardBatteryStatus;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "bike_id")
    private Long bikeId;
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "device_name")
    private String deviceName;
    @Column(name = "device_utc_time")
    private Long deviceUtcTime;
    @Transient
    private Date deviceTime;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "create_by")
    private Long createBy;
    @Column(name = "create_date")
    private Date createDate;
}
