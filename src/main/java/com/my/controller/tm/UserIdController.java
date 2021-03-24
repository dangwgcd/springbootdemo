package com.my.controller.tm;

import com.my.common.BaseDao;
import com.my.common.CommonJsonResult;
import com.my.util.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wt on 2017/12/18.
 */
@RestController
public class UserIdController {
    private Logger logger = LoggerFactory.getLogger(UserIdController.class);

    @Autowired
    private BaseDao betaBaseDao;

    @Autowired
    private BaseDao tmpBaseDao;

    @GetMapping("getDifferentUserIds")
    public CommonJsonResult getDifferentUserIds() {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        List<Integer> userIdsFromBeta = this.betaBaseDao.selectList("TmMapper.selectUserIdsFromBeta");
        List<Integer> userIdsFromTmp = this.tmpBaseDao.selectList("TmMapper.selectUserIdsFromTmp");

        logger.info("userIdsFromBeta'size："+userIdsFromBeta.size());
        logger.info("userIdsFromTmp'size："+userIdsFromTmp.size());

        List<Integer> difference = ListUtils.difference(userIdsFromBeta, userIdsFromTmp);
//        List<Integer> difference = ListUtils.difference(userIdsFromTmp,userIdsFromBeta);
        commonJsonResult.setResultList(difference);


        return commonJsonResult;
    }
}
