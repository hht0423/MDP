
package  util.msgUtil;

import util.msgUtil.util.MsgPropertiesUtil;


/**  
*   
* 椤圭洰鍚嶇О锛�? dsp  
*  绫诲悕绉帮細  MessageConfigureUtil  
*  绫绘弿杩帮細  
*  鍒涘缓浜猴細  Alex 
* 鍒涘缓鏃堕棿锛�2016骞�3鏈�10鏃� 
* 淇敼鏃堕棿锛�2016骞�3鏈�10鏃� 
* 淇敼澶囨敞锛�  
* @version 1.2
*   
*/
public class MessageConfigureUtil implements MessageConfigure {
	/**
	 * Factory method: create an object from property denoting class name configured ad properties file.
	 * @param  className property name ,include the full package path
	 * @return defaultClassName the framework default defined 
	 * @throws Exception when class cannot be instantiated
	 * @author Alex
	 * @since  2016-03-10
	 */
	public static Class getClass(String className, String defaultClassName) throws Exception {
		// Singleton + factory pattern:  create object instance
		// from configured class name
		String clazz = (defaultClassName == null ? getProperty(className) : getProperty(className, defaultClassName));
		try {
			return Class.forName(clazz);
		} catch (ClassNotFoundException t) {
		// Usually a misconfiguration
			throw new Exception("Cannot find class for " + className + "=" + clazz, t);
		}
	}
	/**
	 * Factory method: create an object from property denoting class name configured ad properties file.
	 * @param  className property name ,include the full package path
	 * @return defaultClassName the framework default defined 
	 * @throws Exception when class cannot be instantiated
	 * @author Alex
	 * @since  2016-03-10
	 */
	public static String getProperty(String name) {
		String value = MsgPropertiesUtil.getValue(name);
		if (value == null) {
			throw new IllegalArgumentException("Unknown property: " + name);
		}
		return value;
	}
	/* <span>get the properties's value<span>
	 * @param  name   the key configured at properties file
	 * @param  defaultName  if the name parameter is null,then get the default name
	 * @author Alex
	 * @Date   2016-3-10
	 * */
	public static String getProperty(String name,String defaultName) {
		String value = MsgPropertiesUtil.getValue(name,defaultName);
		return value;
	}
}
