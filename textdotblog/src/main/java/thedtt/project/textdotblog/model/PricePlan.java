package thedtt.project.textdotblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import thedtt.project.textdotblog.enums.AiSupportLevel;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "price_plan")
public class PricePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "plan_name", nullable = false, length = 50)
    private String planName;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "monthly_cost", precision = 10, scale = 2)
    private BigDecimal monthlyCost;

    @Column(name = "yearly_cost", precision = 10, scale = 2)
    private BigDecimal yearlyCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "ai_support_level")
    private AiSupportLevel aiSupportLevel;

    @Column(name = "content_rewrite")
    private Boolean contentRewrite;

    @Column(name = "seo_optimization")
    private Boolean seoOptimization;

    @Column(name = "keyword_suggestions")
    private Boolean keywordSuggestions;

    @Column(name = "content_automation")
    private Boolean contentAutomation;

    @Column(name = "target_audience_analysis")
    private Boolean targetAudienceAnalysis;

    @Column(name = "max_posts_per_month")
    private Integer maxPostsPerMonth;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private Set<UserPlanSubscription> userPlanSubscriptions = new LinkedHashSet<>();

}