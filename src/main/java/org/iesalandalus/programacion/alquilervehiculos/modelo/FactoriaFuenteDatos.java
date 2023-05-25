package org.iesalandalus.programacion.alquilervehiculos.modelo;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros.FuenteDatosFicheros;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.mariadb.FuenteDatosMariaDB;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.mongodb.FuenteDatosMondoDB;

public enum FactoriaFuenteDatos {
	FICHEROS {
		@Override
		public IFuenteDatos crear() {
			return new FuenteDatosFicheros();
		}
	},
	MONGODB {

		@Override
		IFuenteDatos crear() {
			return new FuenteDatosMondoDB();
		}

	},
	MARIADB {

		@Override
		IFuenteDatos crear() {
			return new FuenteDatosMariaDB();
		}

	}

	;

	abstract IFuenteDatos crear();

}
