package stepDefinition;

//import cucumber.api.java.Before;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Exception {
		
		PlaceValidation place = new PlaceValidation();
		
		if(PlaceValidation.place_id == null) {
		place.add_Place_Payload_with("Nishanth", "German", "United Kingdom");
		place.user_calls_with_http_request("addPlaceApi", "POST");
		place.verify_place_Id_created_maps_to_using("Nishanth", "getPlaceApi");
		}
	}

}
