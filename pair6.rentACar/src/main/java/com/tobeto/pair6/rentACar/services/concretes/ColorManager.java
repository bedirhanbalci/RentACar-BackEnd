package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Color;
import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;
import com.tobeto.pair6.rentACar.services.rules.ColorBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    private final ColorBusinessRules colorBusinessRules;

    @Override
    public void add(AddColorRequest addColorRequest) {

        this.colorBusinessRules.checkIfColorByNameExists(addColorRequest.getName());

        Color color = this.modelMapperService.forRequest().map(addColorRequest, Color.class);

        this.colorRepository.save(color);
    }

    @Override
    public void delete(DeleteColorRequest deleteColorRequest) {

        this.colorBusinessRules.checkIfColorByIdExists(deleteColorRequest.getId());

        Color color = this.modelMapperService.forRequest().map(deleteColorRequest, Color.class);

        this.colorRepository.delete(color);
    }

    @Override
    public void update(UpdateColorRequest updateColorRequest) {

        this.colorBusinessRules.checkIfColorByIdExists(updateColorRequest.getId());

        this.colorBusinessRules.checkIfColorByNameExists(updateColorRequest.getName());

        Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);

        this.colorRepository.save(color);
    }

    @Override
    public List<GetAllColorsResponse> getAll() {

        List<Color> colors = colorRepository.findAll();

        List<GetAllColorsResponse> colorsResponse = colors.stream()
                .map(color -> this.modelMapperService.forResponse().map(color, GetAllColorsResponse.class)).toList();
        return colorsResponse;
    }

    @Override
    public GetByIdColorResponse getById(int id) {

        this.colorBusinessRules.checkIfColorByIdExists(id);

        GetByIdColorResponse response = this.modelMapperService.forResponse().map(colorRepository.findById(id), GetByIdColorResponse.class);
        return response;
    }

    @Override
    public boolean getColorById(int id) {
        return this.colorRepository.existsById(id);
    }
}
