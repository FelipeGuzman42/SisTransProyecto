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

/**
 * Interfaz para los métodos get de Empresa.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOApartamento 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
	/**
	 * @return true si es amoblado
	 */
	public boolean esAmoblado();
	/**
	 * @return true si tiene comidas
	 */
	public boolean tieneComidas();
	/**
	 * @return true si tiene baño privado.
	 */
	public boolean tieneBañoPrivado();
	/**
	 * @return el costo de los servicios
	 */
	public int getCostoServicios();
	
	/**
	 * 
	 */
	public long getIdPropietarioMiembro();

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString();

}
