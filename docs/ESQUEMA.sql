CREATE SEQUENCE alohandes_sequence;

CREATE TABLE OFERTACOMUN(
	IDOFERTACOMUN NUMBER,
	CAPACIDAD VARCHAR2(6) NOT NULL,
	PISCINA VARCHAR2(6) NOT NULL,
	PARQUEADERO VARCHAR2(6) NOT NULL,
	TVCABLE VARCHAR2(6) NOT NULL,
	WIFI VARCHAR2(6) NOT NULL,
	PRECIO NUMBER NOT NULL,
	CONSTRAINT OFERTACOMUN_PK PRIMARYKEY(IDOFERTACOMUN)
)

CREATE TABLE OFERTAEXCLUSIVA(
	IDOFERTAEXCLUSIVA NUMBER,
	HABITACIONCOMPARTIDA VARCHAR2(6) NOT NULL,
	PRECIONOCHE NUMBER NOT NULL,
	CONSTRAINT OFERTAEXCLUSIVA_PK PRIMARYKEY(IDOFERTAEXCLUSIVA)
)

CREATE TABLE VIVIENDAUNIVERSITARIA(
	IDOFERTAEXCLUSIVA NUMBER,
	HABITACIONCOMPARTIDA VARCHAR2(6) NOT NULL,
	PRECIONOCHE NUMBER NOT NULL,
	COSTORESTAURANTE NUMBER NOT NULL,
	COSTOSALAS NUMBER NOT NULL,
	COSTOGIMNASIO NUMBER NOT NULL,
	IDADMIN NUMBER NOT NULL,
	CONSTRAINT VIVIENDAUNIVERSITARIA_PK PRIMARYKEY(IDOFERTAEXCLUSIVA),
	******CONSTRAINT VIVIENDAUNIVERSITARIA_FK FOREIGNKEY(IDADMIN)
)

CREATE TABLE APARTAMENTO(
	IDOFERTAEXCLUSIVA NUMBER,
	HABITACIONCOMPARTIDA VARCHAR2(6) NOT NULL,
	PRECIONOCHE VARCHAR2(6) NOT NULL,
	AMOBLADO VARCHAR2(6) NOT NULL,
	COMIDAS VARCHAR2(6) NOT NULL,
	BANOPRIVADO VARCHAR2(6) NOT NULL,
	COSTOSERVICIOS NUMBER NOT NULL,
	IDMIEMBRO NUMBER NOT NULL,
	CONSTRAINT APARTAMENTO_PK PRIMARYKEY(IDOFERTAEXCLUSIVA)
	******CONSTRAINT APARTAMENTO_FK FOREIGNKEY(IDMIEMBRO)
)

CREATE TABLE VIVIENDA(
	IDOFERTACOMUN NUMBER,
	CAPACIDAD VARCHAR2(6) NOT NULL,
	PISCINA VARCHAR2(6) NOT NULL,
	PARQUEADERO VARCHAR2(6) NOT NULL,
	TVCABLE VARCHAR2(6) NOT NULL,
	WIFI VARCHAR2(6) NOT NULL,
	PRECIONOCHE NUMBER NOT NULL,
	NUMHABITACIONES NUMBER NOT NULL,
	DESCRIPCIONSEGURO VARCHAR2(50),
	IDVECINO NUMBER NOT NULL,
	CONSTRAINT VIVIENDA_PK PRIMARYKEY(IDOFERTACOMUN)
	CONSTRAINT VECINOVIVIENDA_FK FOREIGNKEY(IDVECINO)
	REFERENCES VECINO(IDVECINO)
)

CREATE TABLE HOSPEDAJE(
	IDOFERTACOMUN NUMBER,
	CAPACIDAD VARCHAR2(6) NOT NULL,
	PISCINA VARCHAR2(6) NOT NULL,
	PARQUEADERO VARCHAR2(6) NOT NULL,
	TVCABLE VARCHAR2(6) NOT NULL,
	WIFI VARCHAR2(6) NOT NULL,
	PRECIONOCHE NUMBER NOT NULL,
	CATEGORIA VARCHAR2(20) NOT NULL,
	TAMANO VARCHAR2(15) NOT NULL,
	RECEPCION24H VARCHAR(6) NOT NULL,
	SERVICIORESTAURANTE VARCHAR(6) NOT NULL,
	IDEMPRESA NUMBER NOT NULL,
	CONSTRAINT HOSPEDAJE_PK PRIMARYKEY(IDOFERTACOMUN)
	CONSTRAINT EMPRESAHOSPEDAJE_FK FOREIGNKEY(IDEMPRESA)
	REFERENCES EMPRESA(IDEMPRESA)
)

