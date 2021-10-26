package de.gtwsp21.handmanserv.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.gtwsp21.handmanserv.command.BenutzerCommand;
import de.gtwsp21.handmanserv.domain.Adresse;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Berater;
import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.domain.Gewerk;
import de.gtwsp21.handmanserv.domain.Handwerker;
import de.gtwsp21.handmanserv.domain.PasswortToken;
import de.gtwsp21.handmanserv.domain.Rolle;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.domain.compositid.RollenId;
import de.gtwsp21.handmanserv.exception.BenutzerExistiertSchonException;
import de.gtwsp21.handmanserv.init.ConfigProperties;
import de.gtwsp21.handmanserv.model.RegistrierenModel;
import de.gtwsp21.handmanserv.model.helper.BenutzerHelper;
import de.gtwsp21.handmanserv.model.helper.GebietHelper;
import de.gtwsp21.handmanserv.repository.AdresseRepository;
import de.gtwsp21.handmanserv.repository.BenutzerRepository;
import de.gtwsp21.handmanserv.repository.GebietRepository;
import de.gtwsp21.handmanserv.repository.GewerkRepository;
import de.gtwsp21.handmanserv.repository.PasswortTokenRepository;
import de.gtwsp21.handmanserv.repository.RollenRepository;
import de.gtwsp21.handmanserv.repository.VersicherungsnehmerRepository;
import de.gtwsp21.handmanserv.service.IBenutzerService;
import de.gtwsp21.handmanserv.service.ISendEmailService;

@Service
public class BenutzerService implements IBenutzerService {
	
    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";
	
	@Autowired
	private BenutzerRepository benutzerRepository;
	
	@Autowired
	private RollenRepository rollenRepository;
	
	@Autowired
	private GebietRepository gebieteRepository;
	
	@Autowired
	private BenutzerHelper benutzerHelper;
	
	@Autowired
	private PasswortTokenRepository passwortTokenRepository;
	
	@Autowired
	private ISendEmailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private GewerkRepository gewerkRepository;
    
    @Autowired
    private AdresseRepository adressenRepository;
    
    @Autowired
    private VersicherungsnehmerRepository versicherungsnehmerRepository;
    
	@Autowired
	private GebietHelper gebietHelper;
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Autowired
	private PasswordEncoder pEncoder;
	
    @Override
	public PasswortToken createVerificationTokenForUser(Benutzer user) {
    	PasswortToken pt = passwortTokenRepository.findByBenutzer(user);
    	if(pt ==null) {
    		pt = createVerificationTokenForUser(user, UUID.randomUUID()
    	            .toString());
    	}else {
    		pt = generateNewPasswortToken(pt.getToken());
    	}
    	return pt;
    }
    
	@Override
	public PasswortToken createVerificationTokenForUser(Benutzer user, String token) {
		  final PasswortToken myToken = new PasswortToken(token, user);
		 return passwortTokenRepository.save(myToken);
	}
	
	@Override
    public void saveRegisteredUser(final Benutzer user) {
        benutzerRepository.save(user);
    }

	@Override
	public PasswortToken getVerificationToken(String token) {
		return passwortTokenRepository.findByToken(token);
	}
	
	@Override
	public void sendNewPasswortToken(String token, String eMail) {
		Benutzer b = null;
		PasswortToken ptoken= null;
		if(StringUtils.isNotBlank(token)) {
			b = this.getUserByPasswordToken(token).orElse(null);
			if(b!=null) {
				ptoken = this.generateNewPasswortToken(token);
			}
		}else if(StringUtils.isNotBlank(eMail)) {
			b = this.findUserByEmail(eMail);
			ptoken = createVerificationTokenForUser(b);
		}else {
			throw new IllegalArgumentException("Bitte entweder den token oder eine e-Mail angeben!");
		}
		
		if(ptoken != null) {
			this.userSetPasswort(b, true, ptoken);
		}
		
	}

	@Override
	public PasswortToken generateNewPasswortToken(String token) {
		PasswortToken vToken = passwortTokenRepository.findByToken(token);
	        vToken.updateToken(UUID.randomUUID()
	            .toString());
	        vToken = passwortTokenRepository.save(vToken);
	        return vToken;
	}

	@Override
	public RegistrierenModel loadRegistration() {
		RegistrierenModel rm = new RegistrierenModel();
		
		rm.setGebiete(gebieteRepository.findAll());
		rm.setGewerke(gewerkRepository.findAll());
		rm.setBenutzertyp(benutzerHelper.getBenutzertypen());
		rm.setAnreden(Arrays.asList("Herr","Frau","Divers","Firma"));
		return rm;
	}

	@Override
	public Benutzer findUserByEmail(String email) {
		return benutzerRepository.findByeMailadresse(email);
	}

