package com.java.thirdpartservice;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.java.constant.Constants;
import darabonba.core.client.ClientOverrideConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;

@Component
public class AliYunService {
    @Autowired
    private AliYunSmsConfig aliYunSmsConfig;

    //定义方法，用来发送短信 LTAI5tQXmjXUMfQafqmUwHDy
    //5QpEznUThvxPDoWcOs4yXCoxaEb9Nb
    public boolean sendSms(String phone,String code){
        //3.阿里云发送短信密钥(设置成自己)
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(aliYunSmsConfig.getAccessKeyId())
                .accessKeySecret(aliYunSmsConfig.getAccessKeySecret())
                .build());


        AsyncClient client = AsyncClient.builder()
                .region(aliYunSmsConfig.getRegionId()) // Region ID
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride(aliYunSmsConfig.getEndpoint())
                )
                .build();

        String templateParam="{\"code\":\""+code+"\"}"; //{"code":"9878"}
        // Parameter settings for API request
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName(aliYunSmsConfig.getSignName())
                .templateCode(aliYunSmsConfig.getTemplateCode())
                .phoneNumbers(phone)//1.需要发送短信手机号
                .templateParam(templateParam)//2.需要发送的验证码 templateParam("{\"code\":\"code\"}")
                .build();

        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);

        SendSmsResponse resp=null;
        try {
             resp = response.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();

        //4.判断阿里云短信返回的内容
        String message = resp.getBody().getMessage();//获取阿里云返回Message的值
        String codeMsg=resp.getBody().getCode();
        if (Constants.Sms.ALI_SMS_RESULT.equals(message) && Constants.Sms.ALI_SMS_CODE.equals(codeMsg)){
            //发送短信成功
            return true;
        }
        return false;
    }
}
