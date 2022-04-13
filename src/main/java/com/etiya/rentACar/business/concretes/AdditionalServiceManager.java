package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.AdditionalServiceService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.AdditionalServiceDao;
import com.etiya.rentACar.entities.concretes.AdditionalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdditionalServiceManager implements AdditionalServiceService {

    private ModelMapperService modelMapperService;
    private AdditionalServiceDao additionalServiceDao;

    public AdditionalServiceManager(ModelMapperService modelMapperService, AdditionalServiceDao additionalServiceDao) {
        this.modelMapperService = modelMapperService;
        this.additionalServiceDao = additionalServiceDao;
    }

    @Override
    public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequests) {

       checkIfCityExist(createAdditionalServiceRequests.getName());

       AdditionalService additionalService=this.modelMapperService.forRequest().map(createAdditionalServiceRequests,AdditionalService.class);
       this.additionalServiceDao.save(additionalService);

       return new SuccessResult(BusinessMessages.AdditionalServiceMessages.ADDITIONAL_SERVİCE_ADDED);

    }

    @Override
    public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequests) {

        this.additionalServiceDao.deleteById(deleteAdditionalServiceRequests.getId());

        return new SuccessResult(BusinessMessages.AdditionalServiceMessages.ADDITIONAL_SERVİCE_DELETED);
    }

    @Override
    public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequests) {

        AdditionalService additionalService=this.modelMapperService.forRequest().map(updateAdditionalServiceRequests,AdditionalService.class);
        this.additionalServiceDao.save(additionalService);

        return new SuccessResult(BusinessMessages.AdditionalServiceMessages.ADDITIONAL_SERVİCE_UPDATED);

    }

    @Override
    public DataResult<List<ListAdditionalServiceDto>> getAll() {

        List<AdditionalService> additionalServices=this.additionalServiceDao.findAll();

        List<ListAdditionalServiceDto> response=additionalServices.stream()
                .map(additionalService -> this.modelMapperService.forDto().map(additionalService,ListAdditionalServiceDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<List<ListAdditionalServiceDto>>(response);

    }

    @Override
    public DataResult<AdditionalServiceDto> getById(int id) {

        AdditionalService additionalService=this.additionalServiceDao.getById(id);

        AdditionalServiceDto additionalServiceDto=this.modelMapperService.forDto().map(additionalService,AdditionalServiceDto.class);

        return new SuccessDataResult<>(additionalServiceDto);
    }

    public void checkIfCityExist(String cityName){
        if(this.additionalServiceDao.getByNameIgnoreCase(cityName).size()!=0){
            throw new RuntimeException(BusinessMessages.AdditionalServiceMessages.ADDITIONAL_SERVİCE_REGISTERED_NAME);
        }
    }
}
