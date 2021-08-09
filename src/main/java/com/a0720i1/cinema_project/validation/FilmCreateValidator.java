package com.a0720i1.cinema_project.validation;

import com.a0720i1.cinema_project.models.dto.film.CreateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.UpdateFilmDTO;
import com.a0720i1.cinema_project.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FilmCreateValidator implements Validator {

    @Autowired
    FilmService filmService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        CreateFilmDTO film = (CreateFilmDTO) object;
        if (film.getName() == null) {
            errors.rejectValue("name", "name.null", "Tên phim không được để trống");
        } else if (film.getName().length() > 300) {
            errors.rejectValue("name", "maxlength", "Tên phim dài tối đa 300 ký tự");
        } else if (!film.getName().matches("^[^`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:]*$")) {
            errors.rejectValue("name", "name.pattern", "Tên phim không bao gồm ký tự đặc biệt");
        }

        if (film.getImageURL() == null) {
            errors.rejectValue("image_url", "image_url.null", "Poster không được để trống");
        }

        if (film.getStartDate() == null) {
            errors.rejectValue("start_date", "start_date.null", "Start_date không được để trống");
        }

        if (film.getEndDate() == null) {
            errors.rejectValue("end_date", "end_date.null", "End_date không được để trống");
        }

        if (film.getActors() == null) {
            errors.rejectValue("actor", "actor.null", "Diễn viên không được để trống");
        } else if (film.getActors().length() > 300) {
            errors.rejectValue("actor", "maxlength", "Diễn viên dài tối đa 300 ký tự");
        }

        if (film.getStudio() == null) {
            errors.rejectValue("studio", "studio.null", "Hãng phim không được để trống");
        } else if (film.getStudio().length() > 200) {
            errors.rejectValue("studio", "maxlength", "Hãng phim dài tối đa 200 ký tự");
        }

        if (film.getDirectors() == null) {
            errors.rejectValue("directors", "directors.null", "Đạo diễn không được để trống");
        } else if (film.getDirectors().length() > 200) {
            errors.rejectValue("directors", "maxlength", "Đạo diễn dài tối đa 200 ký tự");
        }

        if (film.getTrailers() == null) {
            errors.rejectValue("trailers", "trailer.null", "Trailer không được để trống");
        }

        if (film.getCategory() == null) {
            errors.rejectValue("category", "category.null", "Thể loại không được để trống");
        } else if (film.getCategory().length() > 300) {
            errors.rejectValue("category", "maxlength", "Thể loại dài tối đa 300 ký tự");
        }

        if (film.getDescription() == null) {
            errors.rejectValue("description", "description.null", "Nội dung không được để trống");
        } else if (film.getDescription().length() > 500) {
            errors.rejectValue("description", "maxlength", "Nội dung dài tối đa 500 ký tự");
        }

        if (film.getAge() == null) {
            errors.rejectValue("description", "description.null", "Nội dung không được để trống");
        }

    }
}
