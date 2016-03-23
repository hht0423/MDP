package  util.msgUtil.filter;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import util.msgUtil.MessageConfigure;
import util.msgUtil.MessageConfigureUtil;
import util.msgUtil.exception.MessageException;


/**  
 *   
 * 椤圭洰鍚嶇О锛�?   dsp  
 *  绫诲悕绉帮細    MassScriptSessionFilter  
 *  绫绘弿杩帮細    娑堟伅缇ゅ彂杩囨护鍣�?
 *  鍒涘缓浜猴細    Alex 
 * 鍒涘缓鏃堕棿锛�  2016骞�3鏈�12鏃� 
 * 淇敼鏃堕棿锛�  2016骞�3鏈�12鏃� 
 * 淇敼澶囨敞锛�  
 * @version 1.2
 *   
 */
public class MassScriptSessionFilter implements ScriptSessionFilter{
	//use the factory model to get the instance
		protected MassScriptSessionFilter(){
			
		}
		/* <span>  get the instance from configure<span>
		 * @author Alex
		 * @Date   2016-3-9
		 * */
		public static ScriptSessionFilter create() throws MessageException{
			ScriptSessionFilter filter;
			try{
				filter=(ScriptSessionFilter)MessageConfigureUtil.getClass(MessageConfigure.MASS_SCRIPTSESSION_FILTER,"com.inveno.util.msgUtil.filter.MassScriptSessionFilter").newInstance();

			}catch(Throwable t){
				throw new MessageException("fail to create MassScriptSessionFilter from configure",t);
			}
			return filter;
		}
		/* <span>  filter the session the one who send the message with mass_model<span>
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
