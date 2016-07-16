package ChessGame;

public class ChessPlayer {
	char color;
	king K= new king();
	knight k[]= new knight[2];
	bishop b[]= new bishop[2];
	queen q=new queen();
	rook r=new rook();
	public ChessPlayer(char c)
	{	color=c;
	
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public king getK() {
		return K;
	}
	public void setK(king k) {
		K = k;
	}
	public knight[] getK() {
		return k;
	}
	public void setK(knight[] k) {
		this.k = k;
	}
	public bishop[] getB() {
		return b;
	}
	public void setB(bishop[] b) {
		this.b = b;
	}
	public queen getQ() {
		return q;
	}
	public void setQ(queen q) {
		this.q = q;
	}
	public rook getR() {
		return r;
	}
	public void setR(rook r) {
		this.r = r;
	}
	
}
