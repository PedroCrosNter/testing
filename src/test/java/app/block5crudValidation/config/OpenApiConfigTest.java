package app.block5crudValidation.config;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {OpenApiConfig.class})
class OpenApiConfigTest {

    @MockBean
    private Info mockInfo;

//    @Test
//    void customOpenAPI() {
//        // Mocking the Info object
//        when(mockInfo.getTitle()).thenReturn("Students Controller");
//        when(mockInfo.getVersion()).thenReturn("69");
//        when(mockInfo.getDescription()).thenReturn("API Pedro");
//
//        // Creating the OpenAPI object
//        OpenAPI openAPI = new OpenAPI().info(mockInfo);
//
//        // Creating the OpenApiConfig instance
//        OpenApiConfig openApiConfig = new OpenApiConfig();
//
//        // Retrieving the OpenAPI object created by the customOpenAPI method
//        OpenAPI result = openApiConfig.customOpenAPI();
//
//        // Asserting that the OpenAPI object is created correctly
//        assertEquals(openAPI, result);
//    }
}
