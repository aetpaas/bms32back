package bridge.bms32back.domain;

import bridge.bms32back.domain.county.County;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "project")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @NotNull
    @Column(name = "latitude", nullable = false, precision = 8, scale = 6)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "longitude", nullable = false, precision = 8, scale = 6)
    private BigDecimal longitude;

}