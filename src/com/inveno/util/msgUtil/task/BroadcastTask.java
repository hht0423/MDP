package  com.inveno.util.msgUtil.task;
import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.inveno.util.msgUtil.MessageConfigure;
import com.inveno.util.msgUtil.exception.MessageException;
import com.inveno.util.msgUtil.util.MsgPropertiesUtil;
/**  
 *   
 * 椤圭洰鍚嶇О锛歞sp  
 * 绫诲悕绉帮細BroadcastTask  
 * 绫绘弿杩帮細  
 * 鍒涘缓浜猴細Administrator  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍3:36:06  
 * 淇敼浜猴細Administrator  
 * 淇敼鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪崍3:36:06  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class BroadcastTask implements Runnable {
	private ScriptBuffer script = new ScriptBuffer();
	private String message="";//娑堟伅淇℃伅
	private String pageUrl="";
	private BroadcastTask(){
		
	}
	public static BroadcastTask create(String message,String pageUrl) throws MessageException{
		BroadcastTask task;
		try{
			task=new BroadcastTask();
			task.message=message;
			if(pageUrl!=null){
				task.pageUrl=pageUrl;
			}
		}catch(Throwable t){
			throw new MessageException("fail to create BroadcastTask",t);
		}
		return task;
		
	}
	/* <span>put the message handler business to a thread task<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Collection<ScriptSession> sessions = Browser.getTargetSessions();
        String msgHandler=MsgPropertiesUtil.getValueWithDefault(MessageConfigure.MESSAGE_SHOW_HANDLER,"showMessage");
        script.appendCall(msgHandler, message);
        for (ScriptSession scriptSession : sessions) {
        	System.out.println("page:"+scriptSession.getPage());
        	//鏄瀵圭櫥闄嗙敤鎴疯繘琛屾牎楠�
        	if("1".equals(MsgPropertiesUtil.getValueWithDefault(MessageConfigure.IS_MESSAGE_BROADCAST_CHECK, "0"))&&scriptSession.getAttribute(MessageConfigure.USER_ID) == null){
                  return;
        	}else if(pageUrl!=null&&!"".equals(pageUrl)){
        		//鎯虫寚瀹氶〉闈㈢殑娴忚鍣ㄥ彂閫佹秷鎭�
        		if(pageUrl.equals(scriptSession.getPage())){
        			scriptSession.addScript(script);
        		}
        	}else{
      		  //鑾峰彇娑堟伅鎺ユ敹鏂圭殑js娑堟伅鎺ユ敹鏂规硶鍚嶇О
      			  scriptSession.addScript(script);
        	}
        
        }
	}
	

}
