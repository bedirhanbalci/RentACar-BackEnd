package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Color;
import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
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
    public Result add(AddColorRequest addColorRequest) {

        this.colorBusinessRules.checkIfColorByNameExists(addColorRequest.getName());

        Color color = this.modelMapperService.forRequest()
                .map(addColorRequest, Color.class);
        color.setId(null);

        this.colorRepository.save(color);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteColorRequest deleteColorRequest) {

        this.colorBusinessRules.checkIfColorByIdExists(deleteColorRequest.getId());

        Color color = this.modelMapperService.forRequest()
                .map(deleteColorRequest, Color.class);

        this.colorRepository.delete(color);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateColorRequest updateColorRequest) {

        this.colorBusinessRules.checkIfColorByIdExists(updateColorRequest.getId());

        this.colorBusinessRules.checkIfColorByNameExists(updateColorRequest.getName());

        Color color = this.modelMapperService.forRequest()
                .map(updateColorRequest, Color.class);

        this.colorRepository.save(color);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllColorsResponse>> getAll() {

        List<Color> colors = colorRepository.findAll();

        List<GetAllColorsResponse> colorsResponse = colors.stream()
                .map(color -> this.modelMapperService.forResponse().map(color, GetAllColorsResponse.class)).toList();

        return new SuccessDataResult<>(colorsResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdColorResponse> getById(Integer id) {

        this.colorBusinessRules.checkIfColorByIdExists(id);

        GetByIdColorResponse response = this.modelMapperService.forResponse()
                .map(colorRepository.findById(id), GetByIdColorResponse.class);

        return new SuccessDataResult<>(response, Messages.GET);

    }

    @Override
    public boolean getColorById(Integer id) {

        return this.colorRepository.existsById(id);

    }

}
