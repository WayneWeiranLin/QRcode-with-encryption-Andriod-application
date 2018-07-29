package com.zxing.rsa;

import java.security.*;
import java.security.interfaces.*;
import javax.crypto.*;

public class RSAAlgorithm {
    
    public static RSAPrivateKey privateKey;	//��Կ
    public static RSAPublicKey publicKey;	//˽Կ
    public static byte[] resultBytes; 	//���ܺ�Ķ�ά����Ϣ
    
    public RSAAlgorithm(String message){
        try{
//            String message = "�㶫ʡ������Խ����";
            
//            Test p = new Test();
//            System.out.println("������" + message);
            
            //���ɹ�Կ��˽Կ�ԣ�����RSA�㷨���ɶ���
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            
            //��ʼ����Կ������������Կ��СΪ1024λ
            keyPairGen.initialize(1024);
            
            //����һ����Կ�ԣ�������keyPair��
            KeyPair keyPair = keyPairGen.generateKeyPair();
            
            //�õ�˽Կ�͹�Կ
            privateKey =(RSAPrivateKey) keyPair.getPrivate();
            publicKey = (RSAPublicKey)keyPair.getPublic();
            
            
//            System.out.println(privateKey.toString());
            
            //�ù�Կ����
//            byte[] srcBytes = message.getBytes();
//            resultBytes = RSAAlgorithm.encrypt(publicKey, srcBytes);
//            String result = new String(resultBytes);
//            System.out.println("�ù�Կ���ܺ�������:" + result);
            
//            return privateKey;
//            //��˽Կ����
//            byte[] decBytes = Test.decrypt(privateKey,resultBytes);
//            String dec = new String(decBytes);
//            System.out.println("��˽Կ���ܺ�Ľ����:" + dec);
        }catch(Exception e){
            e.printStackTrace();
        }
//        return null;
    }
    
    public static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes){
        if(publicKey != null){            
            try{
                //Cipher������ɼ��ܻ���ܹ���������RSA
                Cipher cipher = Cipher.getInstance("RSA");
                
                //���ݹ�Կ����Cipher������г�ʼ��
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                
                //���ܣ���������resultBytes��������
                byte[] resultBytes = cipher.doFinal(srcBytes);
                return resultBytes;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static byte[] decrypt(RSAPrivateKey privateKey,byte[] encBytes){
        if(privateKey != null){
            try{
                Cipher cipher = Cipher.getInstance("RSA");
                
                //����˽Կ��Cipher������г�ʼ��
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                
                //���ܲ�����������resultBytes
                byte[] decBytes = cipher.doFinal(encBytes);
                return decBytes;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}