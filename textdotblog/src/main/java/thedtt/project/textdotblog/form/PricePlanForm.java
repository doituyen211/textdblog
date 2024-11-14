package thedtt.project.textdotblog.form;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PricePlanForm {
    private String planName;
    private String planDescription;
    private BigDecimal monthlyCost;
    private BigDecimal yearlyCost;
    private String aiSupportLevel;
    private Boolean contentRewrite;
    private Boolean seoOptimization;
    private Boolean keywordSuggestions;
    private Boolean contentAutomation;
    private Boolean targetAudienceAnalysis;
    private Integer maxPostsPerMonth;
}
