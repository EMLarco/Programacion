/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notas1;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestionNotas {
   ArrayList<Double> notas;
	
public GestionNotas() {
		notas = new ArrayList<>();
	}
	
	public void guardarNot(double n) {
		notas.add(n);
	}
	
	public double media() {
		double media =0;
		for(double d:notas) {
			media+=d;
		}
		return media/notas.size();
	}
	
	public int aprobados() {
		int ap = 0;
		for(double d:notas) {
			if(d>=14) {
			ap ++;
			}
		}
		return ap;
	}
}