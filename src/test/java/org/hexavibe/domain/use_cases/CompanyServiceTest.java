package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    CompanyPersistencePort companyPersistencePort;

    @InjectMocks
    CompanyService companyService;

    @Test
    @DisplayName("Get Company by BusinessName")
    void getCompanyByBusinessNameTest() {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Mockito.doReturn(companyMock).when(companyPersistencePort).getCompanyByBusinessName(anyString());

        //WHEN
        Company companyResult = this.companyService.getCompanyByBusinessName("MockBusiness");

        //THEN
        assertEquals(companyMock, companyResult);
    }

    @Test
    @DisplayName("Get Company by SirenNumber")
    void getCompanyBySirenNumberTest() {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Mockito.doReturn(companyMock).when(companyPersistencePort).getCompanyBySirenNumber(anyString());

        //WHEN
        Company companyResult = this.companyService.getCompanyBySirenNumber("MockBusiness");

        //THEN
        assertEquals(companyMock, companyResult);
    }

    @Test
    @DisplayName("Save Company")
    void saveCompanyTest() {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Mockito.doReturn(companyMock).when(companyPersistencePort).saveCompany(any(Company.class));

        //WHEN
        Company companyResult = this.companyService.saveCompany(companyMock);

        //THEN
        assertEquals(companyMock, companyResult);
    }

    @Test
    @DisplayName("Get All Companies")
    void getAllCompaniesTest() {
        //GIVEN
        Company companyMock1 = new Company("MockBusiness1", "211");
        Company companyMock2 = new Company("MockBusiness2", "212");
        List<Company> companiesMock = Arrays.asList(companyMock1, companyMock2);
        Mockito.doReturn(companiesMock).when(companyPersistencePort).getAllCompanies();


        //WHEN
        List<Company> companiesResult = this.companyService.getAllCompanies();

        //THEN
        assertEquals(companiesMock, companiesResult);
    }
}