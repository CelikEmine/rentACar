package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.CustomerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface CustomerService {

    Result add(CreateCustomerRequest createCustomerRequest);
    Result delete(DeleteCustomerRequest deleteCustomerRequest);
    Result update(UpdateCustomerRequest updateCustomerRequest);

    DataResult<List<ListCustomerDto>> getAll();
    DataResult<CustomerDto> getById(int id);
    DataResult<CustomerDto> getByLastCustomer();
}
