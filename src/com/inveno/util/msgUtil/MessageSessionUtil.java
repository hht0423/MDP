package  com.inveno.util.msgUtil;
import javax.servlet.ServletException;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

import com.inveno.util.msgUtil.listener.ScriptSessionEventListener;
/**  
*   
* 椤圭洰鍚嶇О锛�  dsp  
*  绫诲悕绉帮細   MessageSessionUtil  
*  绫绘弿杩帮細   娑堟伅浼氳瘽绠＄悊绫�
*  鍒涘缓浜猴細    Alex 
* 鍒涘缓鏃堕棿锛�  2016骞�3鏈�10鏃� 
* 淇敼鏃堕棿锛�  2016骞�3鏈�10鏃� 
* 淇敼澶囨敞锛�  
* @version 1.2
*   
*/
public class MessageSessionUtil extends DwrServlet {
	private static final long serialVersionUID = -4632967601940651066L;
	public void init() throws ServletException {
	    Container container = ServerContextFactory.get().getContainer();
	    ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
	    ScriptSessionListener listener = new ScriptSessionEventListener();
	    manager.addScriptSessionListener(listener);
	
	  }

}