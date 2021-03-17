package com.my.controller.youzan;

import com.alibaba.fastjson.JSON;
import com.my.common.CommonJsonResult;
import com.my.util.HttpRequestUtil;
import com.my.util.YouzanTokenUtil;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanTradeGet;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeGetParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeGetResult;
import com.youzan.open.sdk.util.json.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于手动导入单个订单号到数据库
 * Created by wt on 2017/8/3.
 */
@RestController
public class YouzanTradeInfoController {

    private static Logger logger = LoggerFactory.getLogger(YouzanTradeInfoController.class);


    @RequestMapping(value = "getTradeByTid")
    public CommonJsonResult getTradeByTid(@RequestParam(required = true) String  tid) throws Exception {
        CommonJsonResult commonJsonResult = new CommonJsonResult();

        YZClient client = new DefaultYZClient(new Token(YouzanTokenUtil.getToken()));
        YouzanTradeGetParams youzanTradeGetParams = new YouzanTradeGetParams();

        youzanTradeGetParams.setTid(tid);

        YouzanTradeGet youzanTradeGet = new YouzanTradeGet();
        youzanTradeGet.setAPIParams(youzanTradeGetParams);
        YouzanTradeGetResult result = client.invoke(youzanTradeGet);

        YouzanTradeGetResult.TradeDetailV2 trade = result.getTrade();
        commonJsonResult.setInfoMap("tradeInfo", JSON.toJSONString(trade));

        return commonJsonResult;

    }



}
