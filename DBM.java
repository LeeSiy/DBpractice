/* Copyright by Siyun Lee
 * 2020.10.22
 */

public class DBM {
	LOGIN login; //로그인화면
	MENU menu; //메뉴화면
	static boolean login_check = false;
	static RESULT[] dataset = null;
	static RESULT data = new RESULT("","","","","","","",0.0,"","","");
	//
	static int[] show = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static String SelectedDname = "Default";
	//
	public static void main(String[] args) {
		MAIN main = new MAIN();
		main.login = new LOGIN(); 
		main.login.setMain(main);
	}
}
