package com.loki.rfidtrack.apitrack.primary.dao;

import com.loki.rfidtrack.apitrack.primary.entity.MdRegisterCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: Loki.C
 * @date:Created in 2019/7/29 17:48
 * @description:
 * @modified by:
 * @version:
 */
public interface MdRegisterCodeDao extends JpaRepository<MdRegisterCode, Long>, JpaSpecificationExecutor<MdRegisterCode> {
    /**
     * 根据注册号查询
     * @param registerCode
     * @return
     */
    MdRegisterCode findByRegisterCodeAndUsedFlag(String registerCode,char usedFlag);

}
