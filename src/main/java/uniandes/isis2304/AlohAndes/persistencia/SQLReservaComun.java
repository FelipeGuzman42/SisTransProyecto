/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.AlohAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.AlohAndes.negocio.ReservaComun;
import uniandes.isis2304.AlohAndes.negocio.Operador;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLReservaComun 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLReservaComun (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un TIPOBEBIDA a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @param nombre - El nombre del tipo de bebida
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarReservaComun (PersistenceManager pm, long idCliente, long idOferta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaComun  () + "(idCliente, idOfertaComun) values (?,?)");
        q.setParameters(idCliente, idOferta);
        return (long) q.executeUnique();            
	}


	/**
	 * Crea y ejecuta la sentencia SQL para eliminar TIPOS DE BEBIDA de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservaComun (PersistenceManager pm, long idCliente, long idOferta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaComun () + " WHERE idCliente = ? AND idOfertaComun = ?");
        q.setParameters(idCliente, idOferta);
        return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN TIPO DE BEBIDA de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El objeto TIPOBEBIDA que tiene el identificador dado
	 */
	public ReservaComun darReservaComun (PersistenceManager pm, long idCliente, long idOferta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaComun  () + " WHERE idEPS = ? AND idIPS = ?");
		q.setResultClass(ReservaComun.class);
		q.setParameters(idCliente, idOferta);
		return (ReservaComun) q.executeUnique();
	}
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS TIPOS DE BEBIDA de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos TIPOBEBIDA
	 */
	public List<ReservaComun> darListaReservaComun (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaComun  ());
		q.setResultClass(ReservaComun.class);
		return (List<ReservaComun>) q.executeList();
	}
	
}
