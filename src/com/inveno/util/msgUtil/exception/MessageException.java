package com.inveno.util.msgUtil.exception;

/**  
 *   
 * 椤圭洰鍚嶇О锛�   dsp  
 *  绫诲悕绉帮細    MessageException  
 *  绫绘弿杩帮細    瀹炴椂娑堟伅鎺ㄩ�佸紓甯�
 *  鍒涘缓浜猴細    Alex 
 * 鍒涘缓鏃堕棿锛�  2016骞�3鏈�10鏃� 
 * 淇敼鏃堕棿锛�  2016骞�3鏈�10鏃� 
 * 淇敼澶囨敞锛�  
 * @version 1.2
 *   
 */
public class MessageException extends Exception{
	private static final long serialVersionUID = 1294895177895619948L;
	private MessageException() {
	}

	public MessageException(String message, Throwable t) {
		super(message + "\n embedded exception=" + t.toString());
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(Throwable t) {
		this("MessageException: ", t);
	}

	public String toString() {
		return "MessageException: " + getMessage();
	}
}
