package com.shazi.testspringboot;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.shazi.testspringboot.controller.ItemController;
import com.shazi.testspringboot.model.Item;
import com.shazi.testspringboot.service.ItemService;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TestspringbootApplicationTests {
	@InjectMocks
	private ItemController itemcontroller;
	@Mock
	private ItemService itemService;
	// private Item item;

	@Mock
	private List list;

	@Test
	public void testgetallitems() {
		when(list.get(1)).thenReturn("second element");
		assertEquals("second element", list.get(1));
		List<Item> list1 = Stream.of(new Item(1, 123, "d1", "b1"), new Item(2, 234, "d2", "b2"))
				.collect(Collectors.toList());
		System.out.println(list1);
		when(itemService.getallItems()).thenReturn(list1);
		// given(itemService.getallItems()).willReturn(list1);
		assertEquals(2, itemService.getallItems().size());
	}

	
	
	
	  @Test public void testgetallitemslist() {
	  get("http://localhost:9090/api/v1/getAllitems").then().assertThat().
	  statusCode(200).body("size()", is(19));
	  
	  
	 }

		 
	 @Test
	 public void testresponseallitems()
	 {
		 RestAssured.baseURI = "http://localhost:9090/api/v1" ;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.request(Method.GET, "/getAllitems");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
	 }
	 @Test
	 public void testgetitemsbyid()
	 {
		 RestAssured.baseURI = "http://localhost:9090/api/v1/itemId" ;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/2");
		 int statusCode = response.getStatusCode();
		 assertEquals(statusCode, 200, "Correct status code returned");
		}
	 @Test
	 public void testgetAllids()
	 {
		 RestAssured.baseURI = "http://localhost:9090/api/v1/setofItemIds" ;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("/1,3,4,5");
		 int statusCode = response.getStatusCode();
		 assertEquals(statusCode, 200, "Correct status code returned");
		}
	 
}
