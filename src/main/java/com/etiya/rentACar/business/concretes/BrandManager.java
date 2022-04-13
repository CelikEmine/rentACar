package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.BrandDto;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.BrandDao;
import com.etiya.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private BrandDao brandDao;
    private ModelMapperService modelMapperService;

    public BrandManager(BrandDao brandDao,ModelMapperService modelMapperService) {
        this.brandDao = brandDao;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public Result add(CreateBrandRequest createBrandRequest) {

        checkIfBrandExist(createBrandRequest.getName());

        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brandDao.save(brand);

        return new SuccessResult(BusinessMessages.BrandMessages.BRAND_ADDED);
    }

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {

        this.brandDao.deleteById(deleteBrandRequest.getId());

        return new SuccessResult(BusinessMessages.BrandMessages.BRAND_DELETED);

    }

    @Override
    public Result update(UpdateBrandRequest updateBrandRequest) {

        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandDao.save(brand);

        return  new SuccessResult(BusinessMessages.BrandMessages.BRAND_UPDATED);
    }

    @Override
    public DataResult<List<ListBrandDto>> getAll() {

        List<Brand> brands=this.brandDao.findAll();

        List<ListBrandDto> response=brands.stream()
                .map(brand -> this.modelMapperService.forDto().map(brand,ListBrandDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListBrandDto>>(response);

    }

    @Override
    public DataResult<BrandDto> getById(int id) {

        Brand brand=this.brandDao.getById(id);

        BrandDto brandDto=this.modelMapperService.forDto().map(brand,BrandDto.class);

        return new SuccessDataResult<>(brandDto);
    }

    private void checkIfBrandExist(String brandName){
        if(this.brandDao.getByNameIgnoreCase(brandName).size()!=0){
            throw new RuntimeException(BusinessMessages.BrandMessages.EXISTED_BEFORE);
        }
    }

}
