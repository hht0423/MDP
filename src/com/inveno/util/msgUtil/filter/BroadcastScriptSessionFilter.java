package com.inveno.util.msgUtil.filter;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import com.inveno.util.msgUtil.MessageConfigure;
import com.inveno.util.msgUtil.MessageConfigureUtil;
import com.inveno.util.msgUtil.exception.MessageException;
/**  
 *   
 * 椤圭洰鍚嶇О锛� dsp  
 * 绫诲悕绉帮細    BroadcastScriptSessionFilter  
 * 绫绘弿杩帮細    娑堟伅骞挎挱妯″紡鐨勮繃婊ゅ櫒
 * 鍒涘缓浜猴細    Alex  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍3:34:16  
 * 淇敼浜猴細    Alex
 * 淇敼鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍3:34:16  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class BroadcastScriptSessionFilter implements ScriptSessionFilter,MessageConfigure {
	//use the factory model to get the instance
	protected BroadcastScriptSessionFilter(){
		
	}
	/* <span>get the instance from configure<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static ScriptSessionFilter create() throws MessageException{
		ScriptSessionFilter filter;
		try{
			filter=(ScriptSessionFilter)MessageConfigureUtil.getClass(BROADCAST_SCRIPTSESSION_FILTER,"com.inveno.util.msgUtil.filter.BroadcastScriptSessionFilter").newInstance();

		}catch(Throwable t){
			throw new MessageException("fail to create BroadcastScriptSessionFilter from configure",t);
		}
		return filter;
	}
	/* <span>filter the session the one who send the message with unicast_model<span>
	 * @param  session   the session that message sender connect with sever
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	@Override
	public boolean match(ScriptSession arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
