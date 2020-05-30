package cmcc.iot.onenet.javasdk.http;

import cmcc.iot.onenet.javasdk.exception.OnenetApiException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpGetMethod extends BasicHttpMethod {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	HttpGet httpGet;

	public HttpGetMethod(Method method) {
		super(method);

	}

	public HttpResponse execute() throws Exception {
		HttpResponse httpResponse = null;
		httpClient = HttpClients.createDefault();

		httpResponse = httpClient.execute(httpRequestBase);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK && statusCode != 221) {
			String response = EntityUtils.toString(httpResponse.getEntity());
			logger.error("request failed  status:{}, response::{}",statusCode, response);
			throw new OnenetApiException("request failed: " + response);
		}

		return httpResponse;
	}
}
