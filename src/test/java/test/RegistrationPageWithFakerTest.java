package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

@Tag("faker_test")
public class RegistrationPageWithFakerTest extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    TestData data = new TestData();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.emailAddress)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.dayOfBirth, data.mounthOfBirth, data.yearhOfBirth)

                .setSubject(data.subject)
                .setHobbiesWrapper(data.hobbies)
                .setUploadFromClasspath(data.pictureName)
                .setCurrentAddress(data.streetAddress)
                .setSelectState(data.state)
                .setSelectCity(data.city)
                .setSubmit();

        registrationPage.checkResult("Student Name", data.fullName)
                .checkResult("Student Email", data.emailAddress)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.birthday)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobbies)
                .checkResult("Picture", data.pictureName)
                .checkResult("Address", data.streetAddress)
                .checkResult("State and City", data.stateAndCity);

    }

   @Test
   void negativRegistrationTest() {
       registrationPage.openPage()
               .setSubmit();

       registrationPage.checkSubmitButtonBorderColor("border-color", "rgb(0, 98, 204)");
    }

}