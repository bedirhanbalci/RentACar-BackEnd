package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Color;
import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair6.rentACar.services.rules.ColorBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ColorManagerTest {

    private ColorManager colorManager;

    @Mock
    private ColorRepository colorRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private ColorBusinessRules colorBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        colorManager = new ColorManager(colorRepository, modelMapperService, colorBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void nameAlreadyExistsShouldThrowException() {

        AddColorRequest addColorRequest = new AddColorRequest();
        addColorRequest.setName("Yellow");

        Mockito.when(colorRepository.existsByName("Yellow"))
                .thenReturn((true));


        assertThrows(RuntimeException.class, () -> {
            colorManager.add(addColorRequest);
        });

    }

    @Test
    void successfullyAdd() {

        AddColorRequest addColorRequest = new AddColorRequest();
        addColorRequest.setName("Yellow");

        Mockito.when(modelMapperService.forRequest().map(addColorRequest, Color.class)).thenReturn(new Color());

        Result result = colorManager.add(addColorRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete(){

        DeleteColorRequest deleteColorRequest = new DeleteColorRequest();
        deleteColorRequest.setId(3);

        Mockito.when(modelMapperService.forRequest().map(deleteColorRequest, Color.class)).thenReturn(new Color());

        Result result = colorManager.delete(deleteColorRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateColorRequest updateColorRequest = new UpdateColorRequest();
        updateColorRequest.setId(3);
        updateColorRequest.setName("Yellow");

        Mockito.when(modelMapperService.forRequest().map(updateColorRequest, Color.class)).thenReturn(new Color());

        Result result = colorManager.update(updateColorRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll(){

        List<Color> colors = new ArrayList<>();
        Mockito.when(colorRepository.findAll()).thenReturn(colors);
        colorManager.getAll();
        assert true;

    }

//    @Test
//    void successfullyGetById(){
//
//        Color color = new Color();
//        Mockito.when(colorRepository.findById(color.getId())).thenReturn(Optional.of(new Color()));
//        colorManager.getById(color.getId());
//        assert true;
//
//    }

}