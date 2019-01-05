package org.hexavibe.domain.use_cases;

import org.hexavibe.domain.entities.Company;
import org.hexavibe.domain.entities.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @Mock
    ContactPersistencePort contactPersistencePort;

    @InjectMocks
    ContactService contactService;

    @Test
    @DisplayName("Get Contact")
    void getContactByIdTest() throws ContactNotFoundException {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Contact contactMock = new Contact(
                "uuid21", "Mickey", "Mouse", LocalDate.of(1911, 02, 21), "1999", companyMock);

        Mockito.doReturn(contactMock).when(contactPersistencePort).getContactById(anyString());

        //WHEN
        Contact contactResult = this.contactService.getContactById("uuid21");

        //THEN
        assertEquals(contactMock, contactResult);
    }

    @Test
    @DisplayName("Update Company of Contact")
    void updateCompanyOfContactTest() throws ContactNotFoundException {
        //GIVEN
        Company newCompanyMock = new Company("MockitoBiz", "95");
        Contact updatedContactMock = new Contact(
                "uuid21", "Mickey", "Mouse", LocalDate.of(1911, 02, 21), "1999", newCompanyMock);

        Mockito.doReturn(updatedContactMock).when(contactPersistencePort).updateCompanyOfContact(anyString(), any(Company.class));

        //WHEN
        Contact contactResult = this.contactService
                .updateCompanyOfContact(
                        "uuid21",
                        newCompanyMock);

        //THEN
        assertEquals(updatedContactMock, contactResult);
    }

    @Test
    @DisplayName("Save Contact")
    void saveContactTest() {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Contact contactMock = new Contact(
                "uuid21", "Mickey", "Mouse", LocalDate.of(1911, 02, 21), "1999", companyMock);

        Mockito.doReturn(contactMock).when(contactPersistencePort).saveContact(any(Contact.class));

        //WHEN
        Contact contactResult = this.contactService.saveContact(contactMock);

        //THEN
        assertEquals(contactMock, contactResult);
    }

    @Test
    @DisplayName("Get All Contacts")
    void getAllContactsTest() {
        //GIVEN
        Company companyMock = new Company("MockBusiness", "21");
        Contact contactMock1 = new Contact(
                "uuid21", "Mickey", "Mouse", LocalDate.of(1911, 02, 21), "1999", companyMock);
        Contact contactMock2 = new Contact(
                "uuid212", "Mickey2", "Mouse2", LocalDate.of(1912, 03, 22), "1992", companyMock);
        List<Contact> contactsMock = Arrays.asList(contactMock1, contactMock2);

        Mockito.doReturn(contactsMock).when(contactPersistencePort).getAllContacts();

        //WHEN
        List<Contact> contactsResult = this.contactService.getAllContacts();

        //THEN
        assertEquals(contactsMock, contactsResult);
    }
}