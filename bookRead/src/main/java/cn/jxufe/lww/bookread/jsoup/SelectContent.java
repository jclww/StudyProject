package cn.jxufe.lww.bookread.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectContent {
	private String bookid;
	private String chapterid;
	private String chaptertitle;
	private String chaptercontent;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getChapterid() {
		return chapterid;
	}
	public void setChapterid(String chapterid) {
		this.chapterid = chapterid;
	}
	private Element content;
	public void getBookList(){
		try {  
            Document doc = Jsoup.connect("http://www.xxbiquge.com/"+bookid+"/"+chapterid+".html").get();
            Elements title = doc.getElementsByClass("bookname");
             content = doc.getElementById("content");
             
            title.get(0).select("div.lm").remove();
            title.get(0).select("a[rel=nofollow]").remove();
            
            Elements pngs = title.get(0).select("a[href]");
			for (Element element : pngs) {
				String url = element.attr("href");
				
				String[] names = url.split("/"); 
				url = "/BookRead/SelectChapter";
				if(names.length==2)
				{
				String book = names[1];
				url+="?book="+book;
				}
				else if(names.length==3)
				{
					String book = names[1];
					String chapter = names[2].substring(0,names[2].length()-5); 
					url+="?book="+book+"&chapter="+chapter;
				}
				element.attr("href", url);
			}
//            
//            String url = title.get(0).select("a[href]").attr("href");
//            String[] names = url.split("/"); 
//            url = "?book="+names[1]+"&chapter="+names[2].substring(0,names[2].length()-5);
//            title.get(0).select("a[href]").attr("href",url);
//            System.out.println(title);
            
            chaptertitle = title.toString();
            chaptercontent = content.toString();
            
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
	public String getChaptertitle() {
		return chaptertitle;
	}
	public void setChaptertitle(String chaptertitle) {
		this.chaptertitle = chaptertitle;
	}
	public String getChaptercontent() {
		return chaptercontent;
	}
	public void setChaptercontent(String chaptercontent) {
		this.chaptercontent = chaptercontent;
	}
}
