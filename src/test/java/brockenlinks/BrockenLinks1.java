package brockenlinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.Test;

public class BrockenLinks1 {
	@Test
	public void getLinkStatusCode() throws IOException {
		String link = "https://demoqa.com/links";

		URL url = new URL(link);
		URLConnection con = url.openConnection();
		HttpsURLConnection http = (HttpsURLConnection) con;
		http.setConnectTimeout(15000);

		http.connect();

		int code = http.getResponseCode();
		System.out.println(code);

		String msg = http.getResponseMessage();

		System.out.println(msg);

	}

}
