package s;

public class testar {
	private HashTabel tabel;
	
	public testar() {
		tabel = new HashTabel(10);
	}
	
	public static void main(String[] args) {
		HashTabel tabel = new HashTabel(101);
		
		tabel.addHash("Fungerar"); tabel.addHash("detta");
		tabel.addHash("eller"); tabel.addHash("gör");
		tabel.addHash("vi"); tabel.addHash("fel");
		System.out.println(tabel.sizeWords());
	}

}
