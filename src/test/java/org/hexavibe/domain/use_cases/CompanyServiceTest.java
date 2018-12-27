package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}