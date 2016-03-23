package  util.msgUtil.task;
import java.util.Collection;
import java.util.HashMap;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

import util.msgUtil.MessageConfigure;
import util.msgUtil.exception.MessageException;
import util.msgUtil.util.MsgPropertiesUtil;

/**  
 *   
 * 椤圭洰鍚嶇О锛歞sp  
 * 绫诲悕绉帮細    UnicastTask  
 * 绫绘弿杩帮細    鍗曟挱妯″紡涓嬬殑娑堟伅鍙戦�佷换鍔�?
 * 鍒涘缓浜猴細    Alex  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪�?3:09:20  
 * 淇敼浜猴細    Alex  
 * 淇敼鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪�?3:09:20  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class UnicastTask implements Runnable {
	private ScriptBuffer script = new ScriptBuffer();
	private String message="";//娑堟伅淇℃伅
	private String userId="";//娑堟伅鍙戦�佸璞�
	private String pageUrl="";
	/* <span>Factory model constructor<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	private UnicastTask(){
		
	}
	/* <span>the Factory model method to create an Instance<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static UnicastTask  create(String message,String userId,String pageUrl) throws MessageException{
		UnicastTask unicastTask;
		try{
			unicastTask=new UnicastTask();
			unicastTask.message=message;
			unicastTask.userId=userId;
			if(pageUrl!=null){
				unicastTask.pageUrl=pageUrl;
			}
		}catch(Throwable t){
			throw new MessageException("fail to create UnicastTask",t);
		}
		return unicastTask;

	}
	/* <span>put the message handler business to a thread task<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Collection<ScriptSession> sessions = Browser.getTargetSessions(); 
        //鑾峰彇娑堟伅鎺ユ敹鏂圭殑js娑堟伅鎺ユ敹鏂规硶鍚嶇�?
        String msgHandler=MsgPropertiesUtil.getValueWithDefault(MessageConfigure.MESSAGE_SHOW_HANDLER,"showMessage");
        script.appendCall(msgHandler, message);
        for (ScriptSession scriptSession : sessions) {
        	//鎯虫寚�?�氱殑鐢ㄦ埛杩涜娑堟伅浼犳�?
        	if(scriptSession.getAttribute(MessageConfigure.USER_ID) != null&&
        			(scriptSession.getAttribute(MessageConfigure.USER_ID)).equals(userId)){
        			  
    			  if(pageUrl!=null&&!"".equals(pageUrl)){
    	        		//鍚戞寚�?�氶〉闈㈢殑娴忚鍣ㄥ彂閫佹秷鎭�?
    	        		if(pageUrl.equals(scriptSession.getPage())){
    	        			scriptSession.addScript(script);
    	        		}
    	          }else{
    	        	    scriptSession.addScript(script);
    	          }
        	}
        
        }
	}

}