CREATE TABLE EMPRESA(
	IDOPERADOR NUMBER,
	NOMBRE VARCHAR2(20) NOT NULL,
	TIPOIDENTIFICACION VARCHAR2(20) NOT NULL,
	REGISTROCAMARA VARCHAR2(20) NOT NULL,
	TIPOALOJAMIENTO VARCHAR2(20) NOT NULL,
	CONSTRAINT EMPRESA_PK PRIMARYKEY(IDOPERADOR)	
)

CREATE TABLE VECINO(
	IDOPERADOR NUMBER,
	TIPOIDENTIFICACION VARCHAR2(20) NOT NULL,
	NOMBRE VARCHAR2(20) NOT NULL,
	UBICACION VARCHAR2(20) NOT NULL,
	CONSTRAINT VECINO_PK PRIMARYKEY(IDOPERADOR)
)

CREATE TABLE ADMINVIVIENDA(
	IDOPERADOR NUMBER,
	TIPOIDENTIFICACION VARCHAR2(20) NOT NULL,
	NOMBRE VARCHAR2(20) NOT NULL,
	UBICACION VARCHAR2(20) NOT NULL,
	CONSTRAINT ADMINVIVIENDA_PK PRIMARYKEY(IDOPERADOR)
)

CREATE TABLE PROPIETARIOMIEMBRO(
	IDOPERADOR NUMBER,
	TIPOIDENTIFICACION VARCHAR2(20) NOT NULL,
	NOMBRE VARCHAR2(20) NOT NULL,
	UBICACION VARCHAR2(20) NOT NULL,
	TIPOMIEMBRO VARCHAR(20) NOT NULL,
	CONSTRAINT PROPIETARIOMIEMBRO_PK PRIMARYKEY(IDOPERADOR)
)

CREATE TABLE CLIENTE(
	IDCLIENTE NUMBER,
	NOMBRE VARCHAR2(20) NOT NULL,
	CORREO VARCHAR2(40) NOT NULL,
	CONSTRAINT CLIENTE_PK PRIMARYKEY(IDCLIENTE)
)

CREATE TABLE CLIENTEMIEMBRO(
	IDCLIENTE NUMBER,
	NOMBRE VARCHAR2(20) NOT NULL,
	CORREO VARCHAR2(40) NOT NULL,
	TIPOMIEMBRO VARCHAR2(20) NOT NULL,
	CONSTRAINT CLIENTEMIEMBRO_PK PRIMARYKEY(IDCLIENTE)
)

CREATE TABLE RESERVACOMUN(
	IDCLIENTE NUMBER,
	IDOFERTACOMUN NUMBER,
	CONSTRAINT RESERVACOMUN_PK PRIMARYKEY(IDCLIENTE, IDOFERTACOMUN)
	CONSTRAINT CLIENTE_FK FOREIGNKEY(IDCLIENTE)
	REFERENCES CLIENTE(IDCLIENTE),
	CONSTRAINT RESERVA_FK FOREIGNKEY(IDOFERTACOMUN)
	REFERENCES OFERTACOMUN(IDOFERTACOMUN)
)

CREATE TABLE CONTRATO(
	IDCLIENTE NUMBER,
	IDOFERTACOMUN NUMBER,
	FECHAINICIO DATE,
	FECHAFINAL DATE,
	CONSTRAINT CONTRATO_PK PRIMARYKEY(IDCLIENTE, IDOFERTACOMUN)
	CONSTRAINT CLIENTE_FK FOREIGNKEY(IDCLIENTE)
	REFERENCES CLIENTE(IDCLIENTE),
	CONSTRAINT CONTRATO_FK FOREIGNKEY(IDOFERTACOMUN)
	REFERENCES OFERTACOMUN(IDOFERTACOMUN)
)