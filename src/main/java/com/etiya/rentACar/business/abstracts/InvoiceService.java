package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.InvoiceDto;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    DataResult<Invoice> add(CreateInvoiceRequest createInvoiceRequest);
    Result update(UpdateInvoiceRequest updateInvoiceRequest);
    Result delete(DeleteInvoiceRequest deleteInvoiceRequest);

    DataResult<List<ListInvoiceDto>> getAll();

    DataResult<InvoiceDto> getById(int id);

    DataResult<List<ListInvoiceDto>> getAllCreateDateBetween(LocalDate firstDate, LocalDate endDate);

    DataResult<List<ListInvoiceDto>> getByCustomerId(int id);

}
