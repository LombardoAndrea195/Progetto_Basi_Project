package application.model;

public class Cattura {
private Strumento strumento;
private Banda banda;
public Strumento getStrumento() {
	return strumento;
}
public void setStrumento(Strumento strumento) {
	this.strumento = strumento;
}
public Banda getBanda() {
	return banda;
}
public void setBanda(Banda banda) {
	this.banda = banda;
}
public Cattura(Strumento strumento, Banda banda) {
	super();
	this.strumento = strumento;
	this.banda = banda;
}

}
