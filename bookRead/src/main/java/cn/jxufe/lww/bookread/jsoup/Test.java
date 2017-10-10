package cn.jxufe.lww.bookread.jsoup;

public class Test {

	public static void main(String[] args) {
		SelectBook s  = new SelectBook();
		s.setBookid("0_36");
//		s.setChapterid("1000004");
		s.getBookList();
		System.out.println(s.getBooklist());
//		String s ="http://www.xxbiquge.com/53_53652/555.html";
//		s = s.replace(".html","");
//		System.out.println(s);
		
		
	}

}
