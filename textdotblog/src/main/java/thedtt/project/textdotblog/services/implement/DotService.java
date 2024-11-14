package thedtt.project.textdotblog.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import thedtt.project.textdotblog.model.Dot;
import thedtt.project.textdotblog.payload.response.ApiResponse;
import thedtt.project.textdotblog.repositories.DotRepository;
import thedtt.project.textdotblog.services.BaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DotService {
    private final DotRepository dotRepository;
}
