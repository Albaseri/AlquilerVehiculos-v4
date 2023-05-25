package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Modelo modelo = new ModeloCascada(procesarArgumentosFuenteDatos(args));
		Vista vista = procesarArgumentosVistas(args);
		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

	private static Vista procesarArgumentosVistas(String[] args) {
		Vista vista = FactoriaVista.GRAFICA.crear();
		for (String argumento : args) {
			if (argumento.equals("-vgrafica")) {
				vista = FactoriaVista.GRAFICA.crear();
			} else if (argumento.equals("-vtexto")) {
				vista = FactoriaVista.TEXTO.crear();
			}
		}

		return vista;
	}

	private static FactoriaFuenteDatos procesarArgumentosFuenteDatos(String[] args) {
		FactoriaFuenteDatos factoriaFuenteDatos = FactoriaFuenteDatos.MONGODB;
		for (String argumento : args) {
			if (argumento.equals("-fdficheros")) {
				factoriaFuenteDatos = FactoriaFuenteDatos.FICHEROS;
			} else if (argumento.equals("-fdmongodb")) {
				factoriaFuenteDatos = FactoriaFuenteDatos.MONGODB;
			} else if (argumento.equals("-fdmariadb")) {
				factoriaFuenteDatos = FactoriaFuenteDatos.MARIADB;
			}

		}
		return factoriaFuenteDatos;

	}

}