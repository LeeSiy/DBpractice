/* Copyright by Siyun Lee
 * 2020.10.22
 */
public class DBM {
	LOGIN login; //�α���ȭ��
	MENU menu; //�޴�ȭ��
	static boolean login_check = false;
	static RESULT[] dataset = null;
	static RESULT data = new RESULT("","","","","","","",0.0,"","","");
	public static void main(String[] args) {
		MAIN main = new MAIN();
		main.login = new LOGIN(); 
		main.login.setMain(main);
	}
}