	@Override
	public void changeBenutzerPassword(Benutzer user, String passwort) {
		user.setPasswort(passwordEncoder.encode(passwort));
		user.setEnabled(true);
		passwortTokenRepository.delete(passwortTokenRepository.findByBenutzer(user));
		benutzerRepository.save(user);

	}

	@Override
	public boolean checkIfValidOldPassword(Benutzer user, String passwort) {
		return passwordEncoder.matches(passwort, user.getPasswort());
	}

	@Override
	public Optional<Benutzer> getUserByPasswordToken(String token) {
		return Optional.ofNullable(passwortTokenRepository.findByToken(token).getBenutzer());
	}

	@Override
	public Optional<Benutzer> getUserByID(long id) {
		return benutzerRepository.findById(id);
	}
	
	@Override
    public String validatePasswortToken(String token) {
        final PasswortToken verificationToken = passwortTokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final Benutzer user = verificationToken.getBenutzer();
        if (verificationToken.getAblaufdatum().isAfter(LocalDateTime.now())) {
            passwortTokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setEnabled(true);
        passwortTokenRepository.delete(verificationToken);
        benutzerRepository.save(user);
        return TOKEN_VALID;
    }
	
	private Benutzer checkAndFillBenutzerGewerkAndGebiet(Benutzer b, List<Long> gewerke, List<Long> gebiete) {
		if(b != null && b.getId() != null && b.getId() > 0L) {
			List<Gebiet> geb = null;
			List<Gewerk> gew = null;
			if(checkList(gebiete)) { 
				geb = gebiete.stream().map(id -> gebieteRepository.findById(id).get()).collect(Collectors.toList());
			}
			if(checkList(gewerke)) {
				gew = gewerke.stream().map(id -> gewerkRepository.findById(id).get()).collect(Collectors.toList());
			}
			if (b instanceof Handwerker) {
				Handwerker h = (Handwerker) b;
				h.setGewerke(gew);
				h.setGebiete(geb);
				benutzerRepository.save(h);
			}else if(b instanceof Bauherr) {
				Bauherr bau = (Bauherr) b;
				bau.setGebiete(geb);
				benutzerRepository.save(bau);
			}else if (b instanceof Berater) {
				 Berater ber = (Berater) b;
				 ber.setGebiete(geb);
				 benutzerRepository.save(ber);
			}else if(b instanceof Versicherungsnehmer) {
				Versicherungsnehmer v = (Versicherungsnehmer) b;
				Adresse adresse = v.getAdresse();
				adresse.setGebiet(gebietHelper.findGebietByPlz(adresse.getPlz()));
				adressenRepository.save(adresse);
				benutzerRepository.save(v);
			}
		}
		return b;
	}
	
	
	@Override
    public Benutzer registerNewUserAccount(final BenutzerCommand accountDto) throws BenutzerExistiertSchonException  {
        if (emailExists(accountDto.getEmail())) {
            throw new BenutzerExistiertSchonException("There is an account with that email address: " + accountDto.getEmail());
        }
        final Benutzer user = accountDto.toBenutzer();
        
      /*  if(user instanceof Versicherungsnehmer) {
        	adressenRepository.save((Versicherungsnehmer) user).getAdresse());
        }
*/
         benutzerRepository.save(user);
         Rolle r = new Rolle(new RollenId(user.geteMailadresse(), user.getRolleForSecurity()[0]));
         rollenRepository.save(r);
         checkAndFillBenutzerGewerkAndGebiet(user, accountDto.getGewerke(), accountDto.getGebiete());
         userSetPasswort(user,false);
         return user;
    }
	
	
	private void userSetPasswort(final Benutzer user,boolean isResetToken) {
		userSetPasswort(user,isResetToken,null);
	}

	private void userSetPasswort(final Benutzer user,boolean isResetToken,PasswortToken pt) {
		if(configProperties.isTestmodus()) {
        	 user.setEnabled(true);
        	 user.setPasswort(pEncoder.encode("admin"));
        	 benutzerRepository.save(user);
         }else {
	        if(pt == null) {
	        	pt = createVerificationTokenForUser(user);
	        }
	        if(isResetToken) { 
	        	mailService.sendResetTokenEmail(pt);
	        }else { 
	        	mailService.sendInitialTokenEmail(pt);
	        }
         }
	}

	private boolean emailExists(final String email) {
		return benutzerRepository.findByeMailadresse(email) != null;
	}
	
	private boolean checkList(List<?> l) {
		return l!=null && !l.isEmpty() && !l.contains(0l); 
	}

	@Override
	public Versicherungsnehmer findVersicherungsnehmerByPolice(String police) {
		return versicherungsnehmerRepository.findByPolicennummer(police);
	}

	@Override
	public List<Versicherungsnehmer> findAllVersicherungsnehmer() {
		return versicherungsnehmerRepository.findAll();
	}

}
