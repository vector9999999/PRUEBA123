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
@Table(name="tbl_categoria")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="frecuencia_compra")
	private String frecuencia_compra;
	
	 public String toString() {
	        return descripcion;
	    }
	
}
