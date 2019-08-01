package com.loki.rfidtrack.apitrack.primary.service.impl;

import com.loki.rfidtrack.apitrack.primary.dao.MdRegisterCodeDao;
import com.loki.rfidtrack.apitrack.primary.entity.MdRegisterCode;
import com.loki.rfidtrack.apitrack.primary.service.MdRegisterCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MdRegisterCodeServiceImpl implements MdRegisterCodeService {

    @Autowired
    MdRegisterCodeDao registerCodeDao;
    @Transactional
    @Override
    public boolean checkRegisterCode(String registerCode)
    {
       MdRegisterCode mdRegisterCode= registerCodeDao.findByRegisterCodeAndUsedFlag(registerCode,'0');
     if(mdRegisterCode!=null) {
         mdRegisterCode.setUsedFlag('1');
         registerCodeDao.save(mdRegisterCode);
         return true;
     }else {
         return false;
     }
    }
}
