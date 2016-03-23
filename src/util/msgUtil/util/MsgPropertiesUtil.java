package  util.msgUtil.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**  
 *   
 * 椤圭洰鍚嶇О锛歞sp  
 * 绫诲悕绉帮細    MsgPropertiesUtil  
 * 绫绘弿杩帮細    瀹炴椂娑堟伅鎺ㄩ�侀厤缃枃浠跺伐鍏风被
 * 鍒涘缓浜猴細    Alex  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�10鏃� 涓婂�?10:10:47  
 * 淇敼浜猴細    Alex  
 * 淇敼鏃堕棿锛�2016骞�3鏈�10鏃� 涓婂�?10:10:47  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class MsgPropertiesUtil {
	private static Properties properties;
	public static String getValue(String key) {
	    String value = "";
		if(properties==null) {
			properties = loadProperties();
		}
		value = properties.getProperty(key);
		return value;
	}
	public static String getValueWithDefault(String key,String defaultVal) {
	    String value = "";
		if(properties==null) {
			properties = loadProperties();
		}
		value = properties.getProperty(key);
		
		return value==null?defaultVal:value;
	}
	
	/* <span>loading the properties file<span>
	 * @param  userid   the id of user who receive the message
	 * @param  message  message information
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	private static Properties loadProperties() {
		Properties properties = new Properties();
		InputStream in = null;
		try {
			in = MsgPropertiesUtil.class.getResourceAsStream("/msgconfig.properties");
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	/* <span>get the properties's value<span>
	 * @param  name   the key configured at properties file
	 * @param  defaultName  if the name parameter is null,then get the default name
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static String getValue(String key, String defaultKey) {
	    String _key=key;
		if(properties==null) {
			properties = loadProperties();
		}
		return properties.getProperty(_key, defaultKey);
	}

}
