package  com.inveno.util.msgUtil.filter;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import com.inveno.util.msgUtil.MessageConfigure;
import com.inveno.util.msgUtil.MessageConfigureUtil;
import com.inveno.util.msgUtil.exception.MessageException;
/**  
 *   
 * 椤圭洰鍚嶇О锛歞sp  
 * 绫诲悕绉帮細    UnicastSciptSessionFilter  
 * 绫绘弿杩帮細    娑堟伅鍗曟挱妯″紡涓嬪浼氳瘽鐨勮繃婊�
 * 鍒涘缓浜猴細    Alex  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍2:54:40  
 * 淇敼鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍2:54:40  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class UnicastScriptSessionFilter implements ScriptSessionFilter {
	//use the factory model to get the instance
	protected UnicastScriptSessionFilter(){
		
	}
	/* <span>  get the instance from configure<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static ScriptSessionFilter create() throws MessageException{
		ScriptSessionFilter filter;
		try{
			filter=(ScriptSessionFilter)MessageConfigureUtil.getClass(MessageConfigure.UNICAST_SCRIPTSESSION_FILTER,"com.inveno.util.msgUtil.filter.UnicastScriptSessionFilter").newInstance();

		}catch(Throwable t){
			throw new MessageException("fail to create UnicastScriptionFilter from configure",t);
		}
		return filter;
	}
	/* <span>  filter the session the one who send the message with unicast_model<span>
	 * @param  session   the session that message sender connect with sever
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	@Override
	public boolean match(ScriptSession session) {
		// TODO Auto-generated method stub
	    return true;
	}

}
