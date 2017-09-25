package test.quantum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import test.quantum.controller.EmployeeManagingController;
import test.quantum.service.EmployeeService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestEmployeeManagingController {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;


    @InjectMocks
    private EmployeeManagingController employeeManagingController;


    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(employeeManagingController).build();
    }

    @Test
    public void testPostSetEmployee() throws Exception {

        this.mockMvc.perform(post("/set-employee-count")
                .param("count_employees", "10"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetSetEmployee() throws Exception {

        this.mockMvc.perform(get("/get-employee/true/Abell/Kyiv/0/HR/").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/get-employee/false/Abell/Kyiv/0/HR/").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }


}