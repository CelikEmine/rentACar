package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.DamageDao;
import com.etiya.rentACar.entities.concretes.Damage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DamageManager implements DamageService {

    private DamageDao damageDao;
    private ModelMapperService modelMapperService;

    public DamageManager(DamageDao damageDao, ModelMapperService modelMapperService,CarService carService) {
        this.damageDao = damageDao;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public Result add(CreateDamageRequest createDamageRequest) {

        Damage damage=this.modelMapperService.forRequest().map(createDamageRequest,Damage.class);
        damageDao.save(damage);

        return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_ADDED);
    }

    @Override
    public Result update(UpdateDamageRequest updateDamageRequest) {

        Damage damage=this.modelMapperService.forRequest().map(updateDamageRequest,Damage.class);
        this.damageDao.save(damage);

        return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_UPDATED);
    }

    @Override
    public Result delete(DeleteDamageRequest deleteDamageRequest) {

        this.damageDao.deleteById(deleteDamageRequest.getId());

        return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_DELETED);
    }

    @Override
    public DataResult<List<ListDamageDto>> getAll() {

        List<Damage> damages=this.damageDao.findAll();

        List<ListDamageDto> response=damages.stream()
                .map(damage -> this.modelMapperService.forDto().map(damage,ListDamageDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<>(response);

    }

    @Override
    public DataResult<DamageDto> getById(int id) {

        Damage result=this.damageDao.getById(id);
        DamageDto response=this.modelMapperService.forDto().map(result,DamageDto.class);

        return new SuccessDataResult<>(response);
    }


    @Override
    public DataResult<List<ListDamageDto>> getAllPaged(int pageNo, int pageSize) {

        Pageable pageable= PageRequest.of(pageNo-1,pageSize);

        List<Damage> damages= this.damageDao.findAll(pageable).getContent();

        List<ListDamageDto> response=damages.stream()
                .map(damage -> this.modelMapperService.forDto().map(damage,ListDamageDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<>(response);
    }



    @Override
    public DataResult<List<ListDamageDto>> getAllSorted(String option,String field) {

        Sort sort=Sort.by(Sort.Direction.valueOf(option),field);

        List<Damage> damages=this.damageDao.findAll(sort);

        List<ListDamageDto> response=damages.stream()
                .map(damage -> this.modelMapperService.forDto().map(damage,ListDamageDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response);

    }

    @Override
    public DataResult<List<ListDamageDto>> getAllByCarId(int id) {

        List<Damage> damages = this.damageDao.getAllByCarId(id);

        List<ListDamageDto> response=damages.stream()
                .map(damage -> this.modelMapperService.forDto().map(damage,ListDamageDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response);
    }


}
