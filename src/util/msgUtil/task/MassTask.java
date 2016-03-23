package  util.msgUtil.task;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

import util.msgUtil.MessageConfigure;
import util.msgUtil.exception.MessageException;
import util.msgUtil.util.MsgPropertiesUtil;

/**  
 *   
 * 椤圭洰鍚嶇О锛�?   dsp  
 *  绫诲悕绉帮細    MassTask  
 *  绫绘弿杩帮細  
 *  鍒涘缓浜猴細    Alex 
 * 鍒涘缓鏃堕棿锛�  2016骞�3鏈�12鏃� 
 * 淇敼鏃堕棿锛�  2016骞�3鏈�12鏃� 
 * 淇敼澶囨敞锛�  
 * @version 1.2
 *   
 */
public class MassTask  implements Runnable{
	private ScriptBuffer script = new ScriptBuffer();
	private String message="";//娑堟伅淇℃伅
	private String massId="";//娑堟伅鍙戦�佺兢
	private String pageUrl="";
	/* <span>Factory model constructor<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	private MassTask(){
		
	}
	/* <span>the Factory model method to create an Instance<span>
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static MassTask  create(String message,String massId,String pageUrl) throws MessageException{
		MassTask massTask;
		try{
			massTask=new MassTask();
			massTask.message=message;
			massTask.massId=massId;
			if(pageUrl!=null){
				massTask.pageUrl=pageUrl;
			}
			
		}catch(Throwable t){
			throw new MessageException("fail to create MassTask",t);
		}
		return massTask;

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
        	//鎯虫寚�?�氱殑鐢ㄦ埛缇よ繘琛屾秷鎭紶鎾�?
        	if(scriptSession.getAttribute(MessageConfigure.MASS_ID) != null&&
        			(scriptSession.getAttribute(MessageConfigure.MASS_ID)).equals(massId)){
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
