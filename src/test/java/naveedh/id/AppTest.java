package naveedh.id;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.bc.spring.AppController;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{	

	private MockMvc mockMvc;
	
	@Mock
	private AppController appController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
	}
	
    @Test
    public void testApp() throws Exception
    {
    	
    	when(appController.check()).thenReturn("Up and running");
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(MockMvcResultMatchers.content().string("Up and running"));
        
        
    }
    
    
}
