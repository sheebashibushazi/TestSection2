package com.shazi.testspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TestspringbootApplicationTests {
@InjectMocks
	private ItemController itemcontroller;
	@Mock
	private ItemService itemService;
	
	@Test
	public void testgetallitems() {
		List<Item> list1=Stream.of(new Item(1, 123, "d1", "b1"), new Item(2, 234, "d2", "b2")).collect(Collectors.toList());
		System.out.println(list1);
		when(itemService.getallItems()).thenReturn(list1);		
		assertEquals(2, itemService.getallItems().size());
	}


}
