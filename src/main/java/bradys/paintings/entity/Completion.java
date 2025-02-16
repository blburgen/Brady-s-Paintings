package bradys.paintings.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Completion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long completionId;
	
	private Long completionYear;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Painting> paintings = new HashSet<>(); 
}
