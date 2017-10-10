package cn.jxufe.lww.bookread.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectChapter {
	private String bookid;
	private String bookinfo;
	private String chapter;
	public void getBookList(){
		try {  
            Document doc = Jsoup.connect("http://www.xxbiquge.com/"+bookid).get();  
            Elements book = doc.getElementsByClass("box_con");
            book.get(0).select("div.con_top").remove();
            book.get(0).select("div#listtj").remove();
            String url = book.get(0).select("a[target=_blank]").attr("href");
            String[] names = url.split("/"); 
            url = "/BookRead/SelectChapter?book="+names[1]+"&chapter="+names[2].substring(0,names[2].length()-5);
            book.get(0).select("a[target=_blank]").attr("href",url);
            bookinfo = book.get(0).toString();
            
            Elements hrefs = book.get(1).select("a[href]");
            for (Element element : hrefs) {
            	String href = element.attr("href");
            	
            	String[] hname = href.split("/"); 
            	href = "/BookRead/SelectChapter?book="+hname[1]+"&chapter="+hname[2].substring(0,hname[2].length()-5);
            	element.attr("href", href);
				
            }
            chapter = book.get(1).toString();
//            System.out.println(chapter);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
	
	public String getBookinfo() {
		return bookinfo;
	}

	public void setBookinfo(String bookinfo) {
		this.bookinfo = bookinfo;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
}
