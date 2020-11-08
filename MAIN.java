public class MAIN{
	static LOGIN login; //로그인화면
	static MENU menu;
	static INSERT insert;
	public static void main(String[] args) {
		MAIN main = new MAIN();
		main.login = new LOGIN(); 
		main.login.setMain(main);
    }
	public static void selection(){
		//LOGIN->MENU(o)
		login.dispose(); 
		MAIN main = new MAIN();
		main.menu = new MENU();
	}
	
	public static void insert() {
		menu.dispose();
		MAIN main = new MAIN();
		main.insert = new INSERT();		
	}
	
	public static void insert2() {
		insert.dispose();
		MAIN main = new MAIN();
		main.menu = new MENU();		
	}
}
