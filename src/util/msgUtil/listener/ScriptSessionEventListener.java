package  util.msgUtil.listener;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;

import util.msgUtil.MessageConfigure;
import util.msgUtil.exception.MessageException;
import util.msgUtil.util.UserInfoUtil;

/**  
 *   
 * 椤圭洰鍚嶇О锛歞sp  
 * 绫诲悕绉帮細    ScriptSessonEventListener  
 * 绫绘弿杩帮細    鐢ㄦ埛浼氳瘽鍒涘缓鏃堕棿鐩戝惉鍣�?
 * 鍒涘缓浜猴細    Alex  
 * 鍒涘缓鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪�?4:01:41  
 * 淇敼浜猴細    Alex  
 * 淇敼鏃堕棿锛�2016骞�3鏈�9鏃� 涓嬪�?4:01:41  
 * 淇敼澶囨敞锛�  
 * @version   1.2
 *   
 */
public class ScriptSessionEventListener implements ScriptSessionListener {

	/* (non-Javadoc)
	 * @see org.directwebremoting.event.ScriptSessionListener#sessionCreated(org.directwebremoting.event.ScriptSessionEvent)
	 */
	@Override
	public void sessionCreated(ScriptSessionEvent ev){
		// TODO Auto-generated method stub
        HttpSession session = WebContextFactory.get().getSession();
	    String userId="";
	    String massId="";
		try {
			userId = UserInfoUtil.getUserId(session);
			massId=UserInfoUtil.getMassId(session);
		    if(userId!=null){
		    	ev.getSession().setAttribute(MessageConfigure.USER_ID,userId);
		    
		    }
		    if(massId!=null){
		    	ev.getSession().setAttribute(MessageConfigure.MASS_ID,massId);
		    }
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 
        
	}

	/* (non-Javadoc)
	 * @see org.directwebremoting.event.ScriptSessionListener#sessionDestroyed(org.directwebremoting.event.ScriptSessionEvent)
	 */
	@Override
	public void sessionDestroyed(ScriptSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
