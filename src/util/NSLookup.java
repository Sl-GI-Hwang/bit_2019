package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.soap.SAAJResult;

public class NSLookup {

	public static void main(String[] args) {
		try {
			while(true) {
				System.out.print("> ");
				Scanner s = new Scanner(System.in);
				String site = s.next();
				if(site.equals("exit")) {
					break;
				}				
				InetAddress[] inetAddresses = InetAddress.getAllByName(site);

				for(InetAddress inetAddress : inetAddresses) {
					System.out.println(site + " : " + inetAddress.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}



	}

}
