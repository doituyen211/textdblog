package thedtt.project.textdotblog.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thedtt.project.textdotblog.form.PricePlanForm;
import thedtt.project.textdotblog.model.PricePlan;
import thedtt.project.textdotblog.payload.response.ApiResponse;
import thedtt.project.textdotblog.services.implement.PricePlanService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/textdblog/price-plan")
public class PricePlanController {

    private final PricePlanService pricePlanService;

    @GetMapping
    public ApiResponse<?> getPricePlan() {
       return pricePlanService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<?> getPricePlanById(@PathVariable int id) {
        return pricePlanService.getById(id);
    }

    @PostMapping("/add/new")
    public ApiResponse<?> addNewPricePlan(@RequestBody PricePlanForm form) {
        return pricePlanService.add(form);
    }

    @PutMapping("/update/{id}")
    public ApiResponse<?> updatePricePlan(@PathVariable int id, @RequestBody PricePlanForm form) {
        return pricePlanService.update(id, form);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<?> deletePricePlan(@PathVariable int id) {
        return pricePlanService.delete(id);
    }

}
