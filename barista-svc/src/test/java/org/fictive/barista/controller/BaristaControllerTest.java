package org.fictive.barista.controller;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.fictive.barista.service.BaristaService;
import org.fictive.barista.utils.APIConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class BaristaControllerTest {

	@Test
    void contextLoads() {
    }
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BaristaService baristaService;

   // @Test
    public void testProcessOrder() throws Exception {
        Long order_id = 1L;
        
        mockMvc.perform(MockMvcRequestBuilders.put("/process/{order_id}", order_id))
                .andExpect(status().isAccepted())
                .andExpect(content().string(APIConstant.PROCESS_ORDER));

        verify(baristaService, times(1)).processOrder(order_id);
    }

}