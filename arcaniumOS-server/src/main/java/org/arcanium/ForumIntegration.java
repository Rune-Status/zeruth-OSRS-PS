package org.arcanium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForumIntegration {

    private static final int CRYPTION_ID = 4191941;

    public static int validate(String user, String pass) {
	try {
	    String urlString = "http://arcanium.org/validation/index.php?crypt=" + CRYPTION_ID + "&name=" + user + "&pass=" + pass;
	    HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line = in.readLine().trim();
	    try {
		int returnCode = Integer.parseInt(line);
		//System.out.println("returnCode: " + returnCode);

		switch (returnCode) {
		case -1:
		   // System.out.println("Wrong CRYPTION_ID");
		    return 10;
		case 1:
		    return 3;
		case 0:
		    return 12;
		default:
		    int member_group_id = returnCode - 2;
		    //System.out.println("SUCCESS");
		    return 2;
		}
	    } catch (Exception e) {
		e.printStackTrace();
		return 8;
	    }
	} catch (Exception e2) {
	    e2.printStackTrace();
	}
	return 11;
    }
}