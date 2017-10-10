package cn.jxufe.lww.bookread.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectBook {
	private String bookid;
	private String booklist;
	private Element docfoot;
	
	public void getBookList(){
		try {  
            Document doc = Jsoup.connect("http://zhannei.baidu.com/cse/search?q="+bookid+"&click=1&s=8823758711381329060&nsid=").get();  
            Elements doclist = doc.getElementsByClass("result-list");
            docfoot = doc.getElementById ("pageFooter");
//            System.out.println(docfoot);
            Elements pngs = doclist.get(0).select("a[href]");
			for (Element element : pngs) {
				String url = element.attr("href");
				
				String[] names = url.split("/"); 
				url = "/BookRead/SelectChapter";
				if(names.length==4)
				{
				String book = names[3];
				url+="?book="+book;
				}
				else if(names.length==5)
				{
					String book = names[3];
					String chapter = names[4].substring(0,names[4].length()-6); 
					url+="?book="+book+"&chapter="+chapter;
				}
				else
				{
					url+="?book=0_36";
				}
				element.attr("href", url);
			}
//			System.out.println(doclist);
              
              booklist = doclist.toString();
              
//              booklist = results.toString();
              
//              bookfoot = doc.getElementById ("pageFooter").toString();
//              System.out.println(booklist);
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBooklist() {
		return booklist;
	}
	public void setBooklist(String booklist) {
		this.booklist = booklist;
	}
	
	
}
