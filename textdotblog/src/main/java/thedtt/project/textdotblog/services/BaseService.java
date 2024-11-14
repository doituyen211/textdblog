package thedtt.project.textdotblog.services;


import org.springframework.stereotype.Service;
import thedtt.project.textdotblog.payload.response.ApiResponse;

@Service
public interface BaseService<T> {

    ApiResponse<?> getAll();
    ApiResponse<?> getById(Integer id);
    ApiResponse<?> add(T form);
    ApiResponse<?> delete(Integer id);
    ApiResponse<?> update(Integer id, T form);

}
