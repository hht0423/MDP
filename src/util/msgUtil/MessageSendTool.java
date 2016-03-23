package  util.msgUtil;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessionFilter;

import util.msgUtil.exception.MessageException;
import util.msgUtil.filter.BroadcastScriptSessionFilter;
import util.msgUtil.filter.MassScriptSessionFilter;
import util.msgUtil.filter.UnicastScriptSessionFilter;
import util.msgUtil.task.BroadcastTask;
import util.msgUtil.task.MassTask;
import util.msgUtil.task.UnicastTask;
/**  
*   
* 项目名称�?  dsp  
*  类名称：   MessageSendTool  
*  类描述：   消息发�?�工具类
*  创建人：   Alex 
* 创建时间�?  2016�?3�?10�? 
* 修改时间�?  2016�?3�?10�? 
* 修改备注�?  
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