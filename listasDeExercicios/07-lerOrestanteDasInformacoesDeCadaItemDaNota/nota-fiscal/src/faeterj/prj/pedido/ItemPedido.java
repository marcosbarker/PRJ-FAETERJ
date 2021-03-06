package faeterj.prj.pedido;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class ItemPedido {
	private String codigo;
	private String descricao;
	private double quantidade;
	private String unidade;
	private double valorUnitario;
	private double valorTotal;

	public void carregar(Scanner sc) throws ParseException {
		this.descricao = "";
		String palavra = null;
		while ((palavra = sc.next()) != null) {
			if (palavra.equals("(Código:")) {
				break;
			} else {
				this.descricao += " " + palavra;
			}
		}
		this.codigo = sc.next();
		sc.nextLine();
		sc.skip("Qtde\\.:");
		String a = sc.next();
		a = a.replaceAll("Un:", "");
		NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
		Number n = nf.parse(a);
		this.quantidade = n.doubleValue();

		a = sc.next();
		this.unidade = a.substring(0, 2);
		a = sc.next();
		a = a.replaceAll("Unit.:", "");
		a = sc.next();
		Number vu = nf.parse(a);
		this.valorUnitario = vu.doubleValue();
		sc.nextLine();
		sc.nextLine();
	}

	@Override
	public String toString() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(buffer);
		out.printf("%s%s", this.descricao, 
		"  (código: " + this.codigo + " )");
		out.printf("\n");
		out.printf("%s%.0f%s%s%s%s%s", " Qtde.:", 
		this.quantidade, "UN: ", this.unidade + "Vl.", " Unit.: ",
		this.valorUnitario, " Vl.  Total");
		out.printf("\n");
		out.printf("%s%.2f", " ", this.quantidade*this.valorUnitario);
		out.close();
		return buffer.toString();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}