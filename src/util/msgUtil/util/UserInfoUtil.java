package  util.msgUtil.util;

import javax.servlet.http.HttpSession;

import util.msgUtil.MessageConfigure;
import util.msgUtil.exception.MessageException;

/**  
 *   
 * 椤圭洰鍚嶇О锛�?   dsp  
 *  绫诲悕绉帮細    UserInfoUtil  
 *  绫绘弿杩帮細    淇濆瓨鍜屾彁鍙栫敤鎴风櫥闄嗕俊鎭�?
 *  鍒涘缓浜猴細    Alex 
 * 鍒涘缓鏃堕棿锛�  2016骞�3鏈�10鏃� 
 * 淇敼鏃堕棿锛�  2016骞�3鏈�10鏃� 
 * 淇敼澶囨敞锛�  
 * @version 1.2
 *   
 */
public class UserInfoUtil {
	//Factory model constructor
    private UserInfoUtil(){
    	
    }
	/* <span>set user id <span>
	 * @param  session   the user's context connect with system 
	 * @param  userId    the user's id
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static void setUserId(HttpSession session,String userId) throws MessageException{
		try{
			if(session==null||userId==null){
				return;
			}
			session.setAttribute(MessageConfigure.MSG_SUER_ID, userId);
		}catch(Throwable t){
			throw new MessageException("fail to set user id",t);
		}
		
     }
	/* <span>get user id <span>
	 * @param  session   the user's context connect with system 
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static String getUserId(HttpSession session) throws MessageException{
		try{
			if(session==null||session.getAttribute(MessageConfigure.MSG_SUER_ID)==null){
				return null;
			}
			return (String)session.getAttribute(MessageConfigure.MSG_SUER_ID);
		}catch(Throwable t){
			throw new MessageException("fail to get user id",t);
		}
		
     }
	/* <span>get user massId <span>
	 * @param  session   the user's context connect with system 
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static String getMassId(HttpSession session) throws MessageException{
		try{
			if(session==null||session.getAttribute(MessageConfigure.MSG_MASS_ID)==null){
				return null;
			}
			return (String)session.getAttribute(MessageConfigure.MSG_MASS_ID);
		}catch(Throwable t){
			throw new MessageException("fail to get user massId",t);
		}
		
     }
	/* <span>set user massId <span>
	 * @param  session   the user's context connect with system 
	 * @param  massId    the user's massId
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static void setMassId(HttpSession session,String massId) throws MessageException{
		try{
			if(session==null||massId==null){
				return;
			}
			session.setAttribute(MessageConfigure.MSG_MASS_ID, massId);
		}catch(Throwable t){
			throw new MessageException("fail to set user massId",t);
		}
		
     }
	/* <span>get user information <span>
	 * @param  session   the user's context connect with system 
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static Object getUserInfo(HttpSession session) throws MessageException{
		try{
			if(session==null||session.getAttribute(MessageConfigure.SUER_INFO_MAP)==null){
				return null;
			}
			return session.getAttribute(MessageConfigure.SUER_INFO_MAP);
		}catch(Throwable t){
			throw new MessageException("fail to set user information",t);
		}
	}
	/* <span>set user information <span>
	 * @param  session   the user's context connect with system 
	 * @author Alex
	 * @Date   2016-3-9
	 * */
	public static  void setUserInfo(HttpSession session,Object obj){
		if(session==null||obj==null){
			return;
		}
		session.setAttribute(MessageConfigure.SUER_INFO_MAP, obj);
	}
}
