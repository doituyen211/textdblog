package thedtt.project.textdotblog.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Value
public class PricePlanDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String planName;
    @NotNull
    String description;
    BigDecimal monthlyCost;
    BigDecimal yearlyCost;
    String aiSupportLevel;
    Boolean contentRewrite;
    Boolean seoOptimization;
    Boolean keywordSuggestions;
    Boolean contentAutomation;
    Boolean targetAudienceAnalysis;
    Integer maxPostsPerMonth;
}