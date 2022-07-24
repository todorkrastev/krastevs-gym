package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.ExerciseByCategoryDTO;
import com.todorkrastev.gym.model.dto.ExerciseDTO;
import com.todorkrastev.gym.model.entity.Exercise;
import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;
import com.todorkrastev.gym.repository.ExerciseRepository;
import com.todorkrastev.gym.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ExerciseByCategoryDTO> findAll() {
        return this.exerciseRepository
                .findAll()
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long createExercise(ExerciseDTO newExercise) {
        //TODO: Make an exception if someone tries to jump over my drop down menu and send a category that does not exist
        //TODO: example -> Categories -> ABS, CHEST, LEGS... / not existing Category -> Lola -> throw an exception
        Exercise exerciseToSave = this.modelMapper.map(newExercise, Exercise.class);

        this.exerciseRepository.save(exerciseToSave);

        return exerciseToSave.getId();
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryAbs(ExerciseCategoryName abs) {
        return this.exerciseRepository
                .findByExerciseCategoryName(abs)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryArms(ExerciseCategoryName arms) {
        return this.exerciseRepository
                .findByExerciseCategoryName(arms)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryBack(ExerciseCategoryName back) {
        return this.exerciseRepository
                .findByExerciseCategoryName(back)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryChest(ExerciseCategoryName chest) {
        return this.exerciseRepository
                .findByExerciseCategoryName(chest)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryLegs(ExerciseCategoryName legs) {
        return this.exerciseRepository
                .findByExerciseCategoryName(legs)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseByCategoryDTO> findByExerciseCategoryShoulders(ExerciseCategoryName shoulders) {
        return this.exerciseRepository
                .findByExerciseCategoryName(shoulders)
                .stream()
                .map(exercise -> this.modelMapper.map(exercise, ExerciseByCategoryDTO.class))
                .collect(Collectors.toList());
    }
}
