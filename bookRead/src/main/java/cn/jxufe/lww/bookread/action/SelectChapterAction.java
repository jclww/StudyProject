package cn.jxufe.lww.bookread.action;

public class SelectChapterAction {
//	private String book;
//	private String chapter;
//	public String select(){
//	    HttpServletResponse response=ServletActionContext.getResponse();
//	    HttpServletRequest reques=ServletActionContext.getRequest();
//
//
//	    if(reques.getParameter("chapter")==null)
//	    {
//	    	book = reques.getParameter("book");
//
//	    	SelectChapter s = new SelectChapter();
//			s.setBookid(book);
//			s.getBookList();
//
//		    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
//		    String bookinfo = s.getBookinfo();
//		    String chapterlist = s.getChapter();
//		    JSONObject a = new JSONObject();
//		    a.put("bookinfo", bookinfo);
//		    a.put("chapterlist", chapterlist);
//		    reques.setAttribute("data", a.toString());
//	    	return "BOOK";
//	    }
//	    else if(reques.getParameter("chapter")!=null)
//	    {
//	    	book = reques.getParameter("book");
//	    	chapter = reques.getParameter("chapter");
//
//	    	SelectContent s = new SelectContent();
//			s.setBookid(book);
//			s.setChapterid(chapter);
//			s.getBookList();
//
//		    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
//		    String chaptertitle = s.getChaptertitle();
//		    String chaptercontent = s.getChaptercontent();
//		    JSONObject a = new JSONObject();
//		    a.put("chaptertitle", chaptertitle);
//		    a.put("chaptercontent", chaptercontent);
//		    reques.setAttribute("data", a.toString());
//
//
//
//	    	return "CHAPTER";
//
//	    }
//	    return "ERROR";
//
//
//	}
}
