package com.PruebaLP2.Models;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_inventario")
public class Inventario {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private int numero;
	
	@Column(name="fecha_vencimiento" ,columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private LocalDate fechaVencimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="costo_ingreso")
	private double costoIngreso;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="lote")
	private String lote;
	
	@Column(name="cod_estado")
	private String codEstado;
	
}
