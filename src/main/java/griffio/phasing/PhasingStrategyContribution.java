package griffio.phasing;

import griffio.persist.PersistableSequence;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "phasing_strategy_contributions")
@SequenceGenerator(name = "sequence", sequenceName = "phas_strat_contribution_id_seq", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "phasing_strategy_cont_id"))
public class PhasingStrategyContribution extends PersistableSequence {

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "phasing_strategy_id", nullable = false, insertable = true, updatable = false)
    private PhasingStrategy phasingStrategy;

    @NotNull
    @Column(name = "effective_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate effectiveDate;

    @Column(name = "ee_contribution", nullable = false)
    @NotNull
    private BigDecimal eeCont;

    @Column(name = "er_contribution", nullable = false)
    @NotNull
    private BigDecimal erCont;

    @Column(name = "processed_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime processedDate;

    protected PhasingStrategyContribution() {
    }

    public PhasingStrategyContribution(LocalDate effectiveDate, BigDecimal eeCont, BigDecimal erCont, LocalDateTime processedDate) {
        this.effectiveDate = effectiveDate;
        this.eeCont = eeCont;
        this.erCont = erCont;
        this.processedDate = processedDate;
    }

    public BigDecimal getEeCont() {
        return eeCont;
    }

    public BigDecimal getErCont() {
        return erCont;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public PhasingStrategy getPhasingStrategy() {
        return phasingStrategy;
    }

    public void setPhasingStrategy(final PhasingStrategy phasingStrategy) {
        this.phasingStrategy = phasingStrategy;
        if (!this.phasingStrategy.getPhasingStrategyContributions().contains(this)) {
            this.phasingStrategy.getPhasingStrategyContributions().add(this);
        }
    }

    public LocalDateTime getProcessedDate() {
        return processedDate;
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof PhasingStrategyContribution) {
            PhasingStrategyContribution that = (PhasingStrategyContribution) object;
            return Objects.equals(this.eeCont, that.eeCont)
                    && Objects.equals(this.erCont, that.erCont)
                    && Objects.equals(this.effectiveDate, that.effectiveDate)
                    && Objects.equals(this.processedDate, that.processedDate);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.effectiveDate, this.eeCont, this.erCont, this.processedDate);
    }

    @Override
    public String toString() {
        return String.format("PhasingStrategyContribution{effectiveDate=%s, eeCont=%s, erCont=%s, processedDate=%s}", effectiveDate, eeCont, erCont, processedDate);
    }

    public static class Builder {

        private BigDecimal eeCont;
        private BigDecimal erCont;
        private LocalDate effectiveDate;
        private LocalDateTime processedDate;

        public Builder eeCont(BigDecimal eeCont) {
            this.eeCont = eeCont;
            return this;
        }

        public Builder erCont(BigDecimal eeCont) {
            this.erCont = eeCont;
            return this;
        }

        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder processedDate(LocalDateTime processedDate) {
            this.processedDate = processedDate;
            return this;
        }

        public PhasingStrategyContribution build() {
            return new PhasingStrategyContribution(effectiveDate, eeCont, erCont, processedDate);
        }
    }

}
