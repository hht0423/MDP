package  util.msgUtil;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

import util.msgUtil.exception.MessageException;
import util.msgUtil.util.UserInfoUtil;

/**   
* 椤圭洰鍚嶇О锛�?  dsp  
*  绫诲悕绉帮細   MessageSubScriber  
*  绫绘弿杩帮細   娑堟伅璁㈤槄澶勭�?
*  鍒涘缓浜猴細    Alex 
* 鍒涘缓鏃堕棿锛�  2016骞�3鏈�10鏃� 
* 淇敼鏃堕棿锛�  2016骞�3鏈�10鏃� 
* 淇敼澶囨敞锛�  
* @version 1.2
*   
*/
public class MessageSubScriber {
   public void onPageLoad(HttpSession session) {
		 //鑾峰彇鐢ㄦ埛淇℃�?
         ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
         Object userId = null;
         Object massId=null;
		try {
			userId = UserInfoUtil.getUserId(session);
			massId=UserInfoUtil.getMassId(session);
		} catch (MessageException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(userId!=null){
			scriptSession.setAttribute(MessageConfigure.USER_ID,(String)userId);//鐢ㄦ埛id
		}
        if(massId!=null){
        	scriptSession.setAttribute(MessageConfigure.MASS_ID,(String)massId);//鐢ㄦ埛缇d
        }
         MessageSessionUtil dwrScriptSessionManagerUtil = new MessageSessionUtil();
         try {
        	 dwrScriptSessionManagerUtil.init();
         } catch (ServletException e) {
                e.printStackTrace();
         }
    }
}