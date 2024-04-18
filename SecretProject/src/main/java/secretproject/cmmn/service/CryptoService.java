package secretproject.cmmn.service;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cryptography.EgovCryptoService;
import egovframework.rte.fdl.cryptography.EgovPasswordEncoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("cryptoService")
public class CryptoService {
	
	@Autowired(required=false)
	@Qualifier("ARIACryptoService")
    EgovCryptoService cryptoService;
	
	@Autowired(required=false)
	@Qualifier("passwordEncoder")
    private EgovPasswordEncoder passwordEncoder;
	
    public static String pw = "egovframe";
    
    public static String passwdAlgorithm = "SHA-256";

    public String encryptData(String plainText) {
    	String encodeText = null;
    	 try {
             byte[] encrypted = cryptoService.encrypt(plainText.getBytes("UTF-8"), pw);
             encodeText = Base64.encodeBase64String(encrypted);
         } catch(UnsupportedEncodingException uee) {
             uee.printStackTrace();
             uee.getCause();
             log.error("{}", uee.getCause());
         }
         return encodeText;
    }
    
    public String decryptData(String encodeText) {
    	String plainText = null;
    	try {
            byte[] base64dec = Base64.decodeBase64(encodeText);
            byte[] decrypted = cryptoService.decrypt(base64dec, pw);
            plainText = new String(decrypted, "UTF-8");
        } catch(UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        return plainText;
    }
}
