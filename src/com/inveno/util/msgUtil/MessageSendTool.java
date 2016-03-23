package  com.inveno.util.msgUtil;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessionFilter;

import com.inveno.util.msgUtil.exception.MessageException;
import com.inveno.util.msgUtil.filter.BroadcastScriptSessionFilter;
import com.inveno.util.msgUtil.filter.MassScriptSessionFilter;
import com.inveno.util.msgUtil.filter.UnicastScriptSessionFilter;
import com.inveno.util.msgUtil.task.BroadcastTask;
import com.inveno.util.msgUtil.task.MassTask;
import com.inveno.util.msgUtil.task.UnicastTask;
/**  
*   
* 项目名称：  dsp  
*  类名称：   MessageSendTool  
*  类描述：   消息发送工具类
*  创建人：   Alex 
* 创建时间：  2016年3月10日 
* 修改时间：  2016年3月10日 
* 修改备注：  
* @version 1.2
*   
*/
public class MessageSendTool implements MessageConfigure{
	private final String SUCCEED="1";//message send succeed
	private final String FAILED="0";//message send failed
	/* <span>send message to browser that specified user have  login<span>
	 * @param  userid   the it of user who receive the message
	 * @param  message  message information
	 * @param  pageurl  specified the page to send message
	 * @author Alex
	 * @Date   2016-3-9
	 * */
    public String msgUnicast(String userId, String message,String pageUrl) throws MessageException{
    	ScriptSessionFilter filter;
    	Runnable task;
    	try {
			filter=UnicastScriptSessionFilter.create();
			task=UnicastTask.create(message, userId,pageUrl);
			Browser.withAllSessionsFiltered(filter,task );
    	} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new MessageException("fail to  unicast message!",t);
			return FAILED;
		}
    	return SUCCEED;
    
    }
	/* <span>send message to browsers that all the user subscribed<span>
	 * @param  userid   the it of user who receive the message
	 * @param  message  message information
	 * @param  pageurl  specified the page to send message
	 * @author Alex
	 * @Date   2016-3-9
	 * */
    public String msgBroadcast(String message,String pageUrl) throws MessageException{
    	ScriptSessionFilter filter;
    	Runnable task;
    	try {
			filter=BroadcastScriptSessionFilter.create();
			task=BroadcastTask.create(message,pageUrl);
			Browser.withAllSessionsFiltered(filter,task );
    	} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new MessageException("Cannot instantiate ScriptSessionFilter from configure!",t);
    		return FAILED;//后台出现异常
		}
    	  return SUCCEED;
    }
	/* <span>send message to browsers that all the user subscribed<span>
	 * @param  userid   the it of user who receive the message
	 * @param  message  message information
	 * @param  pageurl  specified the page to send message
	 * @author Alex
	 * @Date   2016-3-9
	 * */
    public String msgMass(String massId,String message,String pageUrl) throws MessageException{
    	ScriptSessionFilter filter;
    	Runnable task;
    	try {
			filter=MassScriptSessionFilter.create();
			task=MassTask.create(message,massId,pageUrl);
			Browser.withAllSessionsFiltered(filter,task );
    	} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new MessageException("Cannot instantiate ScriptSessionFilter from configure!",t);
    	    return FAILED;	
		}
    	  return SUCCEED;
    }
}