package com.loki.rfidtrack.apitrack.primary.entity;

import lombok.Data;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "md_register_code")
@Data
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class MdRegisterCode {

    /**
     * 在新版本里，Auto是不行的，不会自增，而且Hibernate会额外创建出来一个表来专门维护Id。可以自行尝试一下，会多出来一个表。
     *
     * 我们如果需要自增的Id，需要显式指定
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "used_flag")
    private char usedFlag;
    @Column(name = "register_code")
    private String registerCode;
    @Column(name = "create_by")
    private Long createBy;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_by")
    private Long updateBy;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "del_flag")
    private String delFlag;
}