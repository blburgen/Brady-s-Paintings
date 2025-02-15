package bradys.paintings.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Painting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paintingId;

	@EqualsAndHashCode.Exclude
	private String paintingName;
	@EqualsAndHashCode.Exclude
	private Long estimatedHours;
	@EqualsAndHashCode.Exclude
	private String Notes;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "completion_id", nullable = false)
	private Completion completion;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "painting_medium", 
		joinColumns = @JoinColumn(name = "painting_id"), 
		inverseJoinColumns = @JoinColumn(name = "media_id")
	)
	private Set<Medium> media = new HashSet<>();
}
