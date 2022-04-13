package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.RentalAdditionalServiceDetailService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.CreateRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.DeleteRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.UpdateRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.responses.brandResponses.BrandDto;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.ListRentalAdditionalServiceDetailDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.RentalAdditionalServiceDetailDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalAdditionalServiceDetailDao;
import com.etiya.rentACar.entities.concretes.Brand;
import com.etiya.rentACar.entities.concretes.RentalAdditionalServiceDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalAdditionalServiceDetailManager implements RentalAdditionalServiceDetailService {

    private ModelMapperService modelMapperService;
    private RentalAdditionalServiceDetailDao rentalAdditionalServiceDetailDao;

    public RentalAdditionalServiceDetailManager(ModelMapperService modelMapperService, RentalAdditionalServiceDetailDao rentalAdditionalServiceDetailDao) {
        this.modelMapperService = modelMapperService;
        this.rentalAdditionalServiceDetailDao = rentalAdditionalServiceDetailDao;
    }

    @Override
    public Result add(CreateRentalAdditionalServiceDetailRequest createRentalAdditionalServiceDetailRequest) {

        RentalAdditionalServiceDetail rentalAdditionalServiceDetail=this.modelMapperService.forRequest().map(createRentalAdditionalServiceDetailRequest,RentalAdditionalServiceDetail.class);
        rentalAdditionalServiceDetailDao.save(rentalAdditionalServiceDetail);

        return new SuccessResult();

    }

    @Override
    public Result delete(DeleteRentalAdditionalServiceDetailRequest deleteRentalAdditionalServiceDetailRequest) {

        this.rentalAdditionalServiceDetailDao.deleteById(deleteRentalAdditionalServiceDetailRequest.getId());

        return new SuccessResult();

    }

    @Override
    public Result update(UpdateRentalAdditionalServiceDetailRequest updateRentalAdditionalServiceDetailRequest) {

        RentalAdditionalServiceDetail rentalAdditionalServiceDetail=this.modelMapperService.forRequest().map(updateRentalAdditionalServiceDetailRequest,RentalAdditionalServiceDetail.class);
        this.rentalAdditionalServiceDetailDao.save(rentalAdditionalServiceDetail);

        return  new SuccessResult();

    }

    @Override
    public DataResult<List<ListRentalAdditionalServiceDetailDto>> getAll() {

        List<RentalAdditionalServiceDetail> rentalAdditionalServiceDetails=this.rentalAdditionalServiceDetailDao.findAll();

        List<ListRentalAdditionalServiceDetailDto> response=rentalAdditionalServiceDetails.stream()
                .map(rentalAdditionalServiceDetail -> this.modelMapperService.forDto().map(rentalAdditionalServiceDetail,ListRentalAdditionalServiceDetailDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListRentalAdditionalServiceDetailDto>>(response);
    }

    @Override
    public DataResult<RentalAdditionalServiceDetailDto> getById(int id) {

        RentalAdditionalServiceDetail rentalAdditionalServiceDetail=this.rentalAdditionalServiceDetailDao.getById(id);

        RentalAdditionalServiceDetailDto rentalAdditionalServiceDetailDto=this.modelMapperService.forDto().map(rentalAdditionalServiceDetail,RentalAdditionalServiceDetailDto.class);

        return new SuccessDataResult<>(rentalAdditionalServiceDetailDto);

    }

    @Override
    public DataResult<List<ListRentalAdditionalServiceDetailDto>> getByRentalId(int rentalId) {

        List<RentalAdditionalServiceDetail> rentalAdditionalServiceDetails=this.rentalAdditionalServiceDetailDao.getByRentalId(rentalId);

        List<ListRentalAdditionalServiceDetailDto> response=rentalAdditionalServiceDetails.stream()
                .map(rentalAdditionalServiceDetail -> this.modelMapperService.forDto().map(rentalAdditionalServiceDetail,ListRentalAdditionalServiceDetailDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListRentalAdditionalServiceDetailDto>>(response);

    }

    @Override
    public DataResult<List<ListRentalAdditionalServiceDetailDto>> getByAdditionalserviceId(int additionalServiceId) {

        List<RentalAdditionalServiceDetail> rentalAdditionalServiceDetails=this.rentalAdditionalServiceDetailDao.getByAdditionalserviceId(additionalServiceId);

        List<ListRentalAdditionalServiceDetailDto> response=rentalAdditionalServiceDetails.stream()
                .map(rentalAdditionalServiceDetail -> this.modelMapperService.forDto().map(rentalAdditionalServiceDetail,ListRentalAdditionalServiceDetailDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListRentalAdditionalServiceDetailDto>>(response);

    }
}
