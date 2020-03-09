package xft.abscloud.manager.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:/config/pay.properties")
@ConfigurationProperties(prefix = "wx.pay")
@Component
public class PayProperties {

    public static String wxPayUrl;

	public String getWxPayUrl() {
		return wxPayUrl;
	}

	public void setWxPayUrl(String wxPayUrl) {
		PayProperties.wxPayUrl = wxPayUrl;
	}

   

}
