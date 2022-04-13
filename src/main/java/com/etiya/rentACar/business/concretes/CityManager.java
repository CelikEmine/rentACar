package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.cityResponses.CityDto;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CityDao;
import com.etiya.rentACar.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityManager implements CityService {

    private ModelMapperService modelMapperService;
    private CityDao cityDao;

    public CityManager(ModelMapperService modelMapperService, CityDao cityDao) {
        this.modelMapperService = modelMapperService;
        this.cityDao = cityDao;
    }

    @Override
    public Result add(CreateCityRequest createCityRequest) {

        checkIfCityExist(createCityRequest.getName());

        City city=this.modelMapperService.forRequest().map(createCityRequest,City.class);
        this.cityDao.save(city);

        return new SuccessResult(BusinessMessages.CityMessages.CİTY_ADDED);
    }

    @Override
    public Result delete(DeleteCityRequest deleteCityRequest) {

        this.cityDao.deleteById(deleteCityRequest.getId());

        return new SuccessResult(BusinessMessages.CityMessages.CİTY_DELETED);
    }

    @Override
    public Result update(UpdateCityRequest updateCityRequest) {

        City city=this.modelMapperService.forRequest().map(updateCityRequest,City.class);
        this.cityDao.save(city);

        return  new SuccessResult(BusinessMessages.CityMessages.CİTY_UPDATED);
    }

    @Override
    public DataResult<List<ListCityDto>> getAll() {

        List<City> cities=this.cityDao.findAll();

        List<ListCityDto> response=cities.stream()
                .map(city -> this.modelMapperService.forDto().map(city,ListCityDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCityDto>>(response);
    }

    @Override
    public DataResult<CityDto> getById(int id) {

        City city=this.cityDao.getById(id);
        CityDto cityDto=this.modelMapperService.forDto().map(city,CityDto.class);

        return new SuccessDataResult<>(cityDto);
    }


    public void checkIfCityExist(String cityName){
        if(this.cityDao.getByNameIgnoreCase(cityName).size()!=0){
            throw new RuntimeException(BusinessMessages.CityMessages.CİTY_REGISTERED_NAME);
        }
    }

}
