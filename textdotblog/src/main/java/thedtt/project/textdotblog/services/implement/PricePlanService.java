package thedtt.project.textdotblog.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import thedtt.project.textdotblog.enums.AiSupportLevel;
import thedtt.project.textdotblog.form.PricePlanForm;
import thedtt.project.textdotblog.model.PricePlan;
import thedtt.project.textdotblog.payload.response.ApiResponse;
import thedtt.project.textdotblog.repositories.PricePlanRepository;
import thedtt.project.textdotblog.services.BaseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PricePlanService implements BaseService<PricePlanForm> {

    private final PricePlanRepository pricePlanRepository;

    @Override
    public ApiResponse<?> getAll() {
        try {
            List<PricePlan> pricePlans = pricePlanRepository.findAll();
            return ApiResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("Get All Price Plan Successfully !")
                    .data(pricePlans)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse<?> getById(Integer id) {
        try {
            Optional<PricePlan> pricePlan = pricePlanRepository.findById(id);
            if (pricePlan.isPresent()) {
                return ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Get Price Plan by " + id + " Successfully !")
                        .data(pricePlan.get())
                        .build();
            } else {
                return ApiResponse.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Price Plan not found with id " + id)
                        .data(null)
                        .build();
            }
        } catch (Exception e) {
            return ApiResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }


    @Override
    public ApiResponse<?> add(PricePlanForm form) {
        try {
            if (pricePlanRepository.findPricePlanByPlanName(form.getPlanName()).isPresent()) {
                return ApiResponse.builder()
                        .code(HttpStatus.CONFLICT.value())
                        .message("Price Plan name already exists !")
                        .build();
            }

            PricePlan pricePlan = new PricePlan();

            pricePlan.setPlanName(form.getPlanName());
            pricePlan.setDescription(form.getPlanDescription());
            pricePlan.setMonthlyCost(form.getMonthlyCost());
            pricePlan.setYearlyCost(form.getYearlyCost());

            try {
                pricePlan.setAiSupportLevel(AiSupportLevel.valueOf(form.getAiSupportLevel().toUpperCase()));
            } catch (IllegalArgumentException e) {
                return ApiResponse.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message("Invalid AI Support Level provided!")
                        .data(null)
                        .build();
            }

            pricePlan.setContentRewrite(form.getContentRewrite());
            pricePlan.setSeoOptimization(form.getSeoOptimization());
            pricePlan.setKeywordSuggestions(form.getKeywordSuggestions());
            pricePlan.setContentAutomation(form.getContentAutomation());
            pricePlan.setTargetAudienceAnalysis(form.getTargetAudienceAnalysis());
            pricePlan.setMaxPostsPerMonth(form.getMaxPostsPerMonth());

            pricePlanRepository.save(pricePlan);

            return ApiResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("Add new Price Plan Successfully !")
                    .data(form)
                    .build();
        } catch (Exception e) {
            return ApiResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }



    @Override
    public ApiResponse<?> delete(Integer id) {
        try {
            Optional<PricePlan> pricePlanOptional = pricePlanRepository.findById(id);
            if (pricePlanOptional.isPresent()) {
                PricePlan pricePlan = pricePlanOptional.get();
                pricePlanRepository.delete(pricePlan);

                return ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Delete Price Plan by " + id + " Successfully !")
                        .data(pricePlan)
                        .build();
            } else {
                return ApiResponse.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Price Plan not found with id " + id)
                        .data(null)
                        .build();
            }
        } catch (Exception e) {
            return ApiResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }

    @Override
    public ApiResponse<?> update(Integer id, PricePlanForm form) {
        try {
            Optional<PricePlan> pricePlanOptional = pricePlanRepository.findById(id);

            if (pricePlanOptional.isPresent()) {
                PricePlan pricePlan = pricePlanOptional.get();

                pricePlan.setPlanName(form.getPlanName());
                pricePlan.setDescription(form.getPlanDescription());
                pricePlan.setMonthlyCost(form.getMonthlyCost());
                pricePlan.setYearlyCost(form.getYearlyCost());

                try {
                    pricePlan.setAiSupportLevel(AiSupportLevel.valueOf(form.getAiSupportLevel().toUpperCase()));
                } catch (IllegalArgumentException e) {
                    return ApiResponse.builder()
                            .code(HttpStatus.BAD_REQUEST.value())
                            .message("Invalid AI Support Level provided!")
                            .data(null)
                            .build();
                }

                pricePlan.setContentRewrite(form.getContentRewrite());
                pricePlan.setSeoOptimization(form.getSeoOptimization());
                pricePlan.setKeywordSuggestions(form.getKeywordSuggestions());
                pricePlan.setContentAutomation(form.getContentAutomation());
                pricePlan.setTargetAudienceAnalysis(form.getTargetAudienceAnalysis());
                pricePlan.setMaxPostsPerMonth(form.getMaxPostsPerMonth());

                // Save the updated PricePlan entity
                pricePlanRepository.save(pricePlan);

                return ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Update Price Plan by " + id + " Successfully !")
                        .data(form)
                        .build();
            } else {
                return ApiResponse.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Price Plan not found with id " + id)
                        .data(null)
                        .build();
            }
        } catch (Exception e) {
            return ApiResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
    }


}
