package Bank.solarTransit.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Helper {
	public static String sha1(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Map<String, Object> buildResponse(Object data, String status){
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("status", status);
    	result.put("datas", data);
    	return result;
    }
    
    public static Map<String, Object> errorResponse(Object obj){
    	return buildResponse(obj, "400");
    }
    
    public static Map<String, Object> succesResponse(Object obj){
    	return buildResponse(obj, "200");
    }
}
