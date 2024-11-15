package thedtt.project.textdotblog.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import thedtt.project.textdotblog.form.DotForm;
import thedtt.project.textdotblog.model.Dot;
import thedtt.project.textdotblog.payload.response.ApiResponse;
import thedtt.project.textdotblog.repositories.DotRepository;
import thedtt.project.textdotblog.services.BaseService;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DotService implements BaseService<DotForm> {

    private final DotRepository dotRepository;

    @Override
    public ApiResponse<?> getAll() {
        try {
            List<Dot> dots = dotRepository.findAll();
            return ApiResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("Get All Dot Successfully !")
                    .data(dots)
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
            Optional<Dot> dot = dotRepository.findById(id);
            return ApiResponse.builder()
                    .code(HttpStatus.OK.value())
                    .message("Get Dot by " + id + " Successfully !")
                    .data(dot)
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
            Optional<Dot> dot = dotRepository.findById(id);

            if (dot.isPresent()) {
                Dot d = dot.get();
                dotRepository.delete(d);

                return ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Delete Dot by " + id + " Successfully !")
                        .data(d)
                        .build();
            } else {
                return ApiResponse.builder()
                        .code(HttpStatus.NOT_FOUND.value())
                        .message("Dot not found with id " + id)
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
    public ApiResponse<?> update(Integer id, DotForm form) {
        return null;
    }

    @Override
    public ApiResponse<?> add(DotForm form) {
        return null;
    }
}
