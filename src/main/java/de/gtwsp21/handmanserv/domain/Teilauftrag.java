package de.gtwsp21.handmanserv.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "teilauftrag", uniqueConstraints = @UniqueConstraint(columnNames = {"nummer"},name = "UX_Nummer"))
public class Teilauftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Auftrag auftrag;
	
	@OneToOne
	private Handwerker handwerker;
	
	private LocalDateTime beginndatum;
	
	private LocalDateTime enddatum;
	
	@OneToOne
	private Gewerk gewerk;
	
	@Column(length = 4000)
	private String auftragstext;
	
	private Auftragstatus status;
	
	private String nummer;
	
	@OneToMany
	@JoinTable(name = "teilauftrag_notiz",
    joinColumns = @JoinColumn(name = "teilauftrag_id"),
    inverseJoinColumns = @JoinColumn(name = "notiz_id"))
	private List<Notiz> notizen;
	
}
