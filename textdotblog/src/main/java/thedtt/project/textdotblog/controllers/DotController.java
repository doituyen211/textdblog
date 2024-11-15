package thedtt.project.textdotblog.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thedtt.project.textdotblog.payload.response.ApiResponse;
import thedtt.project.textdotblog.services.implement.DotService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/textdblog/dot")
public class DotController {

    private final DotService dotService;

    @GetMapping
    public ApiResponse<?> getAllDots() {
        return dotService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<?> getDotById(@PathVariable int id) {
        return dotService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<?> deleteDotById(@PathVariable int id) {
        return dotService.delete(id);
    }

}
