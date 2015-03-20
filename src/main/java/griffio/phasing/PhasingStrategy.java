package griffio.phasing;

import com.google.common.collect.ImmutableSet;
import griffio.company.Company;
import griffio.persist.PersistableSequence;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Entity
@Table(name = "phasing_strategy")
@SequenceGenerator(name = "sequence", sequenceName = "phasing_strategy_id_seq", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "phasing_strategy_id"))
public class PhasingStrategy extends PersistableSequence {

  private static final long serialVersionUID = -42L;

  @Column(name = "name")
  @NotNull
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", nullable = false, updatable = false, insertable = true)
  private Company company;

  @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "phasingStrategy")
  private Set<PhasingStrategyContribution> phasingStrategyContributions = newHashSet();

  protected PhasingStrategy() {
  }

  public PhasingStrategy(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Set<PhasingStrategyContribution> getPhasingStrategyContributions() {
    return ImmutableSet.copyOf(phasingStrategyContributions);
  }

  public void addContribution(PhasingStrategyContribution phasingStrategyContribution) {
    phasingStrategyContributions.add(phasingStrategyContribution);
    phasingStrategyContribution.setPhasingStrategy(this);
  }

  public boolean remove(PhasingStrategyContribution contribution) {
    return phasingStrategyContributions.remove(contribution);
  }

}
