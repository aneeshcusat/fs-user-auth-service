package com.fs.service.auth.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "FS User Auth API", version = "1.0", description = "Documentation APIs v1.0",
                license = @License(name = "User Auth", url = "https://userauth.com")))
public class SwaggerConfig {

    /*
     * @Bean public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) { return
     * new OpenAPI() .components(new Components().addSecuritySchemes("basicScheme", new
     * SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))) .info(new
     * Info().title("FService API").version(appVersion) .license(new
     * License().name("Infleca 1.0").url("https://infleca.com"))); }
     */
    /*
     * @Bean public GroupedOpenApi usersOpenApi() { String[] paths = {"/api/v1/users/**"}; String[]
     * packagedToMatch = {"e com.fs.ps.adapter.service.controller"}; return
     * GroupedOpenApi.builder().group("USERS").pathsToMatch(paths)
     * .packagesToScan(packagedToMatch).build(); }
     *
     * @Bean public GroupedOpenApi hrmsOpenApi() { String[] paths = {"/api/v1/employees/**"}; String[]
     * packagedToMatch = {"e com.fs.ps.adapter.service.controller"}; return
     * GroupedOpenApi.builder().group("HRMS").pathsToMatch(paths)
     * .packagesToScan(packagedToMatch).build(); }
     */
}
