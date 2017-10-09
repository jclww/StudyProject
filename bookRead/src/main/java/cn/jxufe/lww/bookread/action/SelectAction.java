package cn.jxufe.lww.bookread.action;

//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.struts2.ServletActionContext;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//import cn.jxufe.lww.bookread.jsoup.SelectBook;
//import jdk.nashorn.internal.parser.JSONParser;
//import net.sf.json.JSONObject;

public class SelectAction /*extends ActionSupport */{
//	public void select() throws IOException{
//	    HttpServletResponse response=ServletActionContext.getResponse();
//	    HttpServletRequest reques=ServletActionContext.getRequest();
////	    System.out.println(reques.getParameter("selec"));
//
//	    SelectBook s = new SelectBook();
//		s.setBookid(reques.getParameter("selec"));
//		s.getBookList();
//
//	    response.setContentType("text/html;charset=utf-8");
//	    //response.setCharacterEncoding("UTF-8");
//	    PrintWriter out = response.getWriter();
//
//	    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
//	    String list = s.getBooklist();
////	    String foot = s.getBookfoot();
//
//
//	    JSONObject a = new JSONObject();
////	    a.put("foot", foot);
//	    a.put("list", list);
//
////	    String jsonString="{\"list\":\""+list+"\",\"foot\":\""+foot+"\"}";
////	    String jsonString="{\"list\":\"ss\",\"foot\":\"ss\"}";
//
//	    out.println(a.toString());
//	    out.flush();
//	    out.close();
//	}
}
