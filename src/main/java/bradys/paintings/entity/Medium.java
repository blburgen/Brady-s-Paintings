package bradys.paintings.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Medium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mediaId;
	
	private String mediaName;
	private String mediaQuality;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "media")
	private Set<Painting> paintings = new HashSet<>();
}
