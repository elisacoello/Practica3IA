package principal;

import modelos.ModeloRandomForest;

public class Main{
	public static void main(String[] args) {
        ModeloRandomForest modelo = new ModeloRandomForest();
        modelo.aprenderModelo();
        System.out.println("El clasificador con Random Forest obtiene: " + modelo.aplicarModelo());
    }
}