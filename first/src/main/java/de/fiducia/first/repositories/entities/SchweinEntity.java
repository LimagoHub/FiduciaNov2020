package de.fiducia.first.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tblschweine")
public class SchweinEntity {
	
	@Id
	@Column(length = 36)
	private String id;
	@Column(length = 30)
	private String name;
	private int gewicht;

}
