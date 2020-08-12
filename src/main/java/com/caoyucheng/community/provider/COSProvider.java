package com.caoyucheng.community.provider;

import com.caoyucheng.community.exception.CustomizeErrorCode;
import com.caoyucheng.community.exception.CustomizeException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author caoyucheng on 2020/8/11
 */
@Service
@Slf4j
public class COSProvider {
    @Value("${tencent.cloud.secretId}")
    private String secretId;
    @Value("${tencent.cloud.secretKey}")
    private String secretKey;
    @Value("${tencent.cloud.bucketRegion}")
    private String bucketRegion;
    @Value("${tencent.cloud.bucketName}")
    private String bucketName;
    @Value("${tencent.cloud.prefix}")
    private String prefix;
    @Value("${tencent.cloud.expires}")
    private Long expires;

    public String upload(InputStream fileStream, String mimeType, String fileName, Long fileSize) {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region(bucketRegion);
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);

        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 设置输入流长度
            objectMetadata.setContentLength(fileSize);
            // 设置 Content type
            objectMetadata.setContentType(mimeType);
            //设置上传对象最终文件名（COS对象键）
            String objectKey = prefix +'/'+UUID.randomUUID().toString()+'_'+fileName;
            PutObjectResult putObjectResult = cosClient.putObject(bucketName, objectKey, fileStream, objectMetadata);
            if (putObjectResult.getETag() != null) {
                GeneratePresignedUrlRequest req =
                        new GeneratePresignedUrlRequest(bucketName, objectKey, HttpMethodName.GET);
                Date expirationDate = new Date(System.currentTimeMillis() + expires);
                req.setExpiration(expirationDate);
                URL url = cosClient.generatePresignedUrl(req);
                return url.toString();
            } else {
                log.error("upload error,{}", fileName);
                throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
            }
        } catch (CosClientException | IllegalArgumentException e) {
            log.error("upload error,{}", fileName, e);
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
    }
}
