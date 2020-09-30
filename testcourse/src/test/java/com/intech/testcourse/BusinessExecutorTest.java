package com.intech.testcourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BusinessExecutorTest {

	@Mock
	BusinessHelper mockedHelper;
	
	@Mock
	FileService mockedFileService;
		
	/**
	 * Test unitaire classique
	 */
	@Test
	void testExecute() {
		//Arrange
		int rank = 2;
		BusinessExecutor be = new BusinessExecutor(new BusinessHelper());
		
		//Act
		int result = be.execute(rank);
		
		//Assert
		assertEquals(4, result);
	}

	/**
	 * Test unitaire avec BusinessHelper mocké.
	 */
	@Test
	void testExecuteWithMock() {
		//Arrange
		BusinessExecutor be = new BusinessExecutor(mockedHelper);
		when(mockedHelper.treatment()).thenReturn(4);
		
		//Act
		int result = be.execute(2);
		
		//Assert
		verify(mockedHelper).treatment();
		assertEquals(8, result);
	}
	
	/**
	 * Test unitaire avec FileService mocké.
	 */
	@Test
	void testToUpperText() {
		//Arrange
		BusinessExecutor be = new BusinessExecutor(new BusinessHelper());
		be.setFileService(mockedFileService);
		when(mockedFileService.getInfo()).thenReturn("test");
		
		//Act
		String info = be.toUpperText();
		
		//Assert
		verify(mockedFileService).getInfo();
		assertEquals("TEST", info);
	}


}
