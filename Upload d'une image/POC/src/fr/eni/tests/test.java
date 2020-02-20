package fr.eni.tests;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class test {

	public static void main(String[] args) {
		List<String> emails = new ArrayList<>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");

		// Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");

		//

		// String regex = "^(.+)@(.+)$";
		// String regex =
		// "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		//
		// String email = "machin@truc.fr";
		//
		// Pattern pattern = Pattern.compile(regex);
		// Matcher matcher = pattern.matcher(email);
		// if (matcher.matches()) {
		// System.out.println(email + " est une adresse mail");
		//
		// } else {
		// System.out.println(email + " n'est pas une adresse mail");
		// }

		String pass = "teseeezaazzatzz123";

		// byte[] uniqueKey = pass.getBytes();
		// byte[] hash = null;
		// try {
		// hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		// }
		// catch (Exception e) { // Il ne doit jamais avoir d'erreurs ici
		// e.printStackTrace();
		// }
		// StringBuffer hashString = new StringBuffer();
		// for (int i=0; i<hash.length; ++i ) {
		// String hex = Integer.toHexString(hash[i]);
		// if (hex.length() == 1) {
		// hashString.append('0');
		// hashString.append(hex.charAt(hex.length()-1));
		// }
		// else {
		// hashString.append(hex.substring(hex.length()-2));
		// }
		// }
		// System.out.println(hashString.toString());

		// String hash = "35454B055CC325EA1AF2126E27707052";
		String password = "ILoveJava";

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

		System.out.println(myHash);

		String passw = "IloveJava";
		MessageDigest md2 = null;
		try {
			md2 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md2.update(passw.getBytes());
		byte[] digest2 = md2.digest();
		String myHash2 = DatatypeConverter.printHexBinary(digest2).toUpperCase();

		System.out.println(myHash.equals(myHash2));

		System.out.println("\n\n");

		File f = new File("C:/TEST");
		try{
		    if(f.mkdir()) { 
		        System.out.println("Directory Created");
		    } else {
		        System.out.println("Directory is not created");
		    }
		} catch(Exception e){
		    e.printStackTrace();
		} 

		// MessageDigest digest = null;
		// try {
		// digest = MessageDigest.getInstance("SHA-1");
		// } catch (NoSuchAlgorithmException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// byte[] encodedhash = digest.digest(
		// pass.getBytes(StandardCharsets.UTF_8));
		//
		// StringBuffer hexString = new StringBuffer();
		// for (int i = 0; i < encodedhash.length; i++) {
		// String hex = Integer.toHexString(0xff & encodedhash[i]);
		// if(hex.length() == 1) hexString.append('0');
		// hexString.append(hex);
		// }
		//
		// System.out.println(hexString.toString());
		// System.out.println(hexString.toString().length());

	}

}
