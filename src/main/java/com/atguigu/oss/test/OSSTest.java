package com.atguigu.oss.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;

public class OSSTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";     //阿里云服务
		
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
		String accessKeyId = "LTAIRyb77bOaduym";
		String accessKeySecret = "oI7ziHH0vEcDT3SzPnROgzWLKXdmW6";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
		// 桶名
		String bucketName = "crowd190105";
		
		// 文件名
		String fileName = "444.jpg";
		
		// 对象名
		String objectName = "fruit/red/"+fileName;

		// 上传文件流。
		InputStream inputStream = new FileInputStream(fileName);
		ossClient.putObject(bucketName, objectName, inputStream);

		// 关闭OSSClient。
		ossClient.shutdown();
	}

}
