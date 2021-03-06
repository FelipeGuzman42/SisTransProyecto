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

package uniandes.isis2304.AlohAndes.negocio;

import java.sql.Date;

/**
 * Clase para modelar la relación GUSTAN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bebedor gusta de una bebida y viceversa.
 * Se modela mediante los identificadores del bebedor y de la bebida respectivamente.
 * Debe existir un bebedor con el identificador dado
 * Debe existir una bebida con el identificador dado 
 * 

 */
public class Cliente implements VOCliente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del cliente
	 */
	private long idCliente;

	/**
	 * El correo
	 */
	private String correo;
	/**
	 * El nombre del cliente
	 */
	private String nombre;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente() 
	{
		idCliente = 0;
		correo = "";
		nombre="";
	}

	/**
	 * Constructor con valores
	 * @param idBebedor - El identificador del bebedor. Debe exixtir un bebedor con dicho identificador
	 * @param idBebida - El identificador de la bebida. Debe existir una bebida con dicho identificador
	 */
	public Cliente(long idCliente, String correo, String nombre) 
	{
		this.idCliente = idCliente;
		this.correo = correo;
		this.nombre = nombre;
	}


	/**
	 * @param idBebedor - El nuevo idBebedor. Debe existir un bebedor con dicho identificador
	 */
	public void setIdCliente(long idCliente) 
	{
		this.idCliente = idCliente;
	}

	/**
	 * @param idBebida - El nuevo identificador de bebida. Debe existir una bebida con dicho identificador
	 */
	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}
	
	/**
	 * @param idBebida - El nuevo identificador de bebida. Debe existir una bebida con dicho identificador
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Cliente [idCliente=" + idCliente + ", correo=" + correo + ", nombre=" + nombre + "]";
	}

	@Override
	public long getIdCliente() {
		// TODO Auto-generated method stub
		return idCliente;
	}

	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}


	
	
}
