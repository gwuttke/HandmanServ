package de.gtwsp21.handmanserv.domain;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PasswortToken")
public class PasswortToken {
	
	private static final int ABLAUFZEITRAUM = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String token;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Benutzer benutzer;
	
	private LocalDateTime ablaufdatum;
	
	public PasswortToken() {
        super();
    }

    public PasswortToken(final String token) {
        super();

        this.token = token;
        this.ablaufdatum = calculateExpiryDate(ABLAUFZEITRAUM);
    }

    public PasswortToken(final String token, final Benutzer benutzer) {
        super();

        this.token = token;
        this.benutzer = benutzer;
        this.ablaufdatum = calculateExpiryDate(ABLAUFZEITRAUM);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public LocalDateTime getAblaufdatum() {
		return ablaufdatum;
	}

	public void setAblaufdatum(LocalDateTime ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}
	
	 public void updateToken(final String token) {
        this.token = token;
        this.ablaufdatum = calculateExpiryDate(ABLAUFZEITRAUM);
    }
		
	private LocalDateTime calculateExpiryDate(final int ablaufzeitInMinuten) {
	     return LocalDateTime.now().plusMinutes(ablaufzeitInMinuten);
    }
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAblaufdatum() == null) ? 0 : getAblaufdatum().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getBenutzer() == null) ? 0 : getBenutzer().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PasswortToken other = (PasswortToken) obj;
        if (getAblaufdatum() == null) {
            if (other.getAblaufdatum() != null) {
                return false;
            }
        } else if (!getAblaufdatum().equals(other.getAblaufdatum())) {
            return false;
        }
        if (getToken() == null) {
            if (other.getToken() != null) {
                return false;
            }
        } else if (!getToken().equals(other.getToken())) {
            return false;
        }
        if (getBenutzer() == null) {
            if (other.getBenutzer() != null) {
                return false;
            }
        } else if (!getBenutzer().equals(other.getBenutzer())) {
            return false;
        }
        return true;
    }

	
}
