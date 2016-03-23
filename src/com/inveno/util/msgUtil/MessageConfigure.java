
package  com.inveno.util.msgUtil;
/**  
*   
* 椤圭洰鍚嶇О锛� dsp  
*  绫诲悕绉帮細  MessageConfigure  
*  绫绘弿杩帮細  瀹炴椂娑堟伅妗嗘灦甯搁噺閰嶇疆淇℃伅
*  鍒涘缓浜猴細  Alex 
* 鍒涘缓鏃堕棿锛�2016骞�3鏈�10鏃� 
* 淇敼鏃堕棿锛�2016骞�3鏈�10鏃� 
* 淇敼澶囨敞锛�  
* @version 1.2
*   
*/
public interface MessageConfigure {
	//鍗曟挱浼氳瘽杩囨护鍣�
	public static final String UNICAST_SCRIPTSESSION_FILTER="message.unicast.scriptsession.filter";
	//缇ゅ彂
	public static final String MASS_SCRIPTSESSION_FILTER="message.mass.scriptsession.filter";
	//澶氭挱浼氳瘽杩囨护鍣�
	public static final String BROADCAST_SCRIPTSESSION_FILTER="message.broadcast.scriptsession.filter";
    //浼氳瘽浜嬩欢鐩戝惉鍣�
	public static final String SCRIPTSESSION_EVENT_LISTENER="message.scriptsession.event.listener";
	//鍗曟挱浠诲姟
	public static final String UNICAST_TASK="message.unicast.task";
	//澶氭挱浠诲姟
	public static final String BROADCAST_TAST="message.broadcast.task";
	
	//妗嗘灦session涓敤鎴蜂俊鎭弬鏁�
	public static final String MSG_SUER_ID="msgUserId";
	//妗嗘灦session涓敤鎴风兢id鍙傛暟
	public static final String MSG_MASS_ID="msgMassId";
	//妗嗘灦session涓敤鎴蜂俊鎭弬鏁�
	public static final String SUER_INFO_MAP="userInfoMap";
    //鐢ㄦ埛id鍙傛暟
	public static final String USER_ID="userId";
	//鐢ㄦ埛缇d鍙傛暟
	public static final String MASS_ID="massId";
	//娑堟伅澶勭悊鏂规硶
	public static final String MESSAGE_SHOW_HANDLER="msgHandler";
	//
	public static final String IS_MESSAGE_BROADCAST_CHECK="is.message.broadcast.check";
}
