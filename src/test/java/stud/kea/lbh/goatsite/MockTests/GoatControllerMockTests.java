package stud.kea.lbh.goatsite.MockTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import stud.kea.lbh.goatsite.controller.api.GoatApiController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GoatApiController.class)
public class GoatControllerMockTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void canGetGoats() throws Exception {
        mockMvc.perform(get("/api/goats")
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

