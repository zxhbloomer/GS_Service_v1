package com.perfect.bean.pojo.mqsender.builder;

import com.alibaba.fastjson.JSON;
import com.perfect.bean.pojo.mqsender.MqMessagePojo;
import com.perfect.bean.pojo.mqsender.MqSenderPojo;
import com.perfect.bean.pojo.reflection.CallInfoReflectionPojo;
import com.perfect.common.enumconfig.MqSenderEnum;
import com.perfect.common.enumconfig.quartz.QuartzEnum;
import com.perfect.common.utils.UuidUtil;

/**
 * @ClassName: MqSenderPojoBuilder
 * @Description: TODO
 * @Author: zxh
 * @date: 2019/10/17
 * @Version: 1.0
 */
public class MqSenderPojoBuilder {

    /**
     * 构筑mq的bean
     * @param messageData
     * @return
     */
    public static MqSenderPojo buildMqSenderPojo(Object messageData, MqSenderEnum mqSenderEnum, String job_name){
        MqSenderPojo mqSenderPojo = MqSenderPojo.builder()
            .mqMessagePojo(
                MqMessagePojo.builder()
                    .messageBeanClass(messageData.getClass().getName())
                    .parameterJson(JSON.toJSONString(messageData))
                    .build()
            )
            .key(UuidUtil.randomUUID())
            .type(mqSenderEnum.getCode().toString())
            .name(mqSenderEnum.getName())
            .callBackInfo(null)
            .job_name(job_name)
            .build();
        return mqSenderPojo;
    }

    /**
     * 构筑mq的bean
     * @param messageData
     * @param callBackClasz
     * @param functionName
     * @param callBackPara
     * @return
     */
    public MqSenderPojo buildMqSenderPojo(Object messageData, String callBackClasz, String functionName, Object callBackPara, MqSenderEnum mqSenderEnum){
        MqSenderPojo mqSenderPojo = MqSenderPojo.builder()
            .mqMessagePojo(
                MqMessagePojo.builder()
                    .messageBeanClass(messageData.getClass().getName())
                    .parameterJson(JSON.toJSONString(messageData))
                    .build()
            )
            .key(UuidUtil.randomUUID())
            .type(mqSenderEnum.getCode().toString())
            .name(mqSenderEnum.getName())
            .callBackInfo(
                CallInfoReflectionPojo.builder()
                    .className(callBackClasz)
                    .functionName(functionName)
                    .parameterBeanClass(callBackPara.getClass().getName())
                    .parameterJson(JSON.toJSONString(callBackPara))
                    .build()
            )
            .build();
        return mqSenderPojo;
    }
}
